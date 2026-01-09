package com.saptarshi.ShopEase.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    @NotBlank(message = "Name can not be blank")
    @Size(min = 3,max = 100,message = "Name must be between 3 and 100 letters long")
    private String name;
    @NotBlank(message = "Price can not be blank")
    private Double price;
    @NotBlank(message = "Stock quantity can not be blank")
    private Integer stockQuantity;
}
