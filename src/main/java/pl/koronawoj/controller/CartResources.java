package pl.koronawoj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.koronawoj.model.Cart;
import pl.koronawoj.model.CartItem;
import pl.koronawoj.model.Customer;
import pl.koronawoj.model.Product;
import pl.koronawoj.service.CartItemService;
import pl.koronawoj.service.CartService;
import pl.koronawoj.service.CustomerService;
import pl.koronawoj.service.ProductService;




@Controller
@Transactional
@RequestMapping("/rest/cart")
public class CartResources {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping("/{cartId}")
	public @ResponseBody
	Cart getCartById(@PathVariable(value = "cartId") int cartId){
		return cartService.findByCartId(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal UserDetails activeUser){
		
		
		Customer customer = customerService.findByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.findByProductId(productId);

		System.out.println("To jest karta " + cart);

		System.out.println("To jest customer " + customer);
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i = 0; i<cartItems.size(); i++) {
			if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
				
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		return;
		
	}
	
	@RequestMapping(value ="/remove/{productId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId){
		System.out.println("remove! " + productId);
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		System.out.println("Obiekt! " + cartItem.getTotalPrice()+" Obiekt! " + cartItem.getCartItemId()+" Obiekt! " + cartItem.getQuantity()+" Obiekt! " + cartItem.getCart() + " Obiekt! " + cartItem.getProduct());
		cartItemService.removeCartItem(cartItem);
		
		
	}
	
}
