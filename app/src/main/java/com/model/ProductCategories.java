package com.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ashish on 20-09-2018.
 */

public class ProductCategories implements Serializable {

    public int id;
    public String name;
    public ArrayList<SubCategories> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SubCategories> getProductList() {
        return products;
    }

    public void setProductList(ArrayList<SubCategories> products) {
        this.products = products;
    }
}
