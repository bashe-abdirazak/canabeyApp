package com.bashe.controllers;

import com.bashe.model.Product;
import com.bashe.services.CartService;
import com.bashe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		CartService.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String cartGet(Model model) {
		model.addAttribute("cartCount", CartService.cart.size());
		model.addAttribute("total", CartService.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", CartService.cart);
		return "cart";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		CartService.cart.remove(index);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", CartService.cart.stream().mapToDouble(Product::getPrice).sum());
		
		return "checkout";
	}
	
	@GetMapping("/payNow")
	public String payNow() {	
		
		return "orderPlaced";
	}
}
