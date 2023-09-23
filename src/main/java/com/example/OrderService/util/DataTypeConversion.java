package com.example.OrderService.util;
import com.example.OrderService.dto.OrderDTO;
import com.example.OrderService.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private ModelMapper modelMapper;

    DataTypeConversion(){
        this.modelMapper = new ModelMapper();
    }

   public OrderDTO getCustomerDTO(Order customer){
        return modelMapper.map(customer, OrderDTO.class);
    }
    public Order getCustomerEntity(OrderDTO customerDTO){
        return modelMapper.map(customerDTO, Order.class);
    }
}
