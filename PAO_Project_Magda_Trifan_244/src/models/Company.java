package models;

import models.departments.HR_Department;
import models.departments.IT_Department;
import models.departments.Sales_Department;

public class Company {

    Boss boss;
    HR_Department hr;
    IT_Department it;
    Sales_Department sales;

    public Company(Boss boss, HR_Department hr, IT_Department it, Sales_Department sales) {
        this.boss = boss;
        this.hr = hr;
        this.it = it;
        this.sales = sales;
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
}
