package pl.koronawoj.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.koronawoj.model.Product;
import pl.koronawoj.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String getProduct(Model model){
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping(value = "/viewProduct/{id}", method = RequestMethod.GET)
	public String viewProduct(@PathVariable int id,   Model model) throws IOException{
		Product product = productService.findByProductId(id);
		model.addAttribute("product", product);
		
		return "viewProduct";
	}

}
