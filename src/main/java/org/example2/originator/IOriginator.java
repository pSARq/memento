package org.example2.originator;

import org.example2.memento.IMemento;

public interface IOriginator<T> {
    IMemento<T> saveMemento();
    void restoreStateFromMemento(IMemento<T> memento);
}
