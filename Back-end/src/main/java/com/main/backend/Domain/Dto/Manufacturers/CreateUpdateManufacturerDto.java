package com.main.backend.Domain.Dto.Manufacturers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateManufacturerDto {
    public String name;
    public Character isactive;
}
