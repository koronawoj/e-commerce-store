package pl.koronawoj.service;

import java.util.Set;

import pl.koronawoj.model.BillingAddress;
import pl.koronawoj.model.Cart;
import pl.koronawoj.model.Customer;
import pl.koronawoj.model.ShippingAddress;
import pl.koronawoj.model.security.CustomerRole;

public interface CustomerService {
	Customer findByUsername(String username);

	Customer findByCustomerEmail(String customerEmail);

    boolean checkCustomerExists(String username, String customerEmail);

    boolean checkUsernameExists(String username);

    boolean checkCustomerEmailExists(String email);
    
    void save (Customer customer);
    
    Customer createCustomer(Customer customer, Set<CustomerRole> customerRoles);
    
    BillingAddress findByBillingAddressId(int id);
    
    BillingAddress createBillingAddress(BillingAddress billingAddress);
    
    ShippingAddress findByShippingAbbressId(int id);
    
    ShippingAddress createShippingAddress(ShippingAddress shippingAddress);
    
    Cart createCart(Cart cart);
    
}
