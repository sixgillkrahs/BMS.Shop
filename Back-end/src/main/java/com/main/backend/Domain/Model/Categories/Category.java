package com.main.backend.Domain.Model.Categories;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id = UUID.randomUUID();
    public String name;
    @Column(name = "parendid")
    public UUID parentId;
    @Column(name = "isactive")
    public Character isActive;
}
