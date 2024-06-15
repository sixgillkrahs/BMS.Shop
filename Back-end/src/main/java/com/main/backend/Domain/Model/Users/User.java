package com.main.backend.Domain.Model.Users;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    public UUID id;
    public String username;
    public String normalizedusername;
    public String name;
    public String surname;
    public String email;
    public String normalizedemail;
    public String password;
    public String phonenumber;
    public String phonenumbercomfirmed;
    public Character isactive;
    public String avatarimage;

    public User(String username, String normalizedusername, String name, String surname, String email, String normalizedemail, String password, String phonenumber, String phonenumbercomfirmed, Character isactive) {
        this.username = username;
        this.normalizedusername = normalizedusername;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.normalizedemail = normalizedemail;
        this.password = password;
        this.phonenumber = phonenumber;
        this.phonenumbercomfirmed = phonenumbercomfirmed;
        this.isactive = isactive;
    }

    public User(String username, String normalizedusername, String name, String surname, String email, String normalizedemail, String password, String phonenumber, String phonenumbercomfirmed, Character isactive, String avatarimage) {
        this.username = username;
        this.normalizedusername = normalizedusername;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.normalizedemail = normalizedemail;
        this.password = password;
        this.phonenumber = phonenumber;
        this.phonenumbercomfirmed = phonenumbercomfirmed;
        this.isactive = isactive;
        this.avatarimage = avatarimage;
    }
}
