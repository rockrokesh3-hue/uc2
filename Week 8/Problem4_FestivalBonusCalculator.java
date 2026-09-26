import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return 2000.0;
    }
}

public class Problem4_FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees[i] = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employees[i] = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employees[i] = new Intern(name, salary);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown employee type: " + type);
            }
        }

        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            System.out.printf("%s: %.2f%n", employee.name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}