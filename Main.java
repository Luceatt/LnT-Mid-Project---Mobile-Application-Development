package lnt;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Input");
            System.out.println("2. View");
            System.out.println("0. Exit");
            System.out.print("Choose menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String enterValidation;

            switch (choice) {
                case 1:
                    inputVehicle();
                    scanner.nextLine();
                    
                    System.out.println("ENTER to return");
                    enterValidation = scanner.nextLine();
                    if(enterValidation.isEmpty()) {
                    	cls();
                    	break;
                    }
                case 2:
                    viewVehicles();
                    
                    System.out.println("ENTER to return");
                    enterValidation = scanner.nextLine();
                    if(enterValidation.isEmpty()) {
                    	cls();
                    	break;
                    }
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void inputVehicle() {
        System.out.print("Input type [Car | Motorcycle]: ");
        String type = scanner.nextLine();

        System.out.print("Input brand: ");
        String brand = scanner.nextLine();

        System.out.print("Input name: ");
        String name = scanner.nextLine();

        System.out.print("Input license plate: ");
        String licensePlate = scanner.nextLine();

        System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
        int topSpeed = validateIntRange(scanner.nextInt(), 100, 250);

        System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
        int gasCapacity = validateIntRange(scanner.nextInt(), 30, 60);

        int wheels = 0;
        if (type.equalsIgnoreCase("Car")) {
            System.out.print("Input wheel [4 <= wheel <= 6]: ");
            wheels = validateIntRange(scanner.nextInt(), 4, 6);

            System.out.print("Input type [SUV | Supercar | Minivan]: ");
            String carType = scanner.next();

            System.out.print("Input entertainment system amount [>= 1]: ");
            int entertainmentSystem = validateInt(scanner.nextInt(), 1);

            vehicles.add(new Car(brand, name, licensePlate, topSpeed, gasCapacity, wheels, carType, entertainmentSystem));
        } else if (type.equalsIgnoreCase("Motorcycle")) {
            System.out.print("Input wheel [2 <= wheel <= 3]: ");
            wheels = validateIntRange(scanner.nextInt(), 2, 3);

            System.out.print("Input type [Matic | Manual]: ");
            String motorcycleType = scanner.next();

            System.out.print("Input helm [>= 1]: ");
            int helmet = validateInt(scanner.nextInt(), 1);

            vehicles.add(new Motorcycle(brand, name, licensePlate, topSpeed, gasCapacity, wheels, motorcycleType, helmet));
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    private static int validateIntRange(int input, int min, int max) {
        while (input < min || input > max) {
            System.out.print("Input must be between " + min + " and " + max + ". Re-enter: ");
            input = scanner.nextInt();
        }
        return input;
    }

    private static int validateInt(int input, int min) {
        while (input < min) {
            System.out.print("Input must be at least " + min + ". Re-enter: ");
            input = scanner.nextInt();
        }
        return input;
    }

    private static void viewVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            System.out.println("Vehicle List:");
            System.out.println("|-----|---------------|---------------|");
            System.out.println("|No   |Type           |Name           |");
            System.out.println("|-----|---------------|---------------|");
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);
                System.out.printf("|%-5d|%-15s|%-15s|\n", (i + 1), vehicle.getType(), vehicle.getName());
            }
            System.out.println("|-----|---------------|---------------|");

            System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= vehicles.size()) {
                Vehicle chosenVehicle = vehicles.get(choice - 1);
                System.out.println("\nVehicle Details:");
                chosenVehicle.displaySpecial();
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
    
    public static void cls(){
        for(int i = 0; i < 32; i++){
            System.out.println();
        }
    }
}