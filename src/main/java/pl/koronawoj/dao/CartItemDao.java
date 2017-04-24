package pl.koronawoj.dao;

import org.springframework.data.repository.CrudRepository;

import pl.koronawoj.model.CartItem;
import pl.koronawoj.model.Product;

public interface CartItemDao extends CrudRepository<CartItem, Integer> {

	CartItem findByCartItemId(int cartId);
	CartItem findByProduct(Product product);
	
	
}
