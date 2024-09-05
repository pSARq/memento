package org.example1;

/*La clase Originator es la clase a la que se le desea sacar una copia (memento) para almacenarlo en un historial poder
* hacer un "deshacer/rehacer" */
public class Originator implements IOriginator {
    private String state;

    @Override
    public IMemento createMemento() {
        return new Memento(state);
    }

    @Override
    public void restoreMemento(IMemento memento) {
        this.state = memento.getState();
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }
}
