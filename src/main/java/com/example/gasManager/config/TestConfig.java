package com.example.gasManager.config;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.DTO.ProductDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Order;
import com.example.gasManager.model.OrderItem;
import com.example.gasManager.model.Product;
import com.example.gasManager.model.enums.CustomerGender;
import com.example.gasManager.model.enums.PaymentStatus;
import com.example.gasManager.repository.OrderItemRepository;
import com.example.gasManager.service.CustomerService;
import com.example.gasManager.service.OrderService;
import com.example.gasManager.service.ProductService;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Product p0 = productService.findProductById(1L).get();
        Product p1 = productService.findProductById(2L).get();

        Customer customer0 = new Customer();

        BeanUtils.copyProperties(customer0dto, customer0);

        Order o1 = new Order(Instant.now(), customerService.saveCustomer(customer0dto).get());

        orderService.saveOrder(o1);

        OrderItem oi1 = new OrderItem(o1, p0, 2, p0.getPrice(), PaymentStatus.PENDING);
        OrderItem oi2 = new OrderItem(o1, p1, 1, p1.getPrice(), PaymentStatus.PAID_OUT);

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2));
    }
}
