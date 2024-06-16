package com.main.backend.Domain.Dto.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateProduct {
    public String name;
    public double price;
    public Date updated_At;
    public int promotion;
    public UUID categoryId;
    public UUID brandId;
    public int quantity;
    public String description;
    public String thumnailimage;
    public Character isActive;
}
