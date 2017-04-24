package pl.koronawoj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.koronawoj.dao.CartDao;
import pl.koronawoj.model.Cart;
import pl.koronawoj.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartService cartService;
	
	
	@Override
	public Cart findByCartId(int cartId) {
		return cartDao.findByCartId(cartId);
	}

	@Override
	public void update(Cart cart) {
		cartDao.save(cart);
		
	}

}
