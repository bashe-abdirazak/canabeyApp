package com.bashe.services;

import com.bashe.model.Category;
import com.bashe.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	@Query(value = "SELECT c FROM Category c")
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	
	public void addCategory(Category category) {
		 categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id) { return categoryRepository.findById(id); }

}
