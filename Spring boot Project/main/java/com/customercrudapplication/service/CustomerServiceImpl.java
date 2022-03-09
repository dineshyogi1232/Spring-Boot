package com.customercrudapplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.customercrudapplication.model.Customer;
import com.customercrudapplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveOrUpdateCustomer(Customer customer) {
		LocalDate localDate = LocalDate.parse(customer.getDateOfBirth());
		String dateOfBirth = localDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		customer.setDateOfBirth(dateOfBirth);
		if (customer.getId() != null) {
			Optional<Customer> employee = customerRepository.findById(customer.getId());
			if (employee.isPresent()) {
				int mailCount = customerRepository.checkMailExist(customer.getEmail());
				int mobileCount = customerRepository.checkMobileExist(customer.getMobile());
				String mail = null;
				String mobile = null;
				Customer newEntity = employee.get();
				if (mailCount == 1) {
					if (customer.getEmail().equalsIgnoreCase(newEntity.getEmail())) {
						mail = newEntity.getEmail();
					} else {
						mail = newEntity.getEmail();
					}
				} else {
					mail = customer.getEmail();
				}
				if (mobileCount == 1) {
					if (customer.getMobile().equalsIgnoreCase(newEntity.getMobile())) {
						mobile = newEntity.getMobile();
					} else {
						mobile = newEntity.getMobile();
					}
				} else {
					mobile = customer.getMobile();
				}
				newEntity.setEmail(mail);
				newEntity.setMobile(mobile);
				newEntity.setFirstName(customer.getFirstName());
				newEntity.setLastName(customer.getLastName());
				newEntity.setAddress1(customer.getAddress1());
				newEntity.setAddress2(customer.getAddress2());
				newEntity.setAge(customer.getAge());
				newEntity.setGender(customer.getGender());
				newEntity.setDateOfBirth(customer.getDateOfBirth());
				newEntity = customerRepository.save(newEntity);
				return newEntity;
			}
		}
		int emailCount = customerRepository.checkMailExist(customer.getEmail());
		int mobileNoCount = customerRepository.checkMobileExist(customer.getMobile());
		if (emailCount == 0 && mobileNoCount == 0) {
			customer = customerRepository.save(customer);
			System.out.println("successfully saved...");
			return customer;
		} else {
			System.out.println("Your mail id already exist");
			System.out.println("Your mobile no already exist");
		}
		return customer;
	}

	@Override
	public List<Customer> showCustomerList() {
		List<Customer> customerList = customerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		if (customerList.size() > 0) {
			return customerList;
		} else {
			return customerList;
		}
	}

	@Override
	public void deleteCustomerDataById(Long customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public Customer getCustomerDataById(Long customerId) {
		Customer customer = customerRepository.getById(customerId);
		SimpleDateFormat currentDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		try {
			date = currentDateFormat.parse(customer.getDateOfBirth());
			SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateOfBirth = newDateFormat.format(date);
			customer.setDateOfBirth(dateOfBirth);
		} catch (ParseException e) {
			System.out.println("ParseException throw" + e);
		}
		return customer;
	}

	@Override
	public String mailExistOrNot(String email, String customerId) {
		if (!customerId.isEmpty()) {
			Customer customer = customerRepository.getById(Long.parseLong(customerId));
			int emailCount = customerRepository.checkMailExist(email);
			if (emailCount == 1) {
				if (customer.getEmail().equalsIgnoreCase(email)) {
					return "";
				} else {
					return "Email id is already exist...";
				}
			} else {
				return "";
			}
		} else {
			int emailCount = customerRepository.checkMailExist(email);
			if (emailCount == 1) {
				if (email.equalsIgnoreCase(email)) {
					return "Email id is already exist...";
				} else {
					return "";
				}
			} else {
				return "";
			}
		}
	}

	@Override
	public String mobileExistOrNot(String mobile, String customerId) {
		if (!customerId.isEmpty()) {
			Customer customer = customerRepository.getById(Long.parseLong(customerId));
			int mobileCount = customerRepository.checkMobileExist(mobile);
			if (mobileCount == 1) {
				if (customer.getMobile().equalsIgnoreCase(mobile)) {
					return "";
				} else {
					return "Mobile number is already exist...";
				}
			} else {
				return "";
			}
		} else {
			int mobileCount = customerRepository.checkMobileExist(mobile);
			if (mobileCount == 1) {
				if (mobile.equalsIgnoreCase(mobile)) {
					return "Mobile number is already exist...";
				} else {
					return "";
				}
			} else {
				return "";
			}
		}
	}

}