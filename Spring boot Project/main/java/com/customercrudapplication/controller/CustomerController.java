package com.customercrudapplication.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.customercrudapplication.model.Customer;
import com.customercrudapplication.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/showdata")
	public String showCustomerList(Model model, RedirectAttributes redirectAttributes) {
		List<Customer> listOfCustomer = customerService.showCustomerList();
		redirectAttributes.addAttribute("id", listOfCustomer.get(0).getId()).addFlashAttribute("success",
				"No data found!");
		model.addAttribute("tableHeading", Customer.tableHeading);
		model.addAttribute("fields", Customer.fields);
		model.addAttribute("listOfCustomers", listOfCustomer);
		return "customershow";
	}

	@RequestMapping("/save")
	public String addOrEdit(@Valid @ModelAttribute("listOfCustomer") Customer customer,
			RedirectAttributes redirectAttributes) {
		Customer newCustomer = customerService.saveOrUpdateCustomer(customer);
		boolean isSame = newCustomer.equals(customer);
		if (isSame) {
			redirectAttributes.addAttribute("id", customer.getId()).addFlashAttribute("success",
					"Your Data is save successfully!");
		} else {
			redirectAttributes.addAttribute("id", customer.getId()).addFlashAttribute("success",
					"Your Data is save successfully with same mail id and mobile no!");
		}
		return "redirect:/customer/showdata";
	}

	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		customerService.deleteCustomerDataById(id);
		redirectAttributes.addFlashAttribute("success", "Your data is deleted");
		return "redirect:/customer/showdata";
	}

	@RequestMapping("/showdata/id={id}")
	public ResponseEntity<?> getDataById(@PathVariable("id") Long id, Model model) {
		Customer customerdata = customerService.getCustomerDataById(id);
		List<Customer> list = new ArrayList<>();
		list.add(customerdata);
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping("/showdata/email={email}&id={id}")
	public ResponseEntity<?> checkMailExist(@PathVariable("email") String email, @PathVariable("id") String id) {
		String result = customerService.mailExistOrNot(email, id);
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping("/showdata/mobile={mobile}&id={id}")
	public ResponseEntity<?> checkMobileExist(@PathVariable("mobile") String mobile, @PathVariable("id") String id) {
		String result = customerService.mobileExistOrNot(mobile, id);
		return ResponseEntity.ok(result);
	}

}