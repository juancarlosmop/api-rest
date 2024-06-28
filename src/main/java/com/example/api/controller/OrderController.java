package com.example.api.controller;

import com.example.api.model.dto.ClientDTO;
import com.example.api.model.dto.OrderDTO;
import com.example.api.model.dto.response.GeneralResponseDTO;
import com.example.api.model.dto.response.RqOrderDTO;
import com.example.api.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @GetMapping
    public ResponseEntity<GeneralResponseDTO> getAllOrder() {
        return ResponseEntity.ok( iOrderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(iOrderService.getOrderById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<GeneralResponseDTO>  createOrder(@RequestBody @Valid RqOrderDTO order) {
        return ResponseEntity.ok(iOrderService.saveOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO>  updateOrderById(@PathVariable Long id, @RequestBody @Valid RqOrderDTO order) {
        return ResponseEntity.ok( iOrderService.updateOrder(id,order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> deleteOrderById(@PathVariable Long id) {
        return ResponseEntity.ok( iOrderService.deleteOrder(id));
    }
}
