package dev.thoon.pshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.thoon.pshop.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAll();

    OrderItem save(OrderItem orderItem);

    @Modifying
    @Query(value = "delete from order_item as oi where oi.id=:productId and oi.id_order=:orderId ", nativeQuery = true)
    void deleteByIdAndClientOrder_Id(@Param("productId") long productId, @Param("orderId") long orderId);

    void deleteOrderItemByIdAndClientOrderId(Long id, Long orderId);
}
