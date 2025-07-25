package AtmMachine;
import java.math.BigInteger;
import java.util.*;

class ATM{
	private String name;
	private BigInteger acNumber;
	private int AcBalance;
	private int withDrawlamount;
	private int password;
	ATM(String name,BigInteger acNumber,int AcBalance,int withDrwalamount, int password){
		this.name=name;
		this.acNumber = acNumber;
		this.AcBalance = AcBalance;
		this.withDrawlamount=withDrwalamount;
		this.password=password;
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
	public void setName(String name) {
		this.name = name;
	}
	public int getAcBalance() {
		return AcBalance;
	}
	public void setAcBalance(int acBalance) {
		AcBalance = acBalance;
	}
	
	public int getWithDrawlamount() {
		return withDrawlamount;
	}
	public void setWithDrawlamount(int withDrawlamount) {
		this.withDrawlamount = withDrawlamount;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
}
class checkPassword{
	public boolean isValidate(int password,ATM user) {
		return password==user.getPassword();
	}
}
class withdrawl{
	public void withdraw(int amount, ATM user) {
		if (user.getAcBalance() >= amount) {
			user.setAcBalance(user.getAcBalance() - amount);
			System.out.println("Withdrawal Successful.");
			System.out.println("Remaining Balance: " + user.getAcBalance());
		} else {
			System.out.println("Insufficient Balance.");
		}
	}
}
class balanceEnquiry{
	public int totalBalance(int newBalance) {
		return newBalance;
	}
}

class depositMoney{
	public void deposit(int amount, ATM user) {
		user.setAcBalance(user.getAcBalance() + amount);
		System.out.println(" Deposit Successful.");
		System.out.println(" Total Balance: " + user.getAcBalance());
	}
}
class exit{
	public void display2() {
		System.out.println("Thank you for using the ATM. Goodbye!");
	}
}
public class AtmMachineLogic {

	public static void main(String[] args) {
		   ATM user1 = new ATM("Souvik Das", new BigInteger("38696733910"),22796, 0, 2508);
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter Your Password: ");
	        int inputPassword = sc.nextInt();

	        checkPassword p1 = new checkPassword();

	        if (p1.isValidate(inputPassword, user1)) {
	            System.out.println("\n Welcome, " + user1.getName() + "!");
	            System.out.println("1. Balance Enquiry\n2. Withdraw Money\n3. Deposit Money\n4. Exit");
	            System.out.print("Select an Option: ");
	            int choice = sc.nextInt();
	            
	            if (choice == 1) {
	            	System.out.println("Your Balance: " + user1.getAcBalance());

	            } else if (choice == 2) {
	            	System.out.print("Enter amount to withdraw: ");
	            	int amount = sc.nextInt();
	            	withdrawl wd = new withdrawl();
	            	wd.withdraw(amount, user1);

	            } else if (choice == 3) {
	            	System.out.print("Enter amount to deposit: ");
	            	int amount = sc.nextInt();
	            	depositMoney dm = new depositMoney();
	            	dm.deposit(amount, user1);;

	            } else if (choice == 4) {
	            	exit e = new exit();
	            	e.display2();  
	            }
	        }else {
	        	System.out.println("Incorrect Password.");
	        }
		
	}

}
