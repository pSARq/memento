package org.example2.memento;

public record Memento<T>(T state) implements IMemento<T> {
    @Override
    public T getState() {
        return state;
    }
}
