package org.example1;

import java.util.ArrayList;
import java.util.List;

/*Esta es la clase que se encarga de almacenar el historial de mementos para realizar la acción de "deshacer/rehacer" */
public class Caretaker implements ICaretaker {
    private final List<IMemento> mementoList;

    public Caretaker() {
        this.mementoList = new ArrayList<>();
    }

    @Override
    public void addMemento(IMemento memento) {
        mementoList.add(memento);
    }

    /*Tener en cuenta que tal cual como está este ejemplo si se intenta acceder a un
    * índice que no está dentro de la lista puede lanzar un error. Se pueden agregar
    * métodos más específicos para acceder al último elemento o en caso de que ya haya
    * restaurado el estado del objeto con un memento, otro método que me retorne el siguiente
    * elemento de la lista (rehacer), también se puede agregar otro método para
    * cuando se haya restaurado el estado anterior y luego se realice modificaciones sobre mi clase modificable (Originator)
    * entonces elimine todos los mementos que estén por delante del que se restauró
    * para evitar una inconsistencia en el historial. Pero para mantener el
    * ejemplo sencillo solo se creó un método asi*/
    @Override
    public IMemento getMemento(int index) {
        return mementoList.get(index);
    }
}
