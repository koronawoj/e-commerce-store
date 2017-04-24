package pl.koronawoj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.koronawoj.model.Customer;
import pl.koronawoj.service.CustomerService;

@Controller
public class CartController {

	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/cart", method = RequestMethod.GET)
	public String getCart(@AuthenticationPrincipal UserDetails activeUser){
		
		Customer customer = customerService.findByUsername(activeUser.getUsername());

		int cartId = customer.getCart().getCartId();
		
		return "redirect:/customer/cart/" + cartId;
	}
	
	@RequestMapping("/customer/cart/{cartId}")
	public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}
	
	
	
	
}
