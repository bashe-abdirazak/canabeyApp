package com.bashe.services;

import com.bashe.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {

public static List<Product> cart;
	
	static {
		cart = new ArrayList<>();
		
	}
}
