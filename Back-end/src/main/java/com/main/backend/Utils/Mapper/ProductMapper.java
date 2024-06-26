package com.main.backend.Utils.Mapper;

import com.main.backend.Domain.Dto.Products.ProductDto;
import com.main.backend.Domain.Model.Products.Product;

public class ProductMapper {
    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategoryName(),
                product.getBrandName(),
                product.getThumnailimage()
        );

    }
}
