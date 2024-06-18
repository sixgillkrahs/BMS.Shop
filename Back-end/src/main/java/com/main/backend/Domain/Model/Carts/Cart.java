package com.main.backend.Domain.Model.Carts;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private int status;
    @Column(name = "shippingfee")
    private int shippingFee;
    @Column(name = "total")
    private double total;
    private double discount;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "user_phone")
    private String userPhone;
}
