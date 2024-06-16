package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Categories.CategoryDto;
import com.main.backend.Domain.Dto.Manufacturers.ManufacturerDto;
import com.main.backend.Domain.Dto.Products.CreateUpdateProduct;
import com.main.backend.Domain.Dto.Products.ProductDto;
import com.main.backend.Domain.Model.Products.Product;
import com.main.backend.Repository.ProductRepository;
import com.main.backend.Service.IService.IProductService;
import com.main.backend.Utils.Exception.ErrorCode;
import com.main.backend.Utils.Exception.HandleRuntimeException;
import com.main.backend.Utils.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductService implements IProductService {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public ManufacturerService manufacturerService;

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> list = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            CategoryDto category =  categoryService.getCategoryById(product.categoryId);
            ManufacturerDto brand = manufacturerService.getManufacturerById(product.brandId);
            product.categoryName = category.name;
            product.brandName = brand.name;
            list.add(ProductMapper.toProductDto(product));
        }
        return list;
    }

    @Override
    public ProductDto getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new HandleRuntimeException(ErrorCode.PRODUCT_NOT_FOUND));
        CategoryDto category =  categoryService.getCategoryById(product.categoryId);
        ManufacturerDto brand = manufacturerService.getManufacturerById(product.brandId);
        product.categoryName = category.name;
        product.brandName = brand.name;
        return ProductMapper.toProductDto(product);
    }

    @Override
    public ProductDto updateProduct(UUID id, CreateUpdateProduct input) {
        Product product = productRepository.findById(id).orElseThrow(() -> new HandleRuntimeException(ErrorCode.PRODUCT_NOT_FOUND));
        CategoryDto category =  categoryService.getCategoryById(input.categoryId);
        ManufacturerDto brand = manufacturerService.getManufacturerById(input.brandId);
        product.name = input.name;
        product.price = input.price;
        product.categoryId = input.categoryId;
        product.brandId = input.brandId;
        product.categoryName = category.name;
        product.brandName = brand.name;
        product.quantity = input.quantity;
        product.description = input.description;
        product.thumnailimage = input.thumnailimage;
        product.promotion = input.promotion;
        product.isActive = input.isActive;
        productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    @Override
    public ProductDto saveProduct(CreateUpdateProduct input) {
        Product product = new Product();
        CategoryDto category =  categoryService.getCategoryById(input.categoryId);
        ManufacturerDto brand = manufacturerService.getManufacturerById(input.brandId);
        product.name = input.name;
        product.price = input.price;
        product.categoryId = input.categoryId;
        product.brandId = input.brandId;
        product.categoryName = category.name;
        product.brandName = brand.name;
        product.quantity = input.quantity;
        product.description = input.description;
        product.thumnailimage = input.thumnailimage;
        product.promotion = input.promotion;
        product.isActive = input.isActive;
        product.created_At = new Date(System.currentTimeMillis());
        productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new HandleRuntimeException(ErrorCode.PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }


}
