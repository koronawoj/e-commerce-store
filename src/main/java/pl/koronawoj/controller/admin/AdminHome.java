package pl.koronawoj.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.koronawoj.model.Product;
import pl.koronawoj.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping(value = "/productInventory", method = RequestMethod.GET)
	public String productInventory(Model model){
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "productInventory";
		
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customerManagment(Model model){
		
		// add some shit
		return "customerManagment";
	}

}
