package com.main.backend.Domain.Dto.Options;

import java.util.UUID;

public class CreateUpdateStockDto {
    public int quantity;
    public UUID productId;
    public UUID sizeId;
    public UUID colorId;
    public String image;
    public String sku;
}
