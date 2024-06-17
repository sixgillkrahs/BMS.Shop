package com.main.backend.Domain.Model.Options;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "color")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;
    public String name;
    @Column(name = "hex_code")
    public String hex;

    public Color(String name, String hex) {
        this.name = name;
        this.hex = hex;
    }
    public Color(String name) {
        this.name = name;
    }
}

