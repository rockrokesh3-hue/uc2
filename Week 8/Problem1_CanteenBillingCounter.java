import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double finalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super(amount);
    }

    double finalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super(amount);
    }

    double finalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super(amount);
    }

    double finalAmount() {
        return amount + 10;
    }
}

public class Problem1_CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Customer[] customers = new Customer[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            types[i] = type;

            switch (type) {
                case "STUDENT":
                    customers[i] = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    customers[i] = new StaffCustomer(amount);
                    break;
                case "GUEST":
                    customers[i] = new GuestCustomer(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown customer type: " + type);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double finalAmount = customers[i].finalAmount();
            System.out.printf("%s: %.2f%n", types[i], finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}