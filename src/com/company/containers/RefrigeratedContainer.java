package com.company.containers;

import com.company.utils.Product;

public class RefrigeratedContainer extends Container{
    private Product product;
    private final Double temperature;

    public RefrigeratedContainer(Product product) {
        super();
        this.product = product;
        this.temperature = product.getTemperature();
        setType("Refrigerated");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTemperature() {
        return temperature;
    }
}
