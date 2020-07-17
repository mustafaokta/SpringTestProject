package bankaccountapp;

public class Checking extends Account {
	//List properities specific to Checking account
	private long debitcardnumber;
	private int debitcardpin;
	String a;
	//Constructors
	Checking(String name, String sSn, double initdeposit){
		super(name, sSn, initdeposit);
		//System.out.println(" -New Checking Account-");
		accountnumber=1+accountnumber;
		//System.out.println("Check code 1 added "+ accountnumber);
		setdebitcard();
	} 
	
	//List any methods spesific to the Checking account
	public void setRate() {
		//System.out.println("Implement rate for Checking...");
		rate=getbaserate()+getbaserate()*.15;
	}
	private void setdebitcard() {
				
	do {
			
			debitcardnumber = (long)(Math.random() * Math.pow(10, 12));
			a=""+debitcardnumber;
			
		}
		while(a.length()<12);
	
		
		do {
			debitcardpin = (int)(Math.random() * Math.pow(10, 4));
			
		} while (debitcardpin<1000);
		
	}
	
	public void showinfo() {
		super.showinfo();
		System.out.println("ACCOUNT TYPE IS :  CHECK");
		System.out.println("Checking account features : ");
		System.out.println("debitcardnumber :  "+ debitcardnumber);
		System.out.println("debitcardpin : " + debitcardpin);
	}

}
