package models.departaments;

import models.Employee;

public interface Departaments {

    void display();
    void addEmployee(Employee x);
    void removeEmployee(Employee x);
    void salaryIncrease(int x);
    void salaryDecrease(int x);
    int SearchEmployee(String name);
    void removeEmployee(String name_employee);

}
