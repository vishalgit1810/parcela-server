package com.parcela.parcela_server.repository;

import com.parcela.parcela_server.entity.Booking;
import com.parcela.parcela_server.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer(Customer customer);
}