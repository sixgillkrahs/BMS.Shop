package com.main.backend.Service.Service;

import com.main.backend.Domain.Model.Options.Color;
import com.main.backend.Domain.Model.Options.Size;
import com.main.backend.Domain.Model.Options.Stock;
import com.main.backend.Repository.ColorRepository;
import com.main.backend.Repository.SizeRepository;
import com.main.backend.Repository.StockRepository;
import com.main.backend.Service.IService.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class StockService implements IStockService {

    @Autowired
    public StockRepository stockRepository;

    @Autowired
    public ColorRepository colorRepository;

    @Autowired
    public SizeRepository sizeRepository;

    @Override
    public Map<String, String> addColor(String color) {
        colorRepository.save(new Color(color));
        return Map.of("message", "true");
    }

    @Override
    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public String getNameSizebyId(UUID id) {
        Size size = sizeRepository.findById(id).get();
        return size.name;
    }

    @Override
    public String getNameColorbyId(UUID id) {
        Color color = colorRepository.findById(id).get();
        return color.name;
    }

    @Override
    public List<Stock> getStocksByProductId(UUID id) {
        List<Stock> stocks = new ArrayList<>();
        for (Stock stock : stockRepository.findAll()) {
            if (stock.productId.equals(id)) {
                stocks.add(stock);
            }
        }
        return stocks;
    }
}
