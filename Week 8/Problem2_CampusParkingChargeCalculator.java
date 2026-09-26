import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return Math.max(100, hours * 50.0);
    }
}

public class Problem2_CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vehicle[] vehicles = new Vehicle[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            types[i] = type;

            switch (type) {
                case "BIKE":
                    vehicles[i] = new Bike(hours);
                    break;
                case "CAR":
                    vehicles[i] = new Car(hours);
                    break;
                case "TRUCK":
                    vehicles[i] = new Truck(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double charge = vehicles[i].calculateCharge();
            System.out.printf("%s: %.2f%n", types[i], charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}