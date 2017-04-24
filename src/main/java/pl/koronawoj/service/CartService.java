package pl.koronawoj.service;

import pl.koronawoj.model.Cart;

public interface CartService {

	
	Cart findByCartId(int cartId);
	
	void update(Cart cart);
}
