package com.shoxiyy.busi.customer;

import com.shoxiyy.busi.customer.dto.CustomerAddDto;
import com.shoxiyy.busi.customer.dto.CustomerUpdateDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String home(Model model) {
        model.addAttribute("revenue", customerService.getRevenue());
        model.addAttribute("top3Leaders", customerService.getTopLeaderCustomers());
        return "main";
    }

    @GetMapping("/save")
    public String addForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customers", customerService.getAll());
        return "add-form";
    }

//    @PostMapping("/save")
//    public String saveCustomer(@Valid Customer customer, BindingResult result) {
//        if (result.hasErrors()) {
//            return "add-form";
//        }
//        customerService.create(customer);
//        return "redirect:/customers";
//    }

    @PostMapping("/save")
    public String saveCustomer(CustomerAddDto customerAddDto, BindingResult result) {
        if (result.hasErrors()) {
            return "add-form";
        }
        customerService.create(customerAddDto);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model, String name) {
        if (name != null) {
            model.addAttribute("customers", customerService.getByName(name));
        } else {
            model.addAttribute("customers", customerService.getAll());
        }
        return "customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("customers", customerService.getAll());
        return "update-form";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        customerService.updateCustomer(customerUpdateDto);
        return "redirect:/customers";
    }

    @GetMapping("/customers/{id}")
    public String getAllCustomersByLeaderId(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("customersList", customerService.getAllByLeader(id));
        return "customers";
    }

}
