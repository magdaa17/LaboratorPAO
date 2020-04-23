import models.Employee;
import models.Company;

import java.util.*;

public class Main {


    public static void main(String[] args) {

    int nr_Companys,flag=0,i;


    Scanner in=new Scanner(System.in);

        ArrayList<Company>  Companies = new ArrayList<Company>();


        Services Services= new Services();
        Services.ReadCompanies(Companies);
        Services.ReadEmployess(Companies);
        System.out.println(Companies.size());
        Services.addBosses(Companies);

        Collections.sort(Companies);

        PriorityQueue<Company> pQueue = new PriorityQueue<Company>();

        for(Company comp:Companies)
            pQueue.add(comp);

        Iterator<Company> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next().getName());

            Services.Display();
        System.out.println("Cate servicii doriti?");

        int nr_services=in.nextInt();

        for(i=0; i<nr_services; i++)
        {
            System.out.println("Numarul serviciului dorit:");
            int number = in.nextInt();

            if (number == 1)
            {
                System.out.println("Care este numele, varsta si salariul angajatulului?");
                String name_employee = in.next();
                int age = in.nextInt();
                int salary = in.nextInt();
                System.out.println("In ce companie si in ce departament(IT/HR/SALES) se va afla acest angajat?");
                String company=in.next();
                String dep=in.next();
                
                Services.addEmployee(Companies,company,dep,new Employee(name_employee,salary,age));
            }
            else if (number==2)
            {
                System.out.println("Care este numele angajatului pe care vreti sa il stergeti?");
                String name_employee=in.next();
                System.out.println("Din ce companie?");
                String company_name=in.next();
                Services.removeEmployee(Companies,company_name,name_employee);

            }
            else if (number==3)
                Services.allHardware(Companies);

            else if(number==4)
                Services.allSoftware(Companies);

            else if(number==5)
            {
                System.out.println("La ce companie crestem salariile?");
                String comp_name=in.next();
                System.out.println("In ce departament?(HR/IT/SALES)");
                String dep_name=in.next();
                System.out.println("Cu ce suma?");
                int value=in.nextInt();

                for(int j=0; j<Companies.size(); j++)
                    if(Companies.get(j).getName().equals(comp_name))
                {
                    if(dep_name.equals("IT"))
                        Companies.get(j).getIt().salaryIncrease(value);
                    if(dep_name.equals("HR"))
                        Companies.get(j).getHr().salaryIncrease(value);
                    if(dep_name.equals("SAlES"))
                        Companies.get(j).getSales().salaryIncrease(value);
                }
            }

            else if(number==6)
            {
                System.out.println("La ce companie scadem salariile?");
                String comp_name=in.next();
                System.out.println("In ce departament?(HR/IT/SALES)");
                String dep_name=in.next();
                System.out.println("Cu ce suma?");
                int value=in.nextInt();

                for(int j=0; j<Companies.size(); j++)
                    if(Companies.get(j).getName().equals(comp_name))
                    {
                        if(dep_name.equals("IT"))
                            Companies.get(j).getIt().salaryDecrease(value);
                        if(dep_name.equals("HR"))
                            Companies.get(j).getHr().salaryDecrease(value);
                        if(dep_name.equals("SAlES"))
                            Companies.get(j).getSales().salaryDecrease(value);
                    }
            }
            else if(number==7)
            {
                System.out.println("Afisam toate companiile cu salariul mediu peste suma...?");
                double value=in.nextDouble();
                Services.overAverage(Companies,value);
            }

            else if(number==8)
            {
                System.out.println("Ce companie doriti sa stergeti din lista de companii?");
                String comp_name=in.next();
                Services.removeCompany(Companies,comp_name);
            }
            else if(number==9)
            {
                System.out.println("Pentru ce companie va intereseaza salariul lunar platit?");
                String comp_name=in.next();
                System.out.println(Services.monthlySalary(Companies,comp_name));
            }

            else if(number==10)
            {
                Services.displayCEO(Companies);
            }

            else if(number==11)
            {
                Services.AddCompany(Companies);
            }
            else if(number==12)
            {
                Services.removeCompany(pQueue);
            }
        }

        Services.list_HR_Department(Companies);
        Services.list_IT_Department(Companies);
        Services.list_Sales_Department(Companies);
        itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next().getName());

    }

}
