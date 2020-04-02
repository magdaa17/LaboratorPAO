import models.Boss;
import models.Company;
import models.Employee;
import models.Software_Company;
import models.departments.HR_Department;
import models.departments.IT_Department;
import models.departments.Sales_Department;
import services.Services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;

public class Main {

    public static void main(String[] args) {

        int nr_companies,flag=0,i;

        Scanner in=new Scanner(System.in);
        System.out.println("How many companies do you want to add in the list?");

        nr_companies=in.nextInt();

        ArrayList<Company> companies = new ArrayList<Company>();


        /*  Adding Employees

        Employee X = new Employee("Bill Gates", 2000000, 63);
        Employee Y = new Employee("Melinda Gates", 1000000, 53);
        Employee Z = new Employee("Paul Allen", 20000, 60);

        HR_Department Hihi = new HR_Department();

        Hihi.addEmployee(X);
        Hihi.addEmployee(Y);
        Hihi.addEmployee(Z);

        Hihi.display();

       */


        /* Finding out the richest emplyee

        ArrayList<Employee> E = new ArrayList<Employee>();
        Employee X = new Employee("Bill Gates", 2000000, 63);
        Employee Y = new Employee("Melinda Gates", 1000000, 53);
        Employee Z = new Employee("Paul Allen", 20000, 60);
        E.add(X);
        E.add(Y);
        E.add(Z);

        Services findOut = new Services();

        findOut.richestEmployee(E);

    */
        for(i=0; i<nr_companies; ++i)
        {
            System.out.println("Do you want a Hardware or a Software Company?");
            String answer=in.next();
            System.out.println(answer);


            if(answer.equals("software"))
            {
                System.out.println("Who is the boss of the company? What is his name, age and fortune?");

                String name1=in.next();
                int age=in.nextInt();
                int fortune=in.nextInt();

                System.out.println("How many applications did the Software Company make?");

                int  number_app=in.nextInt();
                Company comp=new Software_Company(new Boss(name1,age,fortune),new HR_Department(),new IT_Department(),new Sales_Department(),number_app);
                companies.add(comp);
            }

        }

    }
}

