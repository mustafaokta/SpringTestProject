package com.proje.update;


public class Uygulama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personel personel1=new Personel(20, "w", "casillas", 1988, "1905"); //kay�tl� olan veri yaz buraya �uan �yle
		personel1.setDogumYili(1996);
		DBProcesses.updatePersonel(personel1);
		
	}

}
