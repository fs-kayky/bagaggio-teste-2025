package com.fs_kayky.bagaggio_teste.dto;


import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductDTO {

    // Getters e Setters
    private String name;
    private String description;
    private BigDecimal price; // preço em reais
    private Integer quantity;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}