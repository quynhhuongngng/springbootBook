package com.springbootBook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootBook.models.ProductType;
import com.springbootBook.repositories.ProductTypeRepository;

@Service
public class ProductTypeService {
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	//Return list of countries
	public List<ProductType> getCountries(){
		return productTypeRepository.findAll();
	}
	
	//SAve new country
	public void save(ProductType productType) {
		productTypeRepository.save(productType);
	}
	
	//get by id
	public Optional<ProductType> findById(int id) {
		return productTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		productTypeRepository.deleteById(id);
	}
	
}
