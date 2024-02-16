package lnt;

import java.util.Scanner;

public class Motorcycle extends Vehicle {
    private int wheels;
    private String motorcycleType;
    private int helmet;

    public Motorcycle(String brand, String name, String licensePlate, int topSpeed, int gasCapacity, int wheels, String motorcycleType, int helmet) {
        super(brand, name, licensePlate, topSpeed, gasCapacity);
        this.wheels = wheels;
        this.motorcycleType = motorcycleType;
        this.helmet = helmet;
    }

    @Override
    String getType() {
        return "Motorcycle";
    }

    @Override
    void displaySpecial() {
    	System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("License plate: " + licensePlate);
        System.out.println("Type: " + motorcycleType);
        System.out.println("Gas capacity: " + gasCapacity);
        System.out.println("Top speed: " + topSpeed);
        System.out.println("Wheel(s): " + wheels);
        System.out.println("Helm: " + helmet);
        System.out.printf("%s is standing!\n", name);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input price for the helmet: ");
        int helmetPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Price: " + helmetPrice);
        
    }
}