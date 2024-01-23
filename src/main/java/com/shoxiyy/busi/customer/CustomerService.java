package com.shoxiyy.busi.customer;

import com.shoxiyy.busi.customer.dto.CustomerAddDto;
import com.shoxiyy.busi.customer.dto.CustomerDto;
import com.shoxiyy.busi.customer.dto.CustomerMapper;
import com.shoxiyy.busi.customer.dto.CustomerUpdateDto;
import com.shoxiyy.busi.utils.exceptions.ResourceNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;


@Service
public class CustomerService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto create(CustomerAddDto customerAddDto) {
        LOG.info("create" + customerAddDto);
        Customer customer = customerMapper.addDtoToCustomer(customerAddDto);
        customer.setDateOfCreation(LocalDate.now());
        Customer savedCustomer = customerRepository.save(customer);
        LOG.info("customer created");
        return customerMapper.updateCustomerToDto(savedCustomer);
    }

    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        LOG.info("getAll found " + customers.size() + " customers");
        return customers.stream()
                .map(customerMapper::updateCustomerToDto)
                .collect(Collectors.toList());
    }

    public CustomerDto updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if (!customerRepository.existsById(customerUpdateDto.id())) {
            throw new ResourceNotFound("Customer with given ID not exist ID: " + customerUpdateDto.id());
        }
        Customer customer = customerMapper.updateDtoToCustomer(customerUpdateDto);
        customer = customerRepository.save(customer);
        return customerMapper.updateCustomerToDto(customer);
    }

    public CustomerDto getCustomer(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::updateCustomerToDto)
                .orElseThrow(() -> new ResourceNotFound("Customer with given ID not exist ID: " + id));
    }

    public List<CustomerDto> getAllByLeader(Long id) {
        List<Customer> customers = customerRepository.findByLeaderId(id);
        LOG.info("getAllByLeader found " + customers.size() + " customers");
        return customers.stream()
                .map(customerMapper::updateCustomerToDto)
                .collect(Collectors.toList());
    }

    public List<CustomerDto> getByName(String name) {
        List<Customer> customers = customerRepository.findByName(name);
        LOG.info("getByName found " + customers.size() + " customers");
        return customers.stream()
                .map(customerMapper::updateCustomerToDto)
                .collect(Collectors.toList());
    }

    public Long getRevenue() {
        return customerRepository.sumPrice();
    }

    public List<Map.Entry<Customer, Long>> getTopLeaderCustomers() {
        List<Customer> customers = customerRepository.findAll();

        Map<Customer, Long> collect = customers.stream()
                .collect(Collectors.groupingBy(Customer::getLeader, Collectors.counting()));

        LOG.info("collect found " + collect.size() + " leaders");
        return collect.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
