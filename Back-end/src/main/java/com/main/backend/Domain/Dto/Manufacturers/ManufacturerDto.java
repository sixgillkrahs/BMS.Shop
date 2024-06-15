package com.main.backend.Domain.Dto.Manufacturers;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto {
    public UUID id;
    public String name;
    public Character isactive;
}
