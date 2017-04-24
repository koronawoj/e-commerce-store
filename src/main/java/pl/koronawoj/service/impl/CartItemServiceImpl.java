package pl.koronawoj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.koronawoj.dao.CartItemDao;
import pl.koronawoj.dao.ProductDao;
import pl.koronawoj.model.Cart;
import pl.koronawoj.model.CartItem;
import pl.koronawoj.service.CartItemService;


@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.save(cartItem);
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		System.out.println("USUWANIE");
		if(cartItem.equals(null)){
			System.out.println("nie ma tu nic");
		}
		cartItemDao.delete(cartItem);
		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem item: cartItems){
			cartItemDao.delete(item);
		}
		
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.findByProduct(productDao.findByProductId(productId));
	}

	@Override
	public void removeCartItemId(int id) {
		cartItemDao.delete(id);
		
	}

	@Override
	public CartItem findByCartItemId(int cartId) {
		return cartItemDao.findByCartItemId(cartId);
	}

	
	

}
