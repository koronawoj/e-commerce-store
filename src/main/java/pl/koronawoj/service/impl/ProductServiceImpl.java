package pl.koronawoj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.koronawoj.dao.ProductDao;
import pl.koronawoj.model.Product;
import pl.koronawoj.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productDao;
	

	
	public void addProduct(Product product) {
		productDao.save(product);
		
	}

	
	public void editProduct(Product product) {
		productDao.save(product);
		
	}



	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
		
	}


	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}


	


	@Override
	public Product findByProductId(int id) {
		return productDao.findByProductId(id);
	}


	



}
