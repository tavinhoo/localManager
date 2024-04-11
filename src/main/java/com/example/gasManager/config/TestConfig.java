package com.example.gasManager.config;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.DTO.ProductDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Order;
import com.example.gasManager.model.OrderItem;
import com.example.gasManager.model.enums.CustomerGender;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.OrderRepository;
import com.example.gasManager.service.CustomerService;
import com.example.gasManager.service.OrderService;
import com.example.gasManager.service.ProductService;
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

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        CustomerDTO customer0dto = new CustomerDTO(
                "John Doe",
                CustomerGender.MALE,
                "1234567890",
                null,
                "Example Neighborhood",
                "Example Street",
                "123",
                "Example Reference"
        );

        CustomerDTO customer1dto = new CustomerDTO(
                "Selena",
                CustomerGender.FEMALE,
                "1234567890",
                null,
                "Example Neighborhood",
                "Example Street",
                "123",
                "Example Reference"
        );

        CustomerDTO customer2dto = new CustomerDTO(
                "Gabriel",
                CustomerGender.MALE,
                "1234567890",
                null,
                "Example Neighborhood",
                "Example Street",
                "123",
                "Example Reference"
        );

        CustomerDTO customer3dto = new CustomerDTO(
                "Martina",
                CustomerGender.FEMALE,
                "1234567890",
                null,
                "Example Neighborhood",
                "Example Street",
                "123",
                "Example Reference"
        );

        customerService.saveCustomer(customer0dto);
        customerService.saveCustomer(customer1dto);
        customerService.saveCustomer(customer2dto);
        customerService.saveCustomer(customer3dto);

        ProductDTO product0 = new ProductDTO(
                "Botijão de Gás",
                115.00
        );

        ProductDTO product1 = new ProductDTO(
                "Galão d'água 20L",
                12.00
        );

        productService.saveProduct(product0);
        productService.saveProduct(product1);

        Customer customer0 = new Customer();

        BeanUtils.copyProperties(customer0dto, customer0);

        Order o1 = new Order(Instant.now(), customer0);
    }
}
