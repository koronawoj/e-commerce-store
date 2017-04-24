package pl.koronawoj.model.security;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.koronawoj.model.Customer;


@Entity
@Table(name="customer_role")
public class CustomerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerRoleId;

    public CustomerRole(Customer customer, Role role) {
        this.customer = customer;
        this.role = role;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public CustomerRole() {}

	public long getCustomerRoleId() {
		return customerRoleId;
	}

	public void setCustomerRoleId(long customerRoleId) {
		this.customerRoleId = customerRoleId;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
    


}
