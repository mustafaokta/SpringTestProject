package com.proje.update;


public class Uygulama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personel personel1=new Personel(20, "w", "casillas", 1988, "1905"); //kayýtlý olan veri yaz buraya þuan öyle
		personel1.setDogumYili(1996);
		DBProcesses.updatePersonel(personel1);
		
	}

}
