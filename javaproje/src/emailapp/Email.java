package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String department;
	private int mailboxcapacity;
	private String alternativeemail;
	private int defaultpasswordlength = 8;
	private String companysuffix = "glamping.com";
	
	
	//constructors for receive first and last name
	public Email(String firstName, String lastName){
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created : " + this.firstName + " "+ this.lastName);
		
		
		//Call a method askig for department return department
		this.department=setDepartment();
		System.out.println("Department: "+this.department);
		
		
		//Call a method that return generated password
		this.password=randomPassword(this.defaultpasswordlength);
		System.out.println("Þifreniz: " + this.password);
		
		//Combine them for email
		email=firstName.toLowerCase()+"."+lastName.toLowerCase() +"@"+department+companysuffix;
		System.out.println("Your email adres is :"+ email);
	}
	
	
	//Ask for the departmant
	private String setDepartment() {
		System.out.println("Enter the Department\n1 for sale\n2 for Devolopment\n3 for Accounting\n0 for none");
		Scanner in=new Scanner(System.in);
		int depChoice=in.nextInt();
		if (depChoice==1) {return "sale";}
		else if(depChoice==2) {return "dev";}
		else if(depChoice==3) {return "acct";}
		else {return "";}
	}
	//Generate a random passwords
	private String randomPassword(int lenght) {
		String passwordharfleri= "ABCDEFGHIJKLMNOPRSTUVYWZX";
		//password harfleri tek tek random ayarlamak için dizi yapýsýndan yararlanýyoruz
		char [] password=new char[lenght];
		for(int i=0; i<lenght; i++) {
			//length adedi kadar random char üretmesi lazým
			int rand=(int)(Math.random()*passwordharfleri.length()); 
			password[i]=passwordharfleri.charAt(rand);			
		}
		return new String(password);
	}
	//Set the mailbox capacity
	public void setmailboxcapacit(int capacity) {
		this.mailboxcapacity=capacity;
		System.out.println("yeni kapasite"+this.mailboxcapacity);
	}
	//Set the alternative email
	public void setalternativeemail(String aemail) {
		this.alternativeemail=aemail;
		System.out.println("Alternatif email"+this.alternativeemail);
	}
	//Change the password
	public void changepassword(String yenisifre) {
		this.password=yenisifre;
		System.out.println("Yeni sifre"+ this.password);
	}
	//get methodlar
	public int getcapacity() {
		return mailboxcapacity;
	}

}
