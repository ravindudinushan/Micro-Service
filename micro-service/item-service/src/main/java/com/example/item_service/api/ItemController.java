package com.example.item_service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String get() {
        return "Hello from Item Service";
    }

    @GetMapping("/postCustomerInItem")
    public Customer post(@RequestBody Customer customer) {
        return restTemplate.postForObject("http://customer-service/api/v1/customer/postItemInCustomer",customer, Customer.class);
    }
}
