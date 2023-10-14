package com.brunobessa.aula01.services;

import com.brunobessa.aula01.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private ShippingService shippingService;

    @Autowired
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }
    public Double total(Order order){
        return order.getBasic() - (order.getBasic() * order.getDiscount() / 100) + shippingService.shipment(order);
    }

}
