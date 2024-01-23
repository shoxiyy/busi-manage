package com.shoxiyy.busi.customer.dto;

import com.shoxiyy.busi.customer.Customer;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDto updateCustomerToDto(Customer customer);

    Customer addDtoToCustomer(CustomerAddDto customerAddDto);

    Customer updateDtoToCustomer(CustomerUpdateDto customerUpdateDto);
}
