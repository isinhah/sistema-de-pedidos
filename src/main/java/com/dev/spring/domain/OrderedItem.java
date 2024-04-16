package com.dev.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderedItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //Chave composta contendo o pedido e produto
    @JsonIgnore
    @EmbeddedId
    private OrderedItemPK id = new OrderedItemPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public OrderedItem() {}

    public OrderedItem(Order order, Product product, Double discount, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    @JsonIgnore
    public Product getProduct() {
        return id.getProduct();
    }

    public OrderedItemPK getId() {
        return id;
    }

    public void setId(OrderedItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedItem that = (OrderedItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
