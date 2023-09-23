package com.example.OrderService.api;

import com.example.OrderService.dto.OrderDTO;
import com.example.OrderService.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    OrderDTO saveOrder(@RequestBody OrderDTO orderDTO) {
        //If have errors
        return orderService.saveOrder(orderDTO);
    }

    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDTO getSelectedOrder(@PathVariable String code) {
        return orderService.getSelectedOrder(code);
    }

    @DeleteMapping(value = "{code}")
    void deleteOrder(@PathVariable String code) {
        orderService.deleteOrder(code);
    }

    @PatchMapping(value = "{code}")
    void updateOrder(@PathVariable String code, @RequestBody OrderDTO orderDTO) {
        //chk errors
        orderDTO.setOrderId(code);
        orderService.updateOrder(orderDTO);
    }

}
