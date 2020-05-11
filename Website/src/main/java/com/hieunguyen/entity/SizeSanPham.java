package com.hieunguyen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "sizesanpham")
public class SizeSanPham {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int masize;
	String size;
	
	public int getMasize() {
		return masize;
	}
	public void setMasize(int masize) {
		this.masize = masize;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
