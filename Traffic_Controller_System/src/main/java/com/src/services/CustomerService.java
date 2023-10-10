package com.src.services;

import java.util.List;

import com.src.dao.interfaces.CustomerDaoInterface;
import com.src.dao.services.CustomerDaoService;
import com.src.interfacess.CustomerServiceInterface;
import com.src.model.Customer;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;

public class CustomerService implements CustomerServiceInterface {
	CustomerDaoInterface customerdao = new CustomerDaoService();

	@Override
	public int addCustomer(Customer customer) {
		return customerdao.addCustomer(customer);
	}

	@Override
	public boolean validateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerdao.validateCustomer(customer);
	}

	@Override
	public Customer getCustomerDetails(String id) {
		return customerdao.getCustomerDetails(id);
	}

	@Override
	public List<Diversions> customer_allDiversions() {
		
		return customerdao.customer_allDiversions();
	}

	@Override
	public List<Routes> customer_allRoutes() {
		return customerdao.customer_allRoutes();
	}

	@Override
	public List<Traffics> customer_allTraffics() {
		return customerdao.customer_allTraffics();
	}

	@Override
	public int customerUpdate(Customer customer) {
		
		return customerdao.customerUpdate(customer);
	}

}
