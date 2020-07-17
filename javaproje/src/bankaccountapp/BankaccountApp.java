package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankaccountApp {

	public static void main(String[] args) {
		List<Account> accounts= new LinkedList<Account>();
	String file = "C:\\Users\\musta\\Desktop\\java bank acount project\\NewBankAccounts.csv" ;
		/* Checking chkacc1 = new Checking("Mustafa OKTA", "123456789", 1500);
		Savings savacc1 = new Savings("Ahmet OKTA", "987654321", 2500);
		chkacc1.showinfo();
		System.out.println("*******************************************************");
		savacc1.showinfo();
		//savacc1.deposit(5000);
		//savacc1.withdraw(200);
		//savacc1.transfer("EÞÝME", 3000);
		savacc1.compound();
		*/
		
		// Read a CSV data and then create new accounts based on that data
		List<String[]> newaccountHolders = utilities.CSV.read(file);
		for(String[] accountholder : newaccountHolders) {
		String name=accountholder[0];
	    String sSn = accountholder[1];
		String accounttype = accountholder[2];
		double initdeposit =Double.parseDouble(accountholder[3]); //string veriyi double a çevirdi
			//System.out.println("Name : "+ name+ " sSn : " + sSn+ " Accounttype : "+ accounttype+ " initdeposit : "+ initdeposit);
			if(accounttype.equals("Savings")) {
			//	System.out.println("OPEN A SAVING ACCOUNT");
				accounts.add(new Savings(name,sSn,initdeposit));
				
			}
			else if (accounttype.equals("Checking")) {
				//System.out.println("OPEN A CHECKING ACCOUNT");
				accounts.add(new Checking(name,sSn,initdeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//accounts.get(5).showinfo();
	/*	for(Account acc : accounts) {
			System.out.println("****************************************");
			acc.showinfo();
		}*/
		accounts.get((int)Math.random()*accounts.size()).deposit(1000); //random birine para yatýrma
	}//args

}
