package com.example.OrderService.service;


import com.example.OrderService.dto.OrderDTO;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO order);
    OrderDTO getSelectedOrder(String code);
//    CustomerDTO getSelectedOrder(String code, String orderId);
    void updateOrder(OrderDTO order);
    void deleteOrder(String code);
}
