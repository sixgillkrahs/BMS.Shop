package com.main.backend.Domain.Model.Roles;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Data
@Table(name = "roles")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    public UUID id;
    public String name;
    public String normalizedname;
    public Character isdefault;

    public Role( String name, String normalizedname, Character isdefault) {
        this.name = name;
        this.normalizedname = normalizedname;
        this.isdefault = isdefault;
    }




}