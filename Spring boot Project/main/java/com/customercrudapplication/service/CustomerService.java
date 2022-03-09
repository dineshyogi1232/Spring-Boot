package com.customercrudapplication.service;

import java.util.List;
import com.customercrudapplication.model.Customer;

public interface CustomerService {

	Customer saveOrUpdateCustomer(Customer customer);

	List<Customer> showCustomerList();

	Customer getCustomerDataById(Long customerId);

	void deleteCustomerDataById(Long customerId);

	String mailExistOrNot(String email,String id);

	String mobileExistOrNot(String mobile,String id);

}