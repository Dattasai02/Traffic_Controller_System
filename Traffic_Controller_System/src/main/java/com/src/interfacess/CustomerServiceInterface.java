package com.src.interfacess;

import java.util.List;

import com.src.model.Customer;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;

public interface CustomerServiceInterface {
	public int addCustomer(Customer customer);
	public boolean validateCustomer(Customer customer) ; 
	public Customer getCustomerDetails(String id) ;
	public int customerUpdate(Customer customer);
	
	public List<Diversions> customer_allDiversions();
	public List<Routes> customer_allRoutes();
	public List<Traffics> customer_allTraffics();

}
