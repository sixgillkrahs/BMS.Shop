package com.main.backend.Service.IService;

import com.main.backend.Domain.Dto.Options.CreateUpdateStockDto;
import com.main.backend.Domain.Dto.Products.CreateUpdateProduct;
import com.main.backend.Domain.Dto.Products.ProductDto;
import com.main.backend.Domain.Dto.Users.LoginDto;
import com.main.backend.Domain.Model.Options.Color;
import com.main.backend.Domain.Model.Options.Size;
import com.main.backend.Domain.Model.Options.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IProductService {
    public List<ProductDto> getAllProducts();

    public  ProductDto getProductById(UUID id);

    public ProductDto updateProduct(UUID id, CreateUpdateProduct input);
    public ProductDto saveProduct(CreateUpdateProduct input);

    public void deleteProduct(UUID id);

    public Stock addStock(CreateUpdateStockDto stock, UUID productId);

    public List<Stock> getStocksByProductId(UUID id);

    public List<Color> getColorsByProductId(UUID id);

    public List<Size> getSizesByProductId(UUID id);


}
