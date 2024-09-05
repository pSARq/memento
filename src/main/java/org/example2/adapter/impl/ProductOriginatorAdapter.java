package org.example2.adapter.impl;

import org.example2.adapter.IProductAdapter;
import org.example2.memento.IMemento;
import org.example2.originator.ProductOriginator;

public class ProductOriginatorAdapter implements IProductAdapter {
    private final ProductOriginator productOriginator;

    public ProductOriginatorAdapter(ProductOriginator productOriginator) {
        this.productOriginator = productOriginator;
    }

    @Override
    public String getName() {
        return productOriginator.getName();
    }

    @Override
    public void setName(String name) {
        productOriginator.setName(name);
    }

    @Override
    public int getQuantity() {
        return productOriginator.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        productOriginator.setQuantity(quantity);
    }

    @Override
    public double getPrice() {
        return productOriginator.getPrice();
    }

    @Override
    public void setPrice(double price) {
        productOriginator.setPrice(price);
    }

    @Override
    public String toString() {
        return "ProductOriginatorAdapter{" +
                "productOriginator=" + productOriginator +
                '}';
    }

    @Override
    public IMemento<ProductOriginator> saveMemento() {
        return productOriginator.saveMemento();
    }

    @Override
    public void restoreStateFromMemento(IMemento<ProductOriginator> memento) {
        productOriginator.restoreStateFromMemento(memento);
    }
}
