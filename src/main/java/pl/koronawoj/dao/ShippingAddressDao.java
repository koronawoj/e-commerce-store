package pl.koronawoj.dao;

import org.springframework.data.repository.CrudRepository;

import pl.koronawoj.model.ShippingAddress;

public interface ShippingAddressDao extends CrudRepository<ShippingAddress, Integer> {
	 
	ShippingAddress findByShippingAddressId(int id);
}
