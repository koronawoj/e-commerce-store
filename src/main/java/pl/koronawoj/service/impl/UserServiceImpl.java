/*package pl.koronawoj.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.koronawoj.dao.CustomerDao;
import pl.koronawoj.dao.RoleDao;
import pl.koronawoj.model.Customer;
import pl.koronawoj.model.security.CustomerRole;
import pl.koronawoj.service.UserService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public void save(Customer user) {
		customerDao.save(user);
    }

    public Customer findByUsername(String username) {
        return customerDao.findByCustomerEmail(username);
    }

    public Customer findByEmail(String email) {
        return customerDao.findByCustomerEmail(email);
    }
    
    public Customer createUser(Customer user, Set<CustomerRole> customerRoles) {
    	Customer localUser = customerDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (CustomerRole ur : customerRoles) {
                roleDao.save(ur.getRole());
            }

            user.getCustomerRole().addAll(customerRoles);


            localUser = customerDao.save(user);
        }

        return localUser;
    }
    
    
    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(username)) {
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
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    
}
*/