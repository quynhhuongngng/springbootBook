package com.springbootBook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootBook.models.Product;
import com.springbootBook.models.ProductType;
import com.springbootBook.services.ProductService;
import com.springbootBook.services.ProductTypeService;

@Controller
public class ProductController {

	@Autowired	private ProductService productService;
	@Autowired	private ProductTypeService productTypeService;


	@GetMapping("/states")
	public String getStates(Model model) {		
		List<Product> stateList = productService.getStates();	
		model.addAttribute("states", stateList);	
		
		List<ProductType> countryList = productTypeService.getCountries();	
		model.addAttribute("countries", countryList);
		
		return "State";
	}	
	
	@PostMapping("/states/addNew")
	public String addNew(Product product) {
		productService.save(product);
		return "redirect:/states";
	}
	
	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<Product> findById(int id) {
	  return productService.findById(id);	
	}	
	
	@RequestMapping(value="/states/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Product product) {
		productService.save(product);
		return "redirect:/states";
	}
	
	@RequestMapping(value="/states/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		productService.delete(id);
		return "redirect:/states";
	}
	

}
