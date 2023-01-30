package softuni.advanced.definingclasses.lab.bankaccount;

public class BankAccount {
    final private static double DEFAULT_INTEREST = 0.02;
    private static int idCount = 0;
    private int id;
    private double balance;
    private static double interestRate = DEFAULT_INTEREST;

    public BankAccount() {
        idCount++;
        this.id = idCount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    private static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return years * getInterestRate() * this.balance;
    }

    public void deposit(double amount) {
        setBalance(amount);
    }
}
