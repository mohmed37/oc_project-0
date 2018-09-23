package com.lambazon.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.domain.Product;
import com.lambazon.service.ProductService;


@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@GetMapping("/products")
	public String products	(Model model) {
		model.addAttribute("prods", productService.products());
		model.addAttribute("totalInventoryAmount", calculateTotalInventoryAmount());
		return "products";
	}
	
	@GetMapping("/products/{id}/details")
	public String product	(@PathVariable Integer id, Model model) {
		model.addAttribute("prod", productService.product(id));
		return "product";
	}

	/**
	 * Integration of the total sum ProductionService in CalculateTotalInventoryAmount.
	 * @return
	 */
	
	private double calculateTotalInventoryAmount() {
		double sommeTotal = 0.0;
		int i=1 ;
		while (i<=productService.products().size())
		{
			sommeTotal+=productService.product(i).getInventoryPrice();
			i =i + 1;

		}
		return sommeTotal;

		
	}
}
