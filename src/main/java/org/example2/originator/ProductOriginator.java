package org.example2.originator;

import org.example2.memento.IMemento;
import org.example2.memento.Memento;

public class ProductOriginator implements IOriginator<ProductOriginator> {
    private String name;
    private int quantity;
    private double price;

    public ProductOriginator(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /*Constructor para pasar una instancia al memento*/
    private ProductOriginator(ProductOriginator productOriginator) {
        this.name = productOriginator.getName();
        this.quantity = productOriginator.getQuantity();
        this.price = productOriginator.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductOriginator{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    /*Se clona el objeto actual antes de pasar al memento para evitar que se le pase la misma referencia de memoria
    * al caretaker y asi evitar que se modifiquen los mementos ya guardados*/
    @Override
    public IMemento<ProductOriginator> saveMemento() {
        return new Memento<>(new ProductOriginator(this));
    }

    @Override
    public void restoreStateFromMemento(IMemento<ProductOriginator> memento) {
        ProductOriginator productOriginator = memento.getState();
        this.name = productOriginator.getName();
        this.quantity = productOriginator.getQuantity();
        this.price = productOriginator.getPrice();
    }
}
