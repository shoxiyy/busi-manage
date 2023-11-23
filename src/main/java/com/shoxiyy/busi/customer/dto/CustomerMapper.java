package com.shoxiyy.busi.customer.dto;

import com.shoxiyy.busi.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToDto(Customer customer);

    Customer addDtoToCustomer(CustomerAddDto customerAddDto);

    Customer updateDtoToCustomer(CustomerUpdateDto customerUpdateDto);
}
