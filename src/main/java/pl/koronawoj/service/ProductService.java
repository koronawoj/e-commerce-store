package pl.koronawoj.service;

import java.util.List;

import pl.koronawoj.model.Product;

public interface ProductService {
	
	
	Product findByProductId(int id);

	
	List<Product> findAll();
	
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
