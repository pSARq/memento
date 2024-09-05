package org.example2.caretaker;

import org.example2.memento.IMemento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker<T> implements ICaretaker<T> {
    private final List<IMemento<T>> mementoList;

    public Caretaker() {
        this.mementoList = new ArrayList<>();
    }

    @Override
    public void addMemento(IMemento<T> memento) {
        mementoList.add(memento);
    }

    @Override
    public IMemento<T> getMemento(int index) {
        return mementoList.get(index);
    }
}
