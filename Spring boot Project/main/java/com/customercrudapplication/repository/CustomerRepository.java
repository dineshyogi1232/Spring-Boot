package com.customercrudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.customercrudapplication.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query
	(value = "SELECT COUNT(*) FROM Customer as c WHERE c.email=:email")
	int checkMailExist(String email);
	
	@Query(value = "SELECT COUNT(*) FROM Customer as c WHERE c.mobile=:mobile")
	int checkMobileExist(String mobile);

}