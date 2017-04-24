package pl.koronawoj.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.koronawoj.dao.BillingAddressDao;
import pl.koronawoj.dao.CartDao;
import pl.koronawoj.dao.CustomerDao;
import pl.koronawoj.dao.RoleDao;
import pl.koronawoj.dao.ShippingAddressDao;
import pl.koronawoj.model.BillingAddress;
import pl.koronawoj.model.Cart;
import pl.koronawoj.model.Customer;
import pl.koronawoj.model.ShippingAddress;
import pl.koronawoj.model.security.CustomerRole;
import pl.koronawoj.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	

	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerDao customerDao;
	
	
	@Autowired
    private RoleDao roleDao;
	
	@Autowired
    private ShippingAddressDao shippingAddresDao;
	
	@Autowired
    private BillingAddressDao billingAddressDao;
	
	@Autowired
	private CartDao cartDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public void save(Customer customer) {
        customerDao.save(customer);
    }

    public Customer findByUsername(String username) {
        return customerDao.findByUsername(username);
    }

    public Customer findByCustomerEmail(String customerEmail) {
        return customerDao.findByCustomerEmail(customerEmail);
    }
    
    public Customer createCustomer(Customer customer, Set<CustomerRole> customerRoles) {
        Customer localCustomer = customerDao.findByUsername(customer.getUsername());

        if (localCustomer != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", customer.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(encryptedPassword);

            for (CustomerRole ur : customerRoles) {
                roleDao.save(ur.getRole());
            }

            customer.getCustomerRole().addAll(customerRoles);
            
            
            /*
            customer.setBillingAddress(customerService.createBillingAddress());
            customer.setShippingAddress(customerService.createShippingAddress());*/

            localCustomer = customerDao.save(customer);
        }

        return localCustomer;
    }
    
    
    public boolean checkCustomerExists(String username, String customerEmail){
        if (checkUsernameExists(username) || checkCustomerEmailExists(username)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
    public boolean checkCustomerEmailExists(String customerEmail) {
        if (null != findByCustomerEmail(customerEmail)) {
            return true;
        }

        return false;
    }

	@Override
	public BillingAddress findByBillingAddressId(int id) {
		return billingAddressDao.findByBillingAddressId(id);
	}

	@Override
	public BillingAddress createBillingAddress(BillingAddress billingAddress) {
		
		return billingAddressDao.save(billingAddress);
	}

	@Override
	public ShippingAddress findByShippingAbbressId(int id) {
		return shippingAddresDao.findByShippingAddressId(id);
	}

	@Override
	public ShippingAddress createShippingAddress(ShippingAddress shippingAddress) {
		
		return shippingAddresDao.save(shippingAddress);
	}

	@Override
	public Cart createCart(Cart cart) {
		return cartDao.save(cart);
	}

    
}
