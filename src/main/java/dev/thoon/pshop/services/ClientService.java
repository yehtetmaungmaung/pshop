package dev.thoon.pshop.services;

import dev.thoon.pshop.dto.ClientOrderForm;
import dev.thoon.pshop.entity.ClientOrder;
import dev.thoon.pshop.model.ShoppingCart;

public interface ClientService {
    
    ClientOrder newClientOrder(ShoppingCart shoppingCart, ClientOrderForm clientOrderForm);
}
