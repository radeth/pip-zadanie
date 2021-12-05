package com.company.containers;

import com.company.exceptions.OverfillException;
import com.company.interfaces.ExplosiveInterfaces;

import java.util.Random;

public class GasContainer extends Container implements ExplosiveInterfaces {
    private Double atmosphere;

    public GasContainer() {
        super();
        setType("Gas");
        setAtmosphere(Double.valueOf(generateRandomNumber(0,100)));
    }



    @Override
    public void expolde(String id) {
        System.out.println("Gas container id: " + id + "exploded");
    }

    public Double getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Double atmosphere) {
        this.atmosphere = atmosphere;
    }

    @Override
    public void empty() {
        this.setCargoMass(0.05 * this.getCargoMass());
    }

    @Override
    public void fill(Double mass) throws OverfillException {
        try {
            super.fill(mass);
        } catch (OverfillException overfillException) {
            this.expolde(this.getId());
        }
    }
    private Integer generateRandomNumber(Integer from, Integer to) {
        Random r = new Random();
        return r.nextInt(to - from) + from;
    }
}
