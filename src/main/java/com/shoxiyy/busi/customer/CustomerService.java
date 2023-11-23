package com.shoxiyy.busi.customer;

import com.shoxiyy.busi.customer.dto.CustomerAddDto;
import com.shoxiyy.busi.customer.dto.CustomerDto;
import com.shoxiyy.busi.customer.dto.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto create(CustomerAddDto customerAddDto) {
        log.info("create" + customerAddDto);
        Customer customer = customerMapper.addDtoToCustomer(customerAddDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToDto(savedCustomer);
    }

    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::customerToDto)
                .collect(Collectors.toList());
    }
}
