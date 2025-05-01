package com.parcela.parcela_server.service.impl;

import com.parcela.parcela_server.dto.PaymentDto;
import com.parcela.parcela_server.entity.*;
import com.parcela.parcela_server.exception.CustomException;
import com.parcela.parcela_server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Payment makePayment(PaymentDto paymentDto) {
        Customer customer = customerRepository.findById(paymentDto.getCustomerId())
                .orElseThrow(() -> new CustomException("Customer not found"));

        Booking booking = bookingRepository.findById(paymentDto.getOrderId())
                .orElseThrow(() -> new CustomException("Booking not found"));

        if (!booking.getCustomer().equals(customer)) {
            throw new CustomException("You can only pay for your own bookings");
        }

        if (!"PENDING".equals(booking.getOrderStatus())) {
            throw new CustomException("Payment can only be made for PENDING bookings");
        }

        Payment payment = new Payment();
        payment.setPaymentType(paymentDto.getPaymentType());
        payment.setAmount(booking.getServiceCost());
        payment.setStatus("COMPLETED");
        payment.setCustomer(customer);
        payment.setBooking(booking);

        booking.setPaymentTime(LocalDateTime.now());
        booking.setOrderStatus("PROCESSING");
        bookingRepository.save(booking);

        return paymentRepository.save(payment);
    }
}
