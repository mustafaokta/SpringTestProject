package bankaccountapp;

public class Savings extends Account {
	//Properties
	private int safetydepositboxid;
	private int safetydepositboxkey;
	
	
	//Constractors
	Savings (String name, String sSn, double initdeposit) {
		super(name, sSn, initdeposit);
		//System.out.println("  -New Saving Account- ");
		accountnumber=2+accountnumber;
		//System.out.println("Save code 1 added "+ accountnumber);
		safetydepositbox();
	}
	
	//Methods
	public void setRate() {
		//System.out.println("Implement rate for Saving...");
		rate=getbaserate()-.25;
	}
	private void safetydepositbox() {
		do {
		safetydepositboxid = (int)(Math.random() * Math.pow(10, 3));
		}
		while(safetydepositboxid<100);
		
		
		do {
		safetydepositboxkey = (int)(Math.random() * Math.pow(10, 4));
		} while (safetydepositboxkey<1000);
	}
	
	public void showinfo() {
		super.showinfo();
		System.out.println("ACCOUNT TYPE IS :  SAVE");
		System.out.println("Saving account features" + 
				"\n Safetydepositboxid is : "+ safetydepositboxid+
				"\n Safetydepositboxkey is : " + safetydepositboxkey);
	}
	
}
