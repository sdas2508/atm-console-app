import java.math.BigInteger;
import java.util.*;

class ATMUser {
    private String name;
    private BigInteger acNumber;
    private int acBalance;
    private int withdrawAmount;
    private int password;

    ATMUser(String name, BigInteger acNumber, int acBalance, int withdrawAmount, int password) {
        this.name = name;
        this.acNumber = acNumber;
        this.acBalance = acBalance;
        this.withdrawAmount = withdrawAmount;
        this.password = password;
    }

    public BigInteger getAcNumber() {
        return acNumber;
    }

    public void setAcNumber(BigInteger acNumber) {
        this.acNumber = acNumber;
    }

    public String getName() {
        return name;
    }

    public int getAcBalance() {
        return acBalance;
    }

    public void setAcBalance(int acBalance) {
        this.acBalance = acBalance;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}

class CheckPassword {
    public boolean isValidate(int password, ATMUser user) {
        return password == user.getPassword();
    }
}

class Withdraw {
    public void withdraw(int amount, ATMUser user) {
        if (user.getAcBalance() >= amount) {
            user.setAcBalance(user.getAcBalance() - amount);
            System.out.println("Withdrawal Successful.");
            System.out.println("Remaining Balance: " + user.getAcBalance());
        } else {
            System.out.println("Insufficient Balance.");
        }
    }
}

class DepositMoney {
    public void deposit(int amount, ATMUser user) {
        user.setAcBalance(user.getAcBalance() + amount);
        System.out.println("Deposit Successful.");
        System.out.println("Total Balance: " + user.getAcBalance());
    }
}

class Exit {
    public void display2() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}

public class AtmMachineLogic {
    public static void main(String[] args) {
        ATMUser user1 = new ATMUser("Souvik Das", new BigInteger("38696733910"), 22796, 0, 2508);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Password: ");
        int inputPassword = sc.nextInt();

        CheckPassword p1 = new CheckPassword();

        if (p1.isValidate(inputPassword, user1)) {
            System.out.println("\nWelcome, " + user1.getName() + "!");
            System.out.println("1. Balance Enquiry\n2. Withdraw Money\n3. Deposit Money\n4. Exit");
            System.out.print("Select an Option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Your Balance: " + user1.getAcBalance());
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                int amount = sc.nextInt();
                Withdraw wd = new Withdraw();
                wd.withdraw(amount, user1);
            } else if (choice == 3) {
                System.out.print("Enter amount to deposit: ");
                int amount = sc.nextInt();
                DepositMoney dm = new DepositMoney();
                dm.deposit(amount, user1);
            } else if (choice == 4) {
                Exit e = new Exit();
                e.display2();
            } else {
                System.out.println("Invalid Option.");
            }
        } else {
            System.out.println("Incorrect Password.");
        }

        sc.close();
    }
}
