package com.erdi.customer.service;

import com.erdi.customer.controller.CustomerRegistrationRequest;
import com.erdi.customer.model.Customer;

public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request){
            Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();

            // todo: check if email valid
            // todo: check if email not taken
            // todo: store customer in db
    }

}
