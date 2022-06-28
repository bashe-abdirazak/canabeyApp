package com.bashe.services;

import com.bashe.model.Product;
import com.bashe.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Query(value = "SELECT p FROM Product p")
	public List<Product> getAllProduct() { return productRepository.findAll(); }
	public Optional<Product> getProductById(int id) {return productRepository.findById(id);	}

	public void addProduct(Product product) { productRepository.save(product);	}

	public void removeProductById(int id) {productRepository.deleteById(id); }
	public List<Product> getAllProductsByCategoryId(int id) {return productRepository.findAllByCategory_id(id);	}
}
