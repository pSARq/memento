package org.example2.adapter;

import org.example2.originator.IOriginator;
import org.example2.originator.ProductOriginator;

public interface IProductAdapter extends IOriginator<ProductOriginator> {
    String getName();
    void setName(String name);
    int getQuantity();
    void setQuantity(int quantity);
    double getPrice();
    void setPrice(double price);
}
