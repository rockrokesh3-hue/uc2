import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class Problem5_StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    plans[i] = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plans[i] = new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    plans[i] = new PremiumPlan(name, startDate);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown plan type: " + type);
            }
        }

        for (SubscriptionPlan plan : plans) {
            System.out.println(plan.name + ": " + plan.renewalDate());
        }
        sc.close();
    }
}