package lnt;

abstract class Vehicle {
    protected String brand;
    protected String name;
    protected String licensePlate;
    protected int topSpeed;
    protected int gasCapacity;

    public Vehicle(String brand, String name, String licensePlate, int topSpeed, int gasCapacity) {
        this.brand = brand;
        this.name = name;
        this.licensePlate = licensePlate;
        this.topSpeed = topSpeed;
        this.gasCapacity = gasCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getGasCapacity() {
        return gasCapacity;
    }

    abstract String getType();

    abstract void displaySpecial();
}