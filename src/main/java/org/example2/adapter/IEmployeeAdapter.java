package org.example2.adapter;

import org.example2.originator.EmployeeOriginator;
import org.example2.originator.IOriginator;

public interface IEmployeeAdapter extends IOriginator<EmployeeOriginator> {
    String getEmployeeName();
    void setEmployeeName(String name);
    long getEmployeeId();
    void setEmployeeId(long id);
    boolean isActive();
    void setActive(boolean active);
}
