package com.main.backend.Controller;


import com.main.backend.Domain.APIRepository;
import com.main.backend.Domain.Dto.Manufacturers.CreateUpdateManufacturerDto;
import com.main.backend.Domain.Dto.Manufacturers.ManufacturerDto;
import com.main.backend.Service.Service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerController {

    @Autowired
    public ManufacturerService manufacturerService;


    @GetMapping("/all")
    public APIRepository<List<ManufacturerDto>> getAllManufacturers(){
        APIRepository<List<ManufacturerDto>> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(manufacturerService.getAllManufacturers());
        return repository;
    }

    @GetMapping("/get/{id}")
    public APIRepository<ManufacturerDto> getManufacturerById(UUID id){
        APIRepository<ManufacturerDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(manufacturerService.getManufacturerById(id));
        return repository;
    }

    @PostMapping("/save")
    public APIRepository<ManufacturerDto> saveManufacturer(CreateUpdateManufacturerDto input){
        APIRepository<ManufacturerDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(manufacturerService.saveManufacturer(input));
        repository.setMessage("create manufacturer successfully");
        return repository;
    }

    @PutMapping("/update/{id}")
    public APIRepository<ManufacturerDto> updateManufacturer(@PathVariable UUID id, @RequestBody CreateUpdateManufacturerDto input){
        APIRepository<ManufacturerDto> repository = new APIRepository<>();
        repository.setCode(1000);
        repository.setResult(manufacturerService.updateManufacturer(id, input));
        return repository;
    }

    @DeleteMapping("/delete/{id}")
    public APIRepository<String> deleteManufacturer(@PathVariable UUID id){
        APIRepository<String> repository = new APIRepository<>();
        repository.setCode(1000);
        manufacturerService.deleteManufacturer(id);
        repository.setMessage("delete manufacturer successfully");
        return repository;
    }


}
