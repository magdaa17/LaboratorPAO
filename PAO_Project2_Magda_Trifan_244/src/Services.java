import models.*;
import models.departaments.HR_Department;
import models.departaments.IT_Department;
import models.departaments.Sales_Department;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Services {

    public static Logger logger;

    public Services()
    {
        logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            logger.setUseParentHandlers(false);
            // This block configure the logger with handler and formatter
            fh = new FileHandler("logger.csv");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
           // logger.info("START PROGRAM");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void Display()
    {

        logger.info("Display function called");



        System.out.println("BUNA ZIUA SI BUN VENIT IN APLICATIA NOASTRA!" +
                            "  Puteti face urmatoarele operatii \n\n" +
                            "1.Puteti adauga un angajat intr-un anumit departament intr-o companie companie\n"+
                            "2.Puteti sterge un angajat dintr-o companie \n"+
                            "3.Puteti afisa toate companiile hardware\n"+
                            "4.Puteti afisa toate companiile software\n"+
                            "5.Puteti creste salariul tuturor membrilor unui departament dintr-o companie\n"+
                            "6.Puteti scadea salariul tuturor membrilor unui departament dintr-o companie\n"+
                            "7.Puteti afisa toate companiile care ofera un salariu mediu de peste suma x\n"+
                            "8.Puteti sterge din lista de companii o anumita companie\n"+
                            "9.Puteti afisa salariul lunar total platit de o anumita companie\n"+
                            "10.Puteti afisa cel mai bogat CEO din lista de companii\n"+
                            "11.Puteti adauga o companie in lista de companii\n"+
                            "12.Puteti sterge o companie din lista de companii\n"


        );
    }

    public static void addEmployee(ArrayList<Company> Companies, String company_name, String dep_name, Employee employee)
    {
        logger.info("addEmployee function called");
        String FILENAME = "Angajati.csv";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write('\n');

            String[] data1 = { employee.getName(), Integer.toString(employee.getAge()), Integer.toString(employee.getSalary()),company_name,dep_name};
            for(int i=0;i<data1.length;i++)
            {
                bw.write(data1[i]);
                if(i!=data1.length-1) bw.write(',');
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }



        for(int i=0; i<Companies.size(); i++)
        {
            if (Companies.get(i).getName().equals(company_name))
            {
                    if(dep_name.equals("HR"))
                         Companies.get(i).getHr().addEmployee(employee);
                    if(dep_name.equals("IT"))
                        Companies.get(i).getIt().addEmployee(employee);
                    if(dep_name.equals("SALES"))
                    Companies.get(i).getSales().addEmployee(employee);

            }
        }
    }

    public static void removeEmployee(ArrayList<Company>Companies, String company_name,String name_employee)
    {
        logger.info("removeEmployee function called");
        for(int i=0; i<Companies.size(); i++) {
            if (Companies.get(i).getName().equals(company_name)) {
                if (Companies.get(i).getIt().SearchEmployee(name_employee) == 1)
                    Companies.get(i).getIt().removeEmployee(name_employee);
                if (Companies.get(i).getHr().SearchEmployee(name_employee) == 1)
                    Companies.get(i).getHr().removeEmployee(name_employee);
                if (Companies.get(i).getSales().SearchEmployee(name_employee) == 1)
                    Companies.get(i).getSales().removeEmployee(name_employee);
            }
        }
    }

    public static void allHardware(ArrayList<Company> Companies)
    {
        logger.info("allHardware function called");
        for(int i=0; i<Companies.size(); i++)
            if(Companies.get(i).getClass()==Hardware_Company.class)
                System.out.println(Companies.get(i).getName());
    }

    public static void allSoftware(ArrayList<Company> Companies)
    {
        logger.info("allSoftware function called");
        for(int i=0; i<Companies.size(); i++)
            if(Companies.get(i).getClass()== Software_Company.class)
                System.out.println(Companies.get(i).getName());
    }

    public static void overAverage(ArrayList<Company> Companies,double value)
    {
        logger.info("overAverage function called");
        for(int j=0;j<Companies.size();j++)
        {
            double sum = 0;
            for (Employee i : Companies.get(j).getHr().getEmployeei())
                sum = sum + i.getSalary();
            for (Employee i : Companies.get(j).getIt().getEmployeei())
                sum = sum + i.getSalary();
            for (Employee i : Companies.get(j).getSales().getEmployeei())
                sum = sum + i.getSalary();
            if (sum / (Companies.get(j).getIt().getNr_Employeei() + Companies.get(j).getHr().getNr_Employeei() + Companies.get(j).getSales().getNr_Employeei()) > value)
                System.out.println(Companies.get(j).getName());
        }
    }

    public static void removeCompany(ArrayList<Company> Companies,String comp_name)
    {
        logger.info("removeCompany function called");
        for(int i=0;i< Companies.size();i++)
            if(Companies.get(i).getName().equals(comp_name))
            {
                Companies.remove(i);
                break;
            }
    }

    public static int monthlySalary(ArrayList<Company> Companies,String comp_name)
    {
        logger.info("monthlySalary function called");
        int salary=0;
        for(int i=0; i<Companies.size(); i++)
        {

            if(Companies.get(i).getName().equals(comp_name))
            {
                for(Employee j:Companies.get(i).getIt().getEmployeei())
                    salary=salary+j.getSalary();
                for(Employee j:Companies.get(i).getHr().getEmployeei())
                    salary=salary+j.getSalary();
                for(Employee j:Companies.get(i).getSales().getEmployeei())
                    salary=salary+j.getSalary();
            }
        }
        return salary;
    }

    public static void displayCEO(ArrayList<Company> Companies)
    {
        logger.info("displayCEO function called");

        int highest=0;
        Boss boss=new Boss();
        String company=new String();
        for(int i=0;i<Companies.size();i++)
        {
            if(Companies.get(i).getBoss().getFortune()>highest)
            {
                highest = Companies.get(i).getBoss().getFortune();
                boss.setAge(Companies.get(i).getBoss().getAge());
                boss.setFortune(Companies.get(i).getBoss().getFortune());
                boss.setName(Companies.get(i).getBoss().getName());
                company=Companies.get(i).getName();
            }
        }

        System.out.println("Cel mai bogat CEO este " + boss.getName() + ", director al Companiei " + company + " cu o avere de " + boss.getFortune() + " avand varsta de " + boss.getAge() + " ani");

    }

    public static void ReadCompanies(ArrayList<Company> Companies)
    {
        logger.info("ReadCompanies function called");
        String fileName="companii.csv";
        File file= new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext())
            {
                String data = inputStream.next();
                String[] values = data.split(",");

                if (values.length > 0)
                {
                    if (values[0].equals("software"))
                    {
                        Company comp = new Software_Company(values[1], new Boss(values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4])), new HR_Department(), new IT_Department(), new Sales_Department(), Integer.parseInt(values[5]));
                        Companies.add(comp);
                    }
                    else if (values[0].equals("hardware"))
                    {

                        Company comp = new Hardware_Company(values[1], new Boss(values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4])), new HR_Department(), new IT_Department(), new Sales_Department(), Integer.parseInt(values[5]));
                        Companies.add(comp);
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void AddCompany(ArrayList<Company> Companies)
    {
        logger.info("AddCompany function called");
        String FILENAME = "companii.csv";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            Scanner in=new Scanner(System.in);
            System.out.println("Ce tip de Company introducem in lista (hardware/software)?");
            String answer = in.next();
            bw.write('\n');
            if (answer.equals("software"))
            {
                System.out.println("Care este numele Companyi?");
                String comp_name=in.next();
                System.out.println("Cine este Bossul Companyi? Ce nume are, cati ani are si ce avere are?");
                String name1 = in.next();
                int age = in.nextInt();
                int fortune = in.nextInt();

                System.out.println("Cate aplicatii a realizat firma de software?");
                int number_app = in.nextInt();
                Company comp = new Software_Company(comp_name,new Boss(name1, age, fortune), new HR_Department(), new IT_Department(), new Sales_Department(), number_app);
                Companies.add(comp);

                ArrayList<Company>  Company = new ArrayList<Company>();
                Company.add(comp);
                Services.addBosses(Company);
                Company.remove(0);

                String[] data1 = { answer, comp_name, name1,Integer.toString(age),Integer.toString(fortune),Integer.toString(number_app)};
                for(int i=0;i<data1.length;i++)
                {
                    bw.write(data1[i]);
                    if(i!=data1.length-1) bw.write(',');
                }
            }
            else if (answer.equals("hardware"))
            {
                System.out.println("Care este numele companiei?");
                String comp_name=in.next();
                System.out.println("Cine este seful companiei? Ce nume are, cati ani are si ce avere are?");
                String name1 = in.next();
                int age = in.nextInt();
                int fortune = in.nextInt();

                System.out.println("La cate produse lucreaza firma de hardware?");
                int number_app = in.nextInt();
                Company comp = new Software_Company(comp_name,new Boss(name1, age, fortune), new HR_Department(), new IT_Department(), new Sales_Department(), number_app);
                Companies.add(comp);
                String[] data1 = { answer, comp_name, name1,Integer.toString(age),Integer.toString(fortune),Integer.toString(number_app)};
                for(int i=0;i<data1.length;i++)
                {
                    bw.write(data1[i]);
                    if(i!=data1.length-1) bw.write(',');
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }

    public static void removeCompany(PriorityQueue<Company> pq)
    {
        logger.info("function removeCompany called");
        System.out.println("Ce companie doriti sa eliminati din lista?");
        Scanner in=new Scanner(System.in);
        String name_comp_deleted=in.next();

        Iterator<Company> it = pq.iterator();
        while (it.hasNext())
            if(it.next().getName().equals(name_comp_deleted)) it.remove();

    }


    public static void ReadEmployess(ArrayList<Company> Companies)
    {
        logger.info("ReadEmployees function called");
        String fileName="Angajati.csv";
        File file= new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext())
            {
                String data = inputStream.next();
                String[] values = data.split(",");

                if (values.length > 0)
                {
                    Employee new_emp=new Employee(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]));
                    for(int i=0; i<Companies.size(); i++)
                    {
                        if (Companies.get(i).getName().equals(values[3]))
                        {
                            if(values[4].equals("HR"))
                                Companies.get(i).getHr().addEmployee(new_emp);
                       else if(values[4].equals("IT"))
                                Companies.get(i).getIt().addEmployee(new_emp);
                       else if(values[4].equals("SALES"))
                                Companies.get(i).getSales().addEmployee(new_emp);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void addBosses(ArrayList<Company> Companies)
    {
        logger.info("addBosses function called");

        String FILENAME = "Sefi.csv";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);


            for(int i=0;i<Companies.size();i++)
            {
                String[] data1={Companies.get(i).getBoss().getName(),Integer.toString(Companies.get(i).getBoss().getAge()),Integer.toString(Companies.get(i).getBoss().getFortune())};
                for(int j=0;j<data1.length;j++)
                {
                    bw.write(data1[j]);
                    if(j!=data1.length-1) bw.write(',');
                }
                bw.write('\n');
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    public static void list_HR_Department(ArrayList<Company> Companies)
    {
        logger.info("list_HR_Department function called");
        String FILENAME = "HR_employees.csv";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);


            for(int i=0;i<Companies.size();i++)
            {
                for(Employee x:Companies.get(i).getHr().getEmployeei())
                {

                    String[] data1 = {Companies.get(i).getName(), x.getName(),Integer.toString(x.getAge()),Integer.toString(x.getSalary())};
                    for (int j = 0; j < data1.length; j++)
                    {
                        bw.write(data1[j]);
                        if (j != data1.length - 1) bw.write(',');
                    }
                    bw.write('\n');
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    public static void list_IT_Department(ArrayList<Company> Companies)
    {
        logger.info("list_IT_Department function called");
        String FILENAME = "IT_employees.csv";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);


            for(int i=0;i<Companies.size();i++)
            {
                for(Employee x:Companies.get(i).getIt().getEmployeei())
                {

                    String[] data1 = {Companies.get(i).getName(), x.getName(),Integer.toString(x.getAge()),Integer.toString(x.getSalary())};
                    for (int j = 0; j < data1.length; j++)
                    {
                        bw.write(data1[j]);
                        if (j != data1.length - 1) bw.write(',');
                    }
                    bw.write('\n');
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }
    public static void list_Sales_Department(ArrayList<Company> Companies)
    {
        logger.info("list_Sales_Department function called");
        String FILENAME = "SALES_employees.csv";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);


            for(int i=0;i<Companies.size();i++)
            {
                for(Employee x:Companies.get(i).getSales().getEmployeei())
                {

                    String[] data1 = {Companies.get(i).getName(), x.getName(),Integer.toString(x.getAge()),Integer.toString(x.getSalary())};
                    for (int j = 0; j < data1.length; j++)
                    {
                        bw.write(data1[j]);
                        if (j != data1.length - 1) bw.write(',');
                    }
                    bw.write('\n');
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }
}





