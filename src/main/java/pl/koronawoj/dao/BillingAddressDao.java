package pl.koronawoj.dao;

import org.springframework.data.repository.CrudRepository;

import pl.koronawoj.model.BillingAddress;

public interface BillingAddressDao extends CrudRepository<BillingAddress, Integer> {

	BillingAddress findByBillingAddressId(int id);
}
