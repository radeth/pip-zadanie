package com.company.utils;

import com.company.containers.Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ship implements Cloneable{
    static final Integer maxContainers = 25715 * 5;
    private Double vMax;
    private List<Container> containerList = new ArrayList<>();
    static final Ship shipOne = new Ship();
    static final Ship shipTwo = new Ship();

    public void addContainer(Container container) {
        containerList.add(container);
    }

    public void addContainer(List<Container> containers) {
        containerList.addAll(containers);
    }

    public void removeContainer(Container container) {
        this.containerList.remove(container);
//        containerList.removeIf(s -> s.getId().equals(container.getId()));
    }

    public void removeContainer(List<Container> containers) {
        this.containerList.removeAll(containers);
//        containers.forEach(container -> {
//            containerList.removeIf(s -> s.getId().equals(container.getId()));
//        });
    }

    public void replaceContainer(String id, Container container) {
        Container oldContainer = findContaine(id);
        if (oldContainer != null) {
           this.containerList.remove(oldContainer);
            this.containerList.add(container);
        }
    }

    private Container findContaine(String id) {
        return this.containerList.stream()
                .filter(c -> id.equals(c.getId()))
                .findAny()
                .orElse(null);
    }

    public void relocateContainerToAnotherShip(String id, Ship newShip) {
        Container containerToMove = findContaine(id);
        if (containerToMove != null) {
            this.containerList.remove(containerToMove);
            newShip.addContainer(containerToMove);
        }
    }

    @Override
    public Ship clone() {
        try {
            return (Ship) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static Ship getShipOne() {
        return shipOne;
    }

    public static Ship getShipTwo() {
        return shipTwo;
    }

    public Double getvMax() {
        return vMax;
    }

    public void setvMax(Double vMax) {
        this.vMax = vMax;
    }

    public List<Container> getContainerList() {
        return this.containerList;
    }

    public void setContainerList(List<Container> containerList) {
        this.containerList = containerList;
    }
}
