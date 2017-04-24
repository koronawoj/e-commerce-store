package pl.koronawoj.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.koronawoj.dao.RoleDao;
import pl.koronawoj.model.BillingAddress;
import pl.koronawoj.model.Cart;
import pl.koronawoj.model.Customer;
import pl.koronawoj.model.ShippingAddress;
import pl.koronawoj.model.security.CustomerRole;
import pl.koronawoj.service.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
    required = false) String logout, Model model) {
		if (error!=null) {
		    model.addAttribute("error", "Invalid username and password");
		}
		
		if(logout!=null) {
		    model.addAttribute("msg", "You have been logged out successfully.");
		}
		
		return "login";
		}
	
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();

        model.addAttribute("customer", user);

        return "registerCustomer";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("customer")User user, Model model){
		
		if(userService.checkUserExists(user.getUsername(), user.getEmail())){
			
			if(userService.checkUsernameExists(user.getUsername())){
				model.addAttribute("usernameExists", true);
			}
			if(userService.checkEmailExists(user.getEmail())){
				model.addAttribute("emailExists", true);
			}
			
			return "signup";
		} else{
			
			Set<UserRole> userRole = new HashSet<>();
			userRole.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			
			userService.createUser(user, userRole);
			
			return "redirect:/";
		}
	}*/
	
	@RequestMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";

    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("customer")Customer customer, Model model){
		
		if(customerService.checkCustomerExists(customer.getUsername(), customer.getCustomerEmail())){
			
			if(customerService.checkUsernameExists(customer.getUsername())){
				model.addAttribute("usernameExists", true);
			}
			if(customerService.checkCustomerEmailExists(customer.getCustomerEmail())){
				model.addAttribute("emailExists", true);
			}
			
			return "signup";
		} else{
			
			Set<CustomerRole> customerRole = new HashSet<>();
			customerRole.add(new CustomerRole(customer, roleDao.findByName("ROLE_USER")));
			
			customerService.createCustomer(customer, customerRole);
			customerService.createBillingAddress(customer.getBillingAddress());
			customerService.createShippingAddress(customer.getShippingAddress());
			Cart newCart = new Cart();
			newCart.setCustomer(customer);
			customer.setCart(newCart);
			customerService.createCart(customer.getCart());
			
			return "redirect:/";
		}
	}
}

