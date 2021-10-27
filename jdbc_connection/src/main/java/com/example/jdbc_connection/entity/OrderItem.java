package com.example.jdbc_connection.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    private String itemCount;

    @JoinTable(name = "orders", joinColumns = {@JoinColumn(name = "orderId")})
    @ManyToOne
    private Order order;


    public OrderItem() {
    }

    public OrderItem(Long orderItemId, String itemCount) {
        this.orderItemId = orderItemId;
        this.itemCount = itemCount;
    }

    public OrderItem(Long orderItemId, String itemCount, Order order) {
        this.orderItemId = orderItemId;
        this.itemCount = itemCount;
        this.order = order;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", itemCount='" + itemCount + '\'' +
                ", order=" + order +
                '}';
    }
}