package com.example.customer_service.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final RestTemplate restTemplate;

    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get")
    public String get() {
        return "Hello from Customer Service";
    }

    @GetMapping("/getItemInCustomer")
    public String getItemInCustomer() {
        return restTemplate.getForObject("http://item-service/api/v1/item/get", String.class);
    }


    @PostMapping("/postItemInCustomer")
    public Customer post(@RequestBody Customer customer) {
        customer.setName("IJSE");
        return customer;
    }

}
