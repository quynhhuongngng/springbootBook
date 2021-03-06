package com.springbootBook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootBook.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
