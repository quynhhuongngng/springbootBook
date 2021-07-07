package com.springbootBook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootBook.models.Product;
import com.springbootBook.repositories.ProductRepository;


@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	//Return list of states
	public List<Product> getStates(){
		return productRepository.findAll();
	}
	
	//SAve new state
	public void save(Product product) {
		productRepository.save(product);
	}
	
	//get by id
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
	
	
}
