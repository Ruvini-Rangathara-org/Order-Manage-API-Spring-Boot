package com.example.OrderService.service;


import com.example.OrderService.dto.OrderDTO;

public interface OrderService {
    OrderDTO saveCustomer(OrderDTO order);
    OrderDTO getSelectedCustomer(String code);
//    CustomerDTO getSelectedOrder(String code, String orderId);
    void updateCustomer(OrderDTO order);
    void deleteCustomer(String code);
}
