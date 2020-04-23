package models;

import models.departaments.HR_Department;
import models.departaments.IT_Department;
import models.departaments.Sales_Department;

public abstract class Company implements Comparable<Company>{
    String name;
    Boss boss;
    HR_Department hr;
    IT_Department it;
    Sales_Department sales;

    public Company(String name, Boss boss, HR_Department hr, IT_Department it, Sales_Department sales) {
        this.name=name;
        this.boss = boss;
        this.hr = hr;
        this.it = it;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public HR_Department getHr() {
        return hr;
    }

    public void setHr(HR_Department hr) {
        this.hr = hr;
    }

    public IT_Department getIt() {
        return it;
    }

    public void setIt(IT_Department it) {
        this.it = it;
    }

    public Sales_Department getSales() {
        return sales;
    }

    public void setSales(Sales_Department sales) {
        this.sales = sales;
    }

    public int compareTo(Company comp)
    {
        if (this.name.equals(comp.name)) return 0;
        else if(this.name.compareTo(comp.name)<0) return -1;
        else if(this.name.compareTo(comp.name)>0) return 1;

        return 0;
    }

}
