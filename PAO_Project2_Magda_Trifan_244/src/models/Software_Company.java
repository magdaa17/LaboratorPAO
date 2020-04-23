package models;

import models.departaments.HR_Department;
import models.departaments.IT_Department;
import models.departaments.Sales_Department;

public class Software_Company extends Company{

    int aplications;

    public Software_Company(String comp_name,Boss boss, HR_Department hr, IT_Department it, Sales_Department sales, int aplications) {
        super(comp_name,boss, hr, it, sales);
        this.aplications = aplications;
    }

    public int getAplications() {
        return aplications;
    }

    public void setAplications(int aplicatii) {
        this.aplications = aplications;
    }
}
