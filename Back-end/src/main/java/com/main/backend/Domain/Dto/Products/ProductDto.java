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
public class ProductDto {
    public UUID id ;
    public String name;
    public String description;
    public String categoryName;
    public String brandName;
    public String thumnailimage;
}
