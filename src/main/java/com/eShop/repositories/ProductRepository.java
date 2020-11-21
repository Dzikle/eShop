package com.eShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eShop.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
