package class_problems;

public class PiggyBank {
    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        savings = savings + amount;
    }

    public void withdraw(double amount) {
        if (amount <= savings) {
            savings = savings - amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        System.out.println("Initial Savings: " + pb.getSavings());

        pb.deposit(100);
        System.out.println("After Deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After Withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Final Savings: " + pb.getSavings());
    }
}