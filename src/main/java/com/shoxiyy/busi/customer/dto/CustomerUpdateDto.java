package com.shoxiyy.busi.customer.dto;

import com.shoxiyy.busi.customer.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public record CustomerUpdateDto(Long id,
                                @NotBlank @NotEmpty String firstName,
                                @NotBlank @NotEmpty String lastName, String email,
                                LocalDate dateOfCreation, Customer leader, URL practiceWebsite,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfGrantedAccess,
                                String accessGrantedBy, boolean accessGranted,
                                Integer price) {
}