package com.company.containers;

import com.company.exceptions.OverfillException;
import com.company.interfaces.ContainerInterface;

import java.util.Random;

public class Container implements ContainerInterface {

    Container() {
        this.id = generateId(0,25715);
        this.maxCargoMass = 20185;
        this.depth = 60600;
        this.height = 25900;
        this.width = 24300;
        this.cargoMass = Double.valueOf(generateRandomNumber(0,20185));
        System.out.println("Container has been initialized with id: " + this.getId());
    }

    @Override
    public void empty() {
        this.setCargoMass(0.0);
    }

    @Override
    public void fill(Double mass) throws OverfillException {
        if (this.getCargoMass() + mass > this.getMaxCargoMass()) {
            throw new OverfillException(this.getId());
        } else {
            this.setCargoMass(mass);
        }
    }

    private String generateId(Integer from, Integer to) {
        return  String.valueOf(generateRandomNumber(from, to));
    }

    private Integer generateRandomNumber(Integer from, Integer to) {
        Random r = new Random();
        return r.nextInt(to - from) + from;
    }

    private final String id;
    private Double cargoMass;
    private Integer height;
    private Integer width;
    private Integer depth;
    private Integer maxCargoMass;
    private String type;
    public String getId() {
        return id;
    }

    public Double getCargoMass() {
        return cargoMass;
    }

    public void setCargoMass(Double cargoMass) {
        this.cargoMass = cargoMass;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getMaxCargoMass() {
        return maxCargoMass;
    }

    public void setMaxCargoMass(Integer maxCargoMass) {
        this.maxCargoMass = maxCargoMass;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
