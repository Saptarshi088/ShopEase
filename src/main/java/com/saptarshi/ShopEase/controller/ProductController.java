package com.saptarshi.ShopEase.controller;

import com.saptarshi.ShopEase.dtos.ProductDto;
import com.saptarshi.ShopEase.mapper.ProductMapper;
import com.saptarshi.ShopEase.models.Product;
import com.saptarshi.ShopEase.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@SuppressWarnings("unused")
public class ProductController {
    private final ProductService productService;
    private ProductMapper productMapper;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAll().stream()
                .map(productMapper::toDto)
                .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product product, UriComponentsBuilder uriBuilder){
        productService.save(product);
//        System.out.println(product);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(productMapper.toDto(product));
    }
}
