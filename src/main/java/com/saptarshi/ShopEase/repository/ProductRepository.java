package com.saptarshi.ShopEase.repository;

import com.saptarshi.ShopEase.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
