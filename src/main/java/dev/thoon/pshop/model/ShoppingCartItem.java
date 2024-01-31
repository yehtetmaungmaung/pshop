package dev.thoon.pshop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import dev.thoon.pshop.entity.Product;
import dev.thoon.pshop.utils.Views;

public class ShoppingCartItem implements Serializable {
    private static final long serialVersionUID = 1689073980159902317L;
    @JsonView(Views.Public.class)
    private Product product;
    private int count;

    public ShoppingCartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
