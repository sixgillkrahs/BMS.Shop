package com.main.backend.Service.Service;

import com.main.backend.Repository.ProductRepository;
import com.main.backend.Service.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService implements IProductService {

    @Autowired
    public ProductRepository productRepository;

}
