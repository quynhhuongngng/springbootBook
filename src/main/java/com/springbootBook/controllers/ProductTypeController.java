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

import com.springbootBook.models.ProductType;
import com.springbootBook.services.ProductTypeService;

@Controller
public class ProductTypeController {
	
	@Autowired
	private ProductTypeService productTypeService;

	@GetMapping("/countries")
	public String getCountries(Model model) {		
		List<ProductType> countryList = productTypeService.getCountries();	
		model.addAttribute("countries", countryList);	
		return "country";
	}	
	
	@PostMapping("/countries/addNew")
	public String addNew(ProductType productType) {
		productTypeService.save(productType);
		return "redirect:/countries";
	}
	
	@RequestMapping("countries/findById")
	@ResponseBody
	public Optional<ProductType> findById(int id) {
	  return productTypeService.findById(id);	
	}	
	
	@RequestMapping(value="/countries/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(ProductType productType) {
		productTypeService.save(productType);
		return "redirect:/countries";
	}
	
	@RequestMapping(value="/countries/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		productTypeService.delete(id);
		return "redirect:/countries";
	}
	
}
