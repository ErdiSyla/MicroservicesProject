package com.erdi.customer.service;

import com.erdi.customer.controller.CustomerRegistrationRequest;
import com.erdi.customer.controller.FraudCheckResponse;
import com.erdi.customer.model.Customer;
import com.erdi.customer.repo.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository , RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest request){
            Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
 
            //save and flush so the customer is properly sent to the database and we don't have no id
            customerRepository.saveAndFlush(customer);
            // todo: check if email valid
            // todo: check if email not taken
            FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());
           
            if(fraudCheckResponse != null &&  fraudCheckResponse.isFraudster()){
                throw new IllegalStateException("fraudster");
            }
            // todo: send notification
    }

}
