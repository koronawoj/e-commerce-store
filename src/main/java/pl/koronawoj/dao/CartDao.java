package pl.koronawoj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.koronawoj.model.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {
	
	Cart findByCartId(int cartId);
	
	
}
