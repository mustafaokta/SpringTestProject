package bankaccountapp;

public abstract class Account implements IRate {
	//List commen properties Checking and Saving Accounts
	private String name;
	private String sSn;
	//String acctype;
	private double balance;
	protected String accountnumber;
	protected double rate;
	private static int index=10000;
	
	//Constructors to set base proporties and initialize the account
	
	Account(String name, String sSNumber, double initbalance){
		this.sSn=sSNumber;
		this.name=name;
		balance=initbalance;
		//System.out.print("New Account : ");
		//System.out.print("Name : "+ name + " " + "sSn : " + sSNumber + " " + "initbalance : " + initbalance);
		
		//set account number
		index++;
		this.accountnumber=setaccountnumber();
		//System.out.println("  Account number sonhali : "+ this.accountnumber);
		setRate();
		//System.out.println(getbaserate());
	}
	public void compound() {
		double accruedInterest=balance*(rate/100);
		balance=balance+accruedInterest;
		System.out.println("Your accrued Interest : " + accruedInterest);
		 printbalance(); 
	}
	
	//List commen methods
	public void deposit(double amaunt) {
		balance=balance+amaunt;
		System.out.println("Depositing $ "+ amaunt);
		 printbalance(); 
	}
	public void withdraw(double amaunt) {
		balance=balance-amaunt;
		System.out.println("Withdrawing $ "+ amaunt);
		 printbalance(); 
	}
	public void transfer(String towhere, double amaunt) {
		balance=balance-amaunt;
		System.out.println("Transfering  $ " + amaunt + " to : "+ towhere);
		 printbalance(); 
	}
	public void printbalance() {
		System.out.println("Your current balance is : $  " + balance);
	}
private String setaccountnumber() {
	String last2digitofsSn = sSn.substring(sSn.length()-2, sSn.length());
	int uniquenumber=index;
	int randomnumber = (int) (Math.random() * Math.pow(10, 3));
	return last2digitofsSn+uniquenumber+randomnumber;
}
public void showinfo() {
	System.out.println(
			"NAME : " + name+
			"\nACCOUNT NUMBER : " + accountnumber+
			"\nBALANCE : "+ balance + 
			"\n Rate : " + rate+ "%"
			
			
			);
}
      public  abstract void setRate();
}
