package softuni.advanced.definingclasses.lab.bankaccount;

import java.util.*;

public class Main {
    final private static String COMMAND_END = "End";
    final private static String COMMAND_CREATE = "Create";
    final private static String COMMAND_DEPOSIT = "Deposit";
    final private static String COMMAND_SET_INTEREST = "SetInterest";
    final private static String COMMAND_GET_INTEREST = "GetInterest";
    private static Map<Integer, BankAccount> accountsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();

            if (command.equals(COMMAND_END)) {
                break;
            }

            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case COMMAND_CREATE:
                    createNewAccount();
                    break;
                case COMMAND_DEPOSIT:
                    int accountID = Integer.parseInt(commandArr[1]);
                    double amountToDeposit = Double.parseDouble(commandArr[2]);
                    depositIntoAccount(accountID, amountToDeposit);
                    break;
                case COMMAND_SET_INTEREST:
                    double interestToSet = Double.parseDouble(commandArr[1]);
                    setGlobalInterestBank(interestToSet);
                    break;
                case COMMAND_GET_INTEREST:
                    int accountIDToCalculate = Integer.parseInt(commandArr[1]);
                    int yearsToCalculate = Integer.parseInt(commandArr[2]);
                    getInterestOfAccount(accountIDToCalculate, yearsToCalculate);
                    break;
            }
        }
    }

    private static void createNewAccount() {
        BankAccount account = new BankAccount();
        accountsMap.put(account.getId(), account);
        System.out.printf("Account ID%d created%n", account.getId());
    }

    private static void depositIntoAccount(int id, double amountToDeposit) {
        if (!accountsMap.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        accountsMap.get(id).deposit(amountToDeposit);
        System.out.printf("Deposited %.0f to ID%d%n", amountToDeposit, id);
    }

    private static void setGlobalInterestBank(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void getInterestOfAccount(int id, int years) {
        if (!accountsMap.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        System.out.printf("%.2f%n", accountsMap.get(id).getInterest(years));
    }
}
