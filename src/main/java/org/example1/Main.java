package org.example1;

public class Main {
    public static void main(String[] args) {
        /*En el ejemplo 2 se van a realizar con 2 clases originator, cada una con diferentes atributos, modificando un
        * poco las interfaces para que sean dinámicas y no dependan de una única clase*/
        IOriginator originator = new Originator();
        ICaretaker caretaker = new Caretaker();

        originator.setState("Estado 1");
        caretaker.addMemento(originator.createMemento());

        originator.setState("Estado 2");
        caretaker.addMemento(originator.createMemento());

        originator.setState("Estado 3");
        System.out.println("Estado actual: " + originator.getState());

        originator.restoreMemento(caretaker.getMemento(0));
        System.out.println("Estado restaurado a: " + originator.getState());

        originator.restoreMemento(caretaker.getMemento(1));
        System.out.println("Estado restaurado a: " + originator.getState());
    }
}