package com.example.gasManager.model;

import com.example.gasManager.model.enums.PaymentMethod;
import com.example.gasManager.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_orderItem")
public class OrderItem{

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private Double price;

    private Integer paymentStatus;

    private Integer paymentMethod;

    public OrderItem() {

    }

    public OrderItem(Order order, Product product, Integer quantity, Double price, PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        setPaymentStatus(paymentStatus);
        setPaymentMethod(paymentMethod);
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price, PaymentStatus paymentStatus) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        setPaymentStatus(paymentStatus);
        if(paymentStatus.getCode() == PaymentStatus.PENDING.getCode()) {
            paymentMethod = PaymentMethod.NONE.getCode();
        } else {
            setPaymentMethod(paymentMethod);
        }
    }

    public Long getId() {
        return orderItemId;
    }

    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @JsonManagedReference
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() throws IllegalAccessException {
        return PaymentStatus.valueOf(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus ps) {
        if(ps != null) {
            this.paymentStatus = ps.getCode();
        }
    }

    public PaymentMethod getPaymentMethod() throws IllegalAccessException {
        return PaymentMethod.valueOf(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod pm) {
        if(pm != null) {
            this.paymentMethod = pm.getCode();
        }
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(orderItemId, orderItem.orderItemId) && Objects.equals(order, orderItem.order) && Objects.equals(product, orderItem.product) && Objects.equals(quantity, orderItem.quantity) && Objects.equals(price, orderItem.price) && Objects.equals(paymentStatus, orderItem.paymentStatus) && Objects.equals(paymentMethod, orderItem.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, order, product, quantity, price, paymentStatus, paymentMethod);
    }
}
