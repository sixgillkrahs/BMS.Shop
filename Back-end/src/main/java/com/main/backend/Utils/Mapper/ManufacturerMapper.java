package com.main.backend.Utils.Mapper;

import com.main.backend.Domain.Dto.Manufacturers.ManufacturerDto;
import com.main.backend.Domain.Model.Manufacturers.Manufacturer;

public class ManufacturerMapper {
    public static ManufacturerDto toManufacturerDto(Manufacturer manufacturer) {
        ManufacturerDto manufacturerDto = new ManufacturerDto();
        manufacturerDto.setId(manufacturer.getId());
        manufacturerDto.setName(manufacturer.getName());
        manufacturerDto.setIsactive(manufacturer.getIsActive());
        return manufacturerDto;
    }
}
