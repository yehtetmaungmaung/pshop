package dev.thoon.pshop.services;

import java.util.List;

import org.springframework.data.domain.Page;

import dev.thoon.pshop.dto.ClientOrderForm;
import dev.thoon.pshop.dto.EditOrderDTO;
import dev.thoon.pshop.dto.CardItemDTO;
import dev.thoon.pshop.entity.ClientOrder;
import dev.thoon.pshop.entity.Status;
import dev.thoon.pshop.model.ShoppingCart;

public interface OrderService {

    List<ClientOrder> getAllNewOrders();

    ClientOrder newClientOrder(ShoppingCart shoppingCart, ClientOrderForm clientOrderForm);

    ClientOrder newClientOrder(CardItemDTO cardItemDTO);

    List<ClientOrder> getOrdersByStatus(String status);

    long getCountNewOrders(String status);

    List<ClientOrder> getAll();

    List<ClientOrder> getTodayOrder();

    Page<ClientOrder> getOrdersLimit(int page, int limit, String status);

    Page<ClientOrder> getOrdersLimit(int page, int limit);

    List<ClientOrder> findOrderByName(String name);

    ClientOrder findOrderByPhone(String phone);

    List<Status> getAllStatusOrders();

    ClientOrder getClientOrderById(long id);

    ClientOrder updateClientOrderItem(long orderId, long productId, int count);

    ClientOrder updateClientOrder(EditOrderDTO editOrderDTO);

    void deleteOrder(Long id);

    void deleteOrder(ClientOrder clientOrder);

    void deleteItemFromClientOrder(long productId, long orderId);
}
