package com.main.backend.Domain.Model.Carts;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "cartitem")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CartItemId.class)
public class CartItem {
    @Id
    @Column(name = "cartid")
    private UUID cartid;
    @Id
    @Column(name = "productid")
    private UUID productid;
    @Id
    @Column(name = "colorid")
    private UUID colorid;
    @Id
    @Column(name = "sizeid")
    private UUID sizeid;
    private String productname;
    private int quantity;
    private double price;
    private String colorname;
    private String sizename;
    private String thumnailimage;
}
