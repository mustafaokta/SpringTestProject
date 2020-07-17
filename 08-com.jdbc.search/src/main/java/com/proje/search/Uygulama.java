package com.proje.search;

import java.util.List;

public class Uygulama {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	List<Personel>personels=DBProcesses.findPersonels();
	personels.forEach(System.out::println);
	
	
	}

}
