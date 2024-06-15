package com.main.backend.Service.IService;

import com.main.backend.Domain.Dto.Manufacturers.CreateUpdateManufacturerDto;
import com.main.backend.Domain.Dto.Manufacturers.ManufacturerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IManufacturerService {

    public List<ManufacturerDto> getAllManufacturers();
    public ManufacturerDto getManufacturerById(UUID id);
    public ManufacturerDto saveManufacturer(CreateUpdateManufacturerDto input);
    public ManufacturerDto updateManufacturer(UUID id, CreateUpdateManufacturerDto input);
    public void deleteManufacturer(UUID id);
}
