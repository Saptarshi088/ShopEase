package com.saptarshi.ShopEase.service;

import com.saptarshi.ShopEase.models.Product;
import com.saptarshi.ShopEase.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }



    public Product updateStock(Long id, int stock) {
        var product = productRepository.findById(id).orElse(null);
        if(product==null) return null;
        product.setStockQuantity(stock);

        return product;
    }
}
