package com.proje.insert4;


public class Uygulama4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personel personel1=new Personel(111, "Fernando", "Muslera", 1988, "1905");
		DBProcesses.savePersonel(personel1);
		
		
		
	}
	
	
	
	

}
