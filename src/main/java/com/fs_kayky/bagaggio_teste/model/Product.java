package com.fs_kayky.bagaggio_teste.model;

import com.fs_kayky.bagaggio_teste.dto.ProductDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 50, message = "O Produto deve ter um nome entre 3 e 50 caracteres, para ser válido.")
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    @Column(nullable = false)
    private Integer quantity;

    @NotBlank
    @Column(name = "cents_price", nullable = false)
    private Integer centsPrice;

    public BigDecimal getPrice() {
        return centsPrice == null ? null : BigDecimal.valueOf(centsPrice).movePointLeft(2);
    }

    public void setPrice(BigDecimal price) {

        if (price != null) {
            this.centsPrice = price.movePointRight(2).intValueExact();
        } else {
            this.centsPrice = null;
        }

    }

    public void updateFrom(ProductDTO p) {
        this.name = p.getName();
        this.description = p.getDescription();
        this.quantity = p.getQuantity();
        this.setPrice(p.getPrice());
    }

}
