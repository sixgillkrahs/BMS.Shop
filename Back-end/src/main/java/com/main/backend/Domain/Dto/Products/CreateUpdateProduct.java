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
    public UUID categoryId;
    public UUID brandId;
    public String description;
    public String thumnailimage;
    public Character isActive;
}
