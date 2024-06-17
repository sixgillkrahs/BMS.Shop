package com.main.backend.Domain.Model.Carts;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemId implements Serializable {
    public UUID cartid;
    public UUID productid;
    public UUID colorid;
    public UUID sizeid;
}
