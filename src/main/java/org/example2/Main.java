package org.example2;

import org.example2.adapter.impl.EmployeeOriginatorAdapter;
import org.example2.adapter.impl.ProductOriginatorAdapter;
import org.example2.caretaker.Caretaker;
import org.example2.caretaker.ICaretaker;
import org.example2.originator.EmployeeOriginator;
import org.example2.originator.ProductOriginator;

public class Main {
    public static void main(String[] args) {
        /*Importante el uso del patron adapter es recomendado si se sabe bien que atributos son los de las clases y
        * si estos no tienden a cambiar con frecuencia, sino las clases se que dependan del originator se van a tener
        * que modificar cada vez que se modifique lo cual no es muy recomendable ni comodo.
        *
        * Este patron tambien se bastante util usarlo con el patron command, ya que el command es una clase que envuelve
        * una accion y solo expone un unico metodo para ejecutar dicha accion, entonces si se combina con este se puede
        * guardar un estado del objeto cuando se ejecute el metodo antes de ejecutar la logica del command y luego desde
        * el invoker como se puede ir almacenando un historial de los commands ejecutados entonces se puede implementar
        * facilmente un "deshacer" en donde simplemente va revirtiendo la logica que realizó cada command*/

        //Creación de las clases originator
        /*
        * Antes de aplicar el patron adapter
        * IOriginator<ProductOriginator> productOriginator = new ProductOriginator("Laptop", 10, 1000.0);
        * IOriginator<EmployeeOriginator> employeeOriginator = new EmployeeOriginator("John Doe", 12345L, true);
        * */

        ProductOriginatorAdapter productOriginator = new ProductOriginatorAdapter(new ProductOriginator("Laptop", 10, 1000.0));
        EmployeeOriginatorAdapter employeeOriginator = new EmployeeOriginatorAdapter(new EmployeeOriginator("John Doe", 12345L, true));

        System.out.println("Recien creadas las clases originator");
        System.out.println(productOriginator);
        System.out.println(employeeOriginator);
        System.out.println();

        //Creación de las clases memento
        ICaretaker<ProductOriginator> productCaretaker = new Caretaker<>();
        ICaretaker<EmployeeOriginator> employeeCaretaker = new Caretaker<>();

        //Guardando el estado de los originator
        productCaretaker.addMemento(productOriginator.saveMemento());
        employeeCaretaker.addMemento(employeeOriginator.saveMemento());

        /*Cuando se siguen los principios SOLID, sobretodo el principio #5 y desde mi main creo objetos de tipo
        * interfaz (lineas 12 y 13, objetos de tipo IOriginator antes de aplicar el patron adapter) y luego quiero
        * modificar los atributos de una clase en específico se complica un poco porque cuando estoy creando
        * la interfaz no se que clases la implementaran, ni con que atributos,
        * además de que no sería correcto asignarle un montón de métodos a una interfaz
        * que no le corresponde entonces para permitir la modificación es posible basarse de otros patrones de diseño
        * como el adapter, el command, visitor, etc.
        * En este main lo voy a realizar con el adapter
        * */

        //Modificando el estado de los originator
        productOriginator.setName("Desktop");
        productOriginator.setQuantity(20);
        productOriginator.setPrice(2000.0);

        employeeOriginator.setEmployeeName("Jane Doe");
        employeeOriginator.setEmployeeId(54321L);
        employeeOriginator.setActive(false);

        System.out.println("Después de modificar el estado de los originator");
        System.out.println(productOriginator);
        System.out.println(employeeOriginator);
        System.out.println();

        //Guardando el estado de los originator
        productCaretaker.addMemento(productOriginator.saveMemento());
        employeeCaretaker.addMemento(employeeOriginator.saveMemento());

        //Restaurando el estado de los originator
        productOriginator.restoreStateFromMemento(productCaretaker.getMemento(0));
        employeeOriginator.restoreStateFromMemento(employeeCaretaker.getMemento(0));

        System.out.println("Después de restaurar el estado de los originator");
        System.out.println(productOriginator);
        System.out.println(employeeOriginator);

    }
}
