package com.main.backend.Controller;


import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Options.CreateUpdateStockDto;
import com.main.backend.Domain.Dto.Products.CreateUpdateProduct;
import com.main.backend.Domain.Dto.Products.ProductDto;
import com.main.backend.Domain.Model.Options.Color;
import com.main.backend.Domain.Model.Options.Size;
import com.main.backend.Domain.Model.Options.Stock;
import com.main.backend.Service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @CrossOrigin
    @GetMapping("/all")
    public APIRepository<List<ProductDto>> getAllProducts(){
        APIRepository<List<ProductDto>> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.getAllProducts());
        return repository;
    }

    @CrossOrigin
    @GetMapping("/get/{id}")
    public APIRepository<ProductDto> getProductById(@PathVariable UUID id){
        APIRepository<ProductDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.getProductById(id));
        return repository;
    }

    @PutMapping("/update/{id}")
    public APIRepository<ProductDto> updateProduct(@PathVariable UUID id, @RequestBody CreateUpdateProduct input){
        APIRepository<ProductDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.updateProduct(id, input));
        return repository;
    }

    @PostMapping("/save")
    public APIRepository<ProductDto> saveProduct(@RequestBody CreateUpdateProduct input){
        APIRepository<ProductDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.saveProduct(input));
        return repository;
    }

    @DeleteMapping("/delete/{id}")
    public APIRepository<String> deleteProduct(@PathVariable UUID id){
        APIRepository<String> repository = new APIRepository<>();
        repository.setCode(1000);
        productService.deleteProduct(id);
        repository.setMessage("delete product successfully");
        return repository;
    }

    @PostMapping("/addstock/{id}")
    public Stock addStock(@RequestBody CreateUpdateStockDto stock , @PathVariable UUID id){
        return productService.addStock(stock,id);
    }

    @CrossOrigin
    @GetMapping("/stocks/{id}")
    public APIRepository<List<Stock>> getStocksByProductId(@PathVariable UUID id){
        APIRepository<List<Stock>> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.getStocksByProductId(id));
        return repository;
    }

    @CrossOrigin
    @GetMapping("/colors/{id}")
    public APIRepository<List<Color>> getColorsByProductId(@PathVariable UUID id){
        APIRepository<List<Color>> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.getColorsByProductId(id));
        return repository;
    }

    @CrossOrigin
    @GetMapping("/sizes/{id}")
    public APIRepository<List<Size>> getSizesByProductId(@PathVariable UUID id){
        APIRepository<List<Size>> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(productService.getSizesByProductId(id));
        return repository;
    }



}
