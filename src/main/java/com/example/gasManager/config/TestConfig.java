package com.example.gasManager.config;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Order;
import com.example.gasManager.model.enums.CustomerGender;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.OrderRepository;
import com.example.gasManager.service.CustomerService;
import com.example.gasManager.service.OrderService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

//        CustomerDTO customer0 = new CustomerDTO(
//                "John Doe",
//                CustomerGender.MALE,
//                "123456789",
//                "987654321",
//                "Example Neighborhood",
//                "Example Street",
//                "123",
//                "Near Example Landmark"
//        );
//
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customer0, customer);
//
//        customerService.saveCustomer(customer0);
//
//        Order order = new Order(100.0, Instant.now(), customer);
//        Order order1 = new Order(540.0, Instant.now(), customer);
//        Order order2 = new Order( 250.0, Instant.now(), customer);
//        Order order3 = new Order(1000.0, Instant.now(), customer);
//
//        orderService.saveAll(Arrays.asList(order, order1, order2, order3));
    }
}
