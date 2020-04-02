package models;

import models.departments.HR_Department;
import models.departments.IT_Department;
import models.departments.Sales_Department;

public class Software_Company extends Company{

    int aplications;

    public Software_Company(Boss boss, HR_Department hr, IT_Department it, Sales_Department sales, int aplications) {
        super(boss, hr, it, sales);
        this.aplications = aplications;
    }

    public int getAplications() {
        return aplications;
    }

    public void setAplications(int aplications) {
        this.aplications = aplications;
    }
}
