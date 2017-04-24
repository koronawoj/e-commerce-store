package pl.koronawoj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.koronawoj.model.BillingAddress;
import pl.koronawoj.model.ShippingAddress;

@Controller
public class RegistrationController {
	
	/*@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerCustomer(Model model) {
		
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		model.addAttribute("customer", customer);
		
		
		return "registerCustomer";
	}
	
	public String registerCustomerPost(@ModelAttribute("customer") Customer customer, Model model)	{
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}*/
}
