package com.saptarshi.ShopEase.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private Double price;
    private Integer stockQuantity;
}
