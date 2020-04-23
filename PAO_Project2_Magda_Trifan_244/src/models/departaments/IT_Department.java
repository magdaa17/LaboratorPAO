package models.departaments;

import models.Employee;

import java.util.ArrayList;

public class IT_Department implements Departaments {

    int nr_Employeei;
    ArrayList<Employee> Employeei;


    public IT_Department()
    {
        this.nr_Employeei = 0;
        Employeei=new ArrayList<>();
    }
    public int getNr_Employeei() {
        return nr_Employeei;
    }

    public void setNr_Employeei(int nr_Employeei) {
        this.nr_Employeei = nr_Employeei;
    }

    public ArrayList<Employee> getEmployeei() {
        return Employeei;
    }

    public void setEmployeei(ArrayList<Employee> Employeei) {
        this.Employeei = Employeei;
    }

    public void display()
    {
        System.out.println(nr_Employeei);
        System.out.println();
        for(Employee x:Employeei)
        {
            System.out.println(x.getAge());
            System.out.println(x.getName());
            System.out.println(x.getSalary());
            System.out.println();
        }
    }

    public void addEmployee(Employee x)

    {
        Employeei.add(x);
        this.nr_Employeei++;
    }

    public void removeEmployee(Employee x)
    {
        for(Employee i:Employeei)
            if(i.getAge()==x.getAge() && i.getName()==x.getName() && i.getSalary()==x.getSalary())
            {
                Employeei.remove(i);
                break;
            }
    }

    public void removeEmployee(String name_employee)
    {

        for(Employee i:Employeei)
            if (i.getName().equals(name_employee))
            {
                Employeei.remove(i);
                break;
            }

        this.nr_Employeei--;

    }

    public void salaryIncrease(int x)
    {
        for(Employee i:Employeei)
            i.setSalary(i.getSalary()+x);
    }


    public void salaryDecrease(int x)
    {
        for(Employee i:Employeei)
            i.setSalary(i.getSalary()-x);

    }

    public int SearchEmployee(String name)
    {
        for(int i=0; i<Employeei.size(); i++)
            if(Employeei.get(i).getName().equals(name)) return 1;
        return 0;

    }


}
