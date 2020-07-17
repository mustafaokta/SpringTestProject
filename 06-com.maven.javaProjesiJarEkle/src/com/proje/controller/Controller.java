package com.proje.controller;

import com.proje.database.Repository;

public class Controller {
public static void main(String[] args) {
	Repository repository=new Repository();
	repository.delete("Bilgi Siliyor");
	repository.insert("Yeni Bilgi ekliyor");
}
}
