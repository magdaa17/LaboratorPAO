package services;

import models.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Services {

    public void richestEmployee(ArrayList<Employee> E){

        Comparator <Employee> byFortune = Comparator.comparing(Employee::getSalary);
        Collections.sort(E,byFortune);

        String x = E.get(E.size()-1).getName();
        System.out.println(x);
    }

    public static void Display()
    {

        System.out.println("You can do the following operations \n\n" +
                "1.You can add a new employee in one of the company's departments\n"+
                "2.You can delete an emplyee from one of the company's departments\n"+
                "3.You can print all software companies\n"+
                "4.You can print all hardware companies\n"+
                "5.You can increase the salary of all employees in a company \n"+
                "6.You can decrease the salary of all employees from a department\n"+
                "7.You can print the companies who offer an average salary > x\n"+
                "8.You can delete a certain company from the company list\n"+
                "9.You can print the total salary payed by a company\n"+
                "10.You can print the richest employee from a company\n"
        );
    }


}



