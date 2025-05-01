package com.parcela.parcela_server.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {
    private String receiverName;
    private String address;
    private String pincode;
    private String mobileNumber;
    private double parcelWeight;
    private String description;
    private String packingPreference;
    private LocalDateTime pickupTime;
    private LocalDateTime dropoffTime;
    private double serviceCost;
    private Long customerId;
}