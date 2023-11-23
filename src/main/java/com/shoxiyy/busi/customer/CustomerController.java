package com.shoxiyy.busi.customer;

import com.shoxiyy.busi.customer.dto.CustomerAddDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String home() {
        return "main";
    }
    @GetMapping("/save")
    public String addForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-form";
    }

    @PostMapping("/save")
    public String saveCustomer(CustomerAddDto customerDto) {
        customerService.create(customerDto);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAll());
        return "customers";
    }
}
