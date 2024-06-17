package com.main.backend.Domain.Model.Options;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "stock")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;
    @Column(name = "qty_in_stock")
    public int quantity;
    @Column(name = "product_id")
    public UUID productId;
    @Column(name = "size_id")
    public UUID sizeId;
    @Column(name = "color_id")
    public UUID colorId;
    @Column(name = "size_name")
    public String sizeName;
    @Column(name = "color_name")
    public String colorName;
    @Column(name = "product_name")
    public String productName;
    public String image;
    public String sku;

    public Stock(int quantity, UUID productId, UUID sizeId, UUID colorId, String sizeName, String colorName, String productName, String image, String sku) {
        this.quantity = quantity;
        this.productId = productId;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.sizeName = sizeName;
        this.colorName = colorName;
        this.productName = productName;
        this.image = image;
        this.sku = sku;
    }
}
