package models.departments;

import models.Employee;

import java.util.ArrayList;

 public class HR_Department {

    int nr_employees;
    ArrayList<Employee> employees;

    public HR_Department() {
        this.nr_employees = 0;
        employees = new ArrayList<>();
    }

    public int getNr_employees() {
        return nr_employees;
    }

    public void setNr_employees(int nr_employees) {
        this.nr_employees = nr_employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void display()
    {
        System.out.println(nr_employees);
        System.out.println();
        for(Employee x:employees)
        {
            System.out.println(x.getAge());
            System.out.println(x.getName());
            System.out.println(x.getSalary());
            System.out.println();
        }
    }

    public void addEmployee(Employee x)
    {
        employees.add(x);
        this.nr_employees++;
    }


     public void removeEmployee(Employee x)
     {
         for(Employee i:employees)
             if(i.getAge()==x.getAge() && i.getName()==x.getName() && i.getSalary()==x.getSalary())
                 employees.remove(i);

         this.nr_employees--;
     }

     public void salaryIncrease(int x)
    {
        for(Employee i:employees)
            i.setSalary(i.getSalary()+x);
    }


    public void salaryDecrease(int x)
    {
        for(Employee i:employees)
            i.setSalary(i.getSalary()-x);

    }

}
