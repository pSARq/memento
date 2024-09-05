package org.example2.caretaker;

import org.example2.memento.IMemento;

public interface ICaretaker<T> {
    void addMemento(IMemento<T> memento);
    IMemento<T> getMemento(int index);
}
