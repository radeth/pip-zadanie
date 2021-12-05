package com.company.utils;


import java.util.ArrayList;
import java.util.List;

public class AllowedProducts {

    static final List<Product> allowedProducts = new ArrayList<>() {{
        add(new Product("Fish",2.0));
        add(new Product("Sausages ",5.0));
        add(new Product("Frozen pizza",-30.0));
        add(new Product("Bananas ",13.3));
    }};

    public static List<Product> getAllowedProducts(){
        return allowedProducts;
    }
}
