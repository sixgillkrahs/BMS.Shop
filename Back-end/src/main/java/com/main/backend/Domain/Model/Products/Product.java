package com.main.backend.Domain.Model.Products;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id = UUID.randomUUID();
    @Column(name = "category_id")
    public UUID categoryId;
    @Column(name = "brand_id")
    public UUID brandId;
    public String name;
    public double price;
    @Column(name="created_at")
    public Date created_At;
    @Column(name="updated_at")
    public Date updated_At;
    public int promotion;
    public int quantity;
    public String description;
    @Column(name="isactive")
    public Character isActive;
    @Column(name="cateogryname")
    public String categoryName;
    @Column(name="brandname")
    public String brandName;
    public String thumnailimage;


}
