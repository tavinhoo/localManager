package com.example.gasManager.repository;

import com.example.gasManager.model.OrderItem;
import com.example.gasManager.model.PK.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
