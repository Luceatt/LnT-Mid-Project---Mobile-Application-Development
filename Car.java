package lnt;

public class Car extends Vehicle {
    private int wheels;
    private String carType;
    private int entertainmentSystem;

    public Car(String brand, String name, String licensePlate, int topSpeed, int gasCapacity, int wheels, String carType, int entertainmentSystem) {
        super(brand, name, licensePlate, topSpeed, gasCapacity);
        this.wheels = wheels;
        this.carType = carType;
        this.entertainmentSystem = entertainmentSystem;
    }

    @Override
    String getType() {
        return "Car";
    }

    @Override
    void displaySpecial() {
    	System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("License plate: " + licensePlate);
        System.out.println("Type: " + carType);
        System.out.println("Gas capacity: " + gasCapacity);
        System.out.println("Top speed: " + topSpeed);
        System.out.println("Wheel(s): " + wheels);
        System.out.println("Entertainment System: " + entertainmentSystem);
        System.out.println("Turning on entertainment system…");
        if (carType.equals("Supercar")) {
            System.out.println("Boosting!");
        }
    }
}