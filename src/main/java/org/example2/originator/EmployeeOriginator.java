package org.example2.originator;

import org.example2.memento.IMemento;
import org.example2.memento.Memento;

public class EmployeeOriginator implements IOriginator<EmployeeOriginator> {
    private String employeeName;
    private long employeeId;
    private boolean isActive;

    public EmployeeOriginator(String employeeName, long employeeId, boolean isActive) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.isActive = isActive;
    }

    private EmployeeOriginator(EmployeeOriginator employeeOriginator) {
        this.employeeName = employeeOriginator.getEmployeeName();
        this.employeeId = employeeOriginator.getEmployeeId();
        this.isActive = employeeOriginator.isActive();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "EmployeeOriginator{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId=" + employeeId +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public IMemento<EmployeeOriginator> saveMemento() {
        return new Memento<>(new EmployeeOriginator(this));
    }

    @Override
    public void restoreStateFromMemento(IMemento<EmployeeOriginator> memento) {
        EmployeeOriginator employeeOriginator = memento.getState();
        this.employeeName = employeeOriginator.getEmployeeName();
        this.employeeId = employeeOriginator.getEmployeeId();
        this.isActive = employeeOriginator.isActive();
    }
}
