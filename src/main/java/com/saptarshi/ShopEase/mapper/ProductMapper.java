package com.saptarshi.ShopEase.mapper;

import com.saptarshi.ShopEase.dtos.ProductDto;
import com.saptarshi.ShopEase.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
}
