package models;

import models.departments.HR_Department;
import models.departments.IT_Department;
import models.departments.Sales_Department;

public class Hardware_Company extends Company {

    int products;

    public Hardware_Company(Boss boss, HR_Department hr, IT_Department it, Sales_Department sales, int products) {
        super(boss, hr, it, sales);
        this.products = products;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}
