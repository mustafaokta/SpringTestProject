package com.proje.insert3;

public class Personel {

	private int personelId;
	private String adi;
	private String soyadi;
	private int dogumYili;
	private String personelNumarasi;
	
	
	public Personel() {}

	public Personel(int personelId, String adi, String soyadi, int dogumYili, String personelNumarasi) {
		
		this.personelId = personelId;
		this.adi = adi;
		this.soyadi = soyadi;
		this.dogumYili = dogumYili;
		this.personelNumarasi = personelNumarasi;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public int getDogumYili() {
		return dogumYili;
	}

	public void setDogumYili(int dogumYili) {
		this.dogumYili = dogumYili;
	}

	public String getPersonelNumarasi() {
		return personelNumarasi;
	}

	public void setPersonelNumarasi(String personelNumarasi) {
		this.personelNumarasi = personelNumarasi;
	}

	@Override
	public String toString() {
		return "Personel [personelId=" + personelId + ", adi=" + adi + ", soyadi=" + soyadi + ", dogumYili=" + dogumYili
				+ ", personelNumarasi=" + personelNumarasi + "]";
	}
	
	
	
}
