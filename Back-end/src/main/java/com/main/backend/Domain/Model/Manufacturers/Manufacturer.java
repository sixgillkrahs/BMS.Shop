package com.main.backend.Domain.Model.Manufacturers;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Table(name = "manufacturers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id = UUID.randomUUID();
    public String name;
    @Column(name = "isactive")
    public Character isActive;

    public Manufacturer(String name) {
            this.name = name;
    }
}
