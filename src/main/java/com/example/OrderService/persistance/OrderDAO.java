package com.example.OrderService.persistance;

import com.example.OrderService.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends CrudRepository<Order,String> {
    Order save(Order order);
    Order getOrderByOrderId(String code);
//    Customer getSelectedOrder(String code, String orderId);
    void deleteByOrderId(String code);
}
