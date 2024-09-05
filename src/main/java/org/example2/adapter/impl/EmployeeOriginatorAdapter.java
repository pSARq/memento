package org.example2.adapter.impl;

import org.example2.adapter.IEmployeeAdapter;
import org.example2.memento.IMemento;
import org.example2.originator.EmployeeOriginator;

public class EmployeeOriginatorAdapter implements IEmployeeAdapter {
    private final EmployeeOriginator employeeOriginator;

    public EmployeeOriginatorAdapter(EmployeeOriginator employeeOriginator) {
        this.employeeOriginator = employeeOriginator;
    }

    @Override
    public String getEmployeeName() {
        return employeeOriginator.getEmployeeName();
    }

    @Override
    public void setEmployeeName(String name) {
        employeeOriginator.setEmployeeName(name);
    }

    @Override
    public long getEmployeeId() {
        return employeeOriginator.getEmployeeId();
    }

    @Override
    public void setEmployeeId(long id) {
        employeeOriginator.setEmployeeId(id);
    }

    @Override
    public boolean isActive() {
        return employeeOriginator.isActive();
    }

    @Override
    public void setActive(boolean active) {
        employeeOriginator.setActive(active);
    }

    @Override
    public String toString() {
        return "EmployeeOriginatorAdapter{" +
                "employeeOriginator=" + employeeOriginator +
                '}';
    }

    @Override
    public IMemento<EmployeeOriginator> saveMemento() {
        return employeeOriginator.saveMemento();
    }

    @Override
    public void restoreStateFromMemento(IMemento<EmployeeOriginator> memento) {
        employeeOriginator.restoreStateFromMemento(memento);
    }
}
