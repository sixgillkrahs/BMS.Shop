package com.main.backend.Domain.Model.UserRoles;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "userroles")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRoleId.class)
public class UserRole {
    @Id
    @Column(name = "userid")
    private UUID userId;
    @Id
    @Column(name = "roleid")
    private UUID roleId;

}

