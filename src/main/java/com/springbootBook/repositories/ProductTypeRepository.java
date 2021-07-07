package com.springbootBook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootBook.models.ProductType;

@Repository

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}
