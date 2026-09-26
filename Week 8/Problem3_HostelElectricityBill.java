import java.util.Scanner;

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class Problem3_HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Room[] rooms = new Room[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            types[i] = type;

            switch (type) {
                case "SINGLE":
                    rooms[i] = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    rooms[i] = new AcRoom(units);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            System.out.printf("%s: %.2f%n", types[i], bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}