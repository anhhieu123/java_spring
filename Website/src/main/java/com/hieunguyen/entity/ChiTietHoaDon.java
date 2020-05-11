package com.hieunguyen.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity(name = "chitiethoadon")
public class ChiTietHoaDon {
	@EmbeddedId
	ChiTietHoaDonid chiTietHoaDonid;

	int soluong;
	String giatien;
	
	public ChiTietHoaDonid getChiTietHoaDonid() {
		return chiTietHoaDonid;
	}
	public void setChiTietHoaDonid(ChiTietHoaDonid chiTietHoaDonid) {
		this.chiTietHoaDonid = chiTietHoaDonid;
	}

	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

}
