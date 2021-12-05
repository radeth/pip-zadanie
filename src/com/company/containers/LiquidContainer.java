package com.company.containers;

import com.company.exceptions.OverfillException;
import com.company.interfaces.ExplosiveInterfaces;

public class LiquidContainer extends Container implements ExplosiveInterfaces {
    private Boolean hazardous;

    public LiquidContainer(Boolean hazardous) {
        super();
        this.hazardous = hazardous;
        setType("Liquid");
    }

    @Override
    public void expolde(String id) {
        System.out.println("Liquid container id: " + id + "exploded");
    }

    @Override
    public void fill(Double mass) throws OverfillException {
        double maxMass = this.getHazardous() ? this.getMaxCargoMass() * 0.5 : this.getMaxCargoMass() * 0.9;
        if(mass>maxMass){
            this.expolde(this.getId());
            throw new OverfillException(this.getId());
        }else{
            this.setCargoMass(mass);
        }
    }

    public Boolean getHazardous() {
        return hazardous;
    }

    public void setHazardous(Boolean hazardous) {
        this.hazardous = hazardous;
    }
}
