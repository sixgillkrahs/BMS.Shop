package com.main.backend.Service.IService;

import com.main.backend.Domain.Model.Options.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface IStockService {
    public Map<String,String> addColor(String color);
    public Stock addStock(Stock stock);
    public String getNameSizebyId(UUID id);
    public String getNameColorbyId(UUID id);
    public List<Stock> getStocksByProductId(UUID id);
}
