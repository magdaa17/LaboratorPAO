package models;

import models.departaments.HR_Department;
import models.departaments.IT_Department;
import models.departaments.Sales_Department;


public class Hardware_Company extends Company {

    int produse;


    public Hardware_Company(String comp_name,Boss boss, HR_Department hr, IT_Department it, Sales_Department sales, int produse) {
        super(comp_name,boss, hr, it, sales);
        this.produse = produse;
    }

    public int getProduse() {
        return produse;
    }

    public void setProduse(int produse) {
        this.produse = produse;
    }
}
