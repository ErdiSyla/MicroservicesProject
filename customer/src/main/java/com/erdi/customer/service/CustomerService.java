package com.erdi.customer.service;

import com.erdi.customer.controller.CustomerRegistrationRequest;
import com.erdi.customer.model.Customer;
import com.erdi.customer.repo.CustomerRepository;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest request){
            Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();

            // todo: check if email valid
            // todo: check if email not taken
            
            customerRepository.save(customer);
    }

}
