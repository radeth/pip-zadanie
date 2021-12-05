package com.company;

import com.company.containers.Container;
import com.company.containers.GasContainer;
import com.company.containers.LiquidContainer;
import com.company.containers.RefrigeratedContainer;
import com.company.utils.AllowedProducts;
import com.company.utils.Product;
import com.company.utils.Ship;

import java.util.*;
import java.util.List;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        1Create a container ship
        Ship shipOne = Ship.getShipOne();
//        Add containers to created container ship
        int conatinerNumber = getContainerNumber();
        List<Container> containers = generateContainers(conatinerNumber);
        shipOne.addContainer(containers);
//        Create another container ship
        Ship shipTwo = Ship.getShipTwo();
        shipOne.removeContainer(new ArrayList<>());
//        Relocate all containers from first container ship to the second one
        moveAllContainers(shipOne, shipTwo);
//        Empty all containers in second container ship
        for (Container container : shipTwo.getContainerList()) {
            container.empty();
        }
//        Replace first N (the number of containers) containers in second container ship
        int numberContainersToReplace = getContainerNumber();
        while (numberContainersToReplace > conatinerNumber) {
            numberContainersToReplace = getContainerNumber();
        }
        List<Container> containersToReplace = generateContainers(numberContainersToReplace);
        moveFirstContainers(shipTwo, containersToReplace);
//        Remove containers from second container ship
        removeOdd(shipTwo);
//        Print information about all containers in second container ship.
        displayInfo(shipTwo);


    }

    private static void displayInfo(Ship shipTwo) {
        for (Container container : shipTwo.getContainerList()) {
            System.out.println("-------------Id: "+container.getId()+"------------- ");
            System.out.println("Type: " + container.getType());
            switch (container.getType()) {
                case "Liquid" -> {
                    System.out.println("Hazardous: " + ((LiquidContainer) container).getHazardous());
                }
                case "Gas" -> {
                    System.out.println("Atmosphere: " + ((GasContainer) container).getAtmosphere());

                }
                case "Refrigerated" -> {
                    System.out.println("Product: " + ((RefrigeratedContainer) container).getProduct().getName());
                    System.out.println("Temperature: " + ((RefrigeratedContainer) container).getTemperature());
                }
            }
            System.out.println("Current mass: " + container.getCargoMass());
        }
        System.out.println("Total containers on ship" + shipTwo.getContainerList().size());
    }

    private static void removeOdd(Ship shipTwo) {
        int i = 0;
        for (Iterator<Container> it = shipTwo.getContainerList().iterator(); it.hasNext(); ) {
            it.next(); // Add this line in your code
            if (i % 2 != 0) {
                it.remove();
            }
            i++;
        }
    }

    private static void moveFirstContainers(Ship shipTwo, List<Container> containersToReplace) {
        int l = containersToReplace.size() -1;
        for (int i = 0; i < l; i++) {
            shipTwo.getContainerList().set(i, containersToReplace.get(i));
        }
    }

    private static List<Container> generateContainersToReplace(Ship shipOne) {

        return null;
    }

    private static void moveAllContainers(Ship shipOne, Ship shipTwo) {
        int l = shipOne.getContainerList().size();
        for (int i = l; i > 0; i--) {
            shipOne.relocateContainerToAnotherShip(shipOne.getContainerList().get(i - 1).getId(), shipTwo);
        }
    }

    private static List<Container> generateContainers(Integer conatinerNumber) {
        String conatinerType = getContainerType();
//        String conatinerType = "refrigerated";
        List<Container> containers = new ArrayList<>();
//        int conatinerNumber = 50;
        for (int i = 0; i <= conatinerNumber - 1; i++) {
            Container container;
            switch (conatinerType) {
                case "liquid" -> {
                    container = generateLiquidContainer();
                    containers.add(container);
                }
                case "gas" -> {
                    container = generateGasContainer();
                    containers.add(container);
                }
                case "refrigerated" -> {
                    container = generateRefrigeratedContainer();
                    containers.add(container);
                }
            }

        }
        return containers;
    }

    private static RefrigeratedContainer generateRefrigeratedContainer() {
        List<Product> allowedProducts = AllowedProducts.getAllowedProducts();
        Product product = allowedProducts.get(generateRandomNumber(0, allowedProducts.size()));
        return new RefrigeratedContainer(product);
    }

    private static GasContainer generateGasContainer() {
        return new GasContainer();
    }

    private static LiquidContainer generateLiquidContainer() {
        Boolean hazardous = generateRandomNumber(0, 2) != 0;
        return new LiquidContainer(hazardous);
    }

    private static int getContainerNumber() {
        System.out.println("Enter container number");
        String containerNumberInput = scanner.nextLine();
        return Integer.parseInt(containerNumberInput);
    }

    private static String getContainerType() {
        System.out.println("Enter container type (liquid, gas, refrigerated)");
        List<String> allowedContainerTypes = List.of("liquid", "gas", "refrigerated");
        String containerType = scanner.nextLine();
        while (!allowedContainerTypes.contains(containerType)) {
            System.out.println("Conatiner type not allowed");
            containerType = scanner.nextLine();
        }
        return containerType;
    }

    private static Integer generateRandomNumber(Integer from, Integer to) {
        Random r = new Random();
        return r.nextInt(to - from) + from;
    }
}
