package com.jdbc.batchinsert;

import java.util.ArrayList;
import java.util.List;


public class Uygulama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personel personel1=new Personel(20, "Fer", "Muslera", 1988, "1905");
		Personel personel2=new Personel(21, "Fero", "Muslera", 1988, "1905");
		Personel personel3=new Personel(22, "Fnando", "Muslera", 1988, "1905");
		Personel personel4=new Personel(23, "Fnando", "Muslera", 1988, "1905");
		Personel personel5=new Personel(24, "nando", "Muslera", 1988, "1905");
		List<Personel>personels=new ArrayList<>();
		personels.add(personel1);
		personels.add(personel2);
		personels.add(personel3);
		personels.add(personel4);
		personels.add(personel5);
		DBProcesses.savePersonelList(personels);
		
	}

}
