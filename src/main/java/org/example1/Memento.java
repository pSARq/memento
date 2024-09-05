package org.example1;

/*La clase Memento se encarga de almacenar el estado de la clase Originator (clase de la cual se quiere almacenar el historial),
es decir, esta clase es como una copia.
* Esta clase debe ser inmutable para asegurar el estado del momento en el que se creó*/
public record Memento(String state) implements IMemento {
    @Override
    public String getState() {
        return state;
    }
}
