package com.example.OrderService.service;

import com.example.OrderService.dto.CustomerOrder;
import com.example.OrderService.dto.OrderDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.exception.InvalidException;
import com.example.OrderService.exception.NotFoundException;
import com.example.OrderService.persistance.OrderDAO;
import com.example.OrderService.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private DataTypeConversion dataTypeConversion;
    @Autowired
    private OrderDAO orderDAO;


    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(UUID.randomUUID().toString());
        return dataTypeConversion.getCustomerDTO(orderDAO
                .save(dataTypeConversion.getCustomerEntity(orderDTO)));
    }

    @Override
    public OrderDTO getSelectedOrder(String code) {
        if(!orderDAO.existsById(code)) throw new InvalidException("Order not found");
        return dataTypeConversion.getCustomerDTO((orderDAO.getOrderByOrderId(code)));
    }

    @Override
    public void updateOrder(OrderDTO order) {
        Optional<Order> tmpOrder = orderDAO.findById(order.getOrderId());
        if (!tmpOrder.isPresent()) throw new RuntimeException("Order Not found");
        tmpOrder.get().setOrderValue(order.getOrderValue());
        tmpOrder.get().setOrderDate(order.getOrderDate());
    }

    @Override
    public void deleteOrder(String code) {
        if(!orderDAO.existsById(code)) throw new NotFoundException("Invalid Order");
         orderDAO.deleteByOrderId(code);
    }
    public CustomerOrder getMultipleData(@RequestBody CustomerOrder customerOrder){

        return null;
    }
}
