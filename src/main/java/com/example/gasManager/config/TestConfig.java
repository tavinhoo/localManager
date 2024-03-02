package com.example.gasManager.config;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Order;
import com.example.gasManager.model.enums.CustomerGender;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.OrderRepository;
import com.example.gasManager.service.CustomerService;
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

    @Override
    public void run(String... args) throws Exception {

//        CustomerDTO customer = new CustomerDTO(
//                "John Doe",
//                CustomerGender.MALE,
//                "123456789",
//                "987654321",
//                "Example Neighborhood",
//                "Example Street",
//                "123",
//                "Near Example Landmark"
//        );

//        Order order = new Order(100.0, Instant.now(), customer);
//        Order order1 = new Order(540.0, Instant.now(), customer);
//        Order order2 = new Order( 250.0, Instant.now(), customer);
//        Order order3 = new Order(1000.0, Instant.now(), customer);

//        customerService.saveCustomer(customer);
//        orderRepository.saveAll(Arrays.asList(order, order1, order2, order3));
    }
}
