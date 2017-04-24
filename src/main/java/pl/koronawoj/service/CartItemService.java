package pl.koronawoj.service;

import pl.koronawoj.model.Cart;
import pl.koronawoj.model.CartItem;

public interface CartItemService {
	
	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItem);
	
	void removeCartItemId(int id);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
	
	CartItem findByCartItemId(int cartId);
}
