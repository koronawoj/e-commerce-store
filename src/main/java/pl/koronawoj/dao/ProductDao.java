package pl.koronawoj.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.koronawoj.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {
	
	List<Product> findAll();
	
	Product findByProductId(int id);
	
}
