package com.main.backend.Service.Service;

import com.main.backend.Domain.Dto.Manufacturers.CreateUpdateManufacturerDto;
import com.main.backend.Domain.Dto.Manufacturers.ManufacturerDto;
import com.main.backend.Domain.Model.Categories.Category;
import com.main.backend.Domain.Model.Manufacturers.Manufacturer;
import com.main.backend.Repository.ManufacturerRepository;
import com.main.backend.Service.IService.IManufacturerService;
import com.main.backend.Utils.Exception.ErrorCode;
import com.main.backend.Utils.Exception.HandleRuntimeException;
import com.main.backend.Utils.Mapper.CategoryMapper;
import com.main.backend.Utils.Mapper.ManufacturerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ManufacturerService implements IManufacturerService {

    @Autowired
    public ManufacturerRepository manufacturerRepository;


    @Override
    public List<ManufacturerDto> getAllManufacturers() {
        List<ManufacturerDto> manufacturersDto = new ArrayList<>();
        for (Manufacturer manufacturer : manufacturerRepository.findAll()) {
            manufacturersDto.add(ManufacturerMapper.toManufacturerDto(manufacturer));
        }
        return manufacturersDto;
    }

    @Override
    public ManufacturerDto getManufacturerById(UUID id) {
        return ManufacturerMapper.toManufacturerDto(manufacturerRepository
                .findById(id).orElseThrow(()-> new HandleRuntimeException(ErrorCode.MANUFACTURER_NOT_FOUND)));
    }

    @Override
    public ManufacturerDto saveManufacturer(CreateUpdateManufacturerDto input) {
        manufacturerRepository.existsByName(input.getName());
        Manufacturer manufacturer = new Manufacturer(input.getName());
        manufacturerRepository.save(manufacturer);
        return ManufacturerMapper.toManufacturerDto(manufacturer);
    }

    @Override
    public ManufacturerDto updateManufacturer(UUID id, CreateUpdateManufacturerDto input) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(()->new HandleRuntimeException(ErrorCode.MANUFACTURER_NOT_FOUND));
        manufacturer.setName(input.getName());
        manufacturer.setIsActive(input.getIsactive());
        manufacturerRepository.save(manufacturer);
        return ManufacturerMapper.toManufacturerDto(manufacturer);
    }

    @Override
    public void deleteManufacturer(UUID id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new HandleRuntimeException(ErrorCode.MANUFACTURER_NOT_FOUND));
        manufacturerRepository.delete(manufacturer);
    }
}
