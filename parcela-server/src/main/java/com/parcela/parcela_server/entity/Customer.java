package com.parcela.parcela_server.entity;
import com.parcela.parcela_server.config.CustomerIdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "cust_id_gen")
    @GenericGenerator(
            name = "cust_id_gen",
            type = CustomerIdGenerator.class
    )
    private String custId;
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)

    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Payment> payments;
}