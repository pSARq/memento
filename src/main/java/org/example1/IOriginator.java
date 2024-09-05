package org.example1;

public interface IOriginator {
    IMemento createMemento();
    void restoreMemento(IMemento memento);
//    Estos métodos de aquí para abajo son propios de la clase Originator y no de la interfaz, pero decidí ponerlos aquí
    String getState();
    void setState(String state);
}
