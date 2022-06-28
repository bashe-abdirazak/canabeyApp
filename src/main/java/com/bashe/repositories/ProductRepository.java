package com.bashe.repositories;

import com.bashe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByCategory_id(int id);
}
