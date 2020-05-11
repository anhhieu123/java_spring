package com.hieunguyen.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="danhmucsanpham")

public class DanhMucSanPham {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int madanhmuc;
	String tendanhmuc;
	String hinhdanhmuc;
	
	@OneToMany(cascade = CascadeType.ALL)
	Set<SanPham> danhsachSanPhams;
	
	
	public Set<SanPham> getDanhsachSanPhams() {
		return danhsachSanPhams;
	}
	public void setDanhsachSanPhams(Set<SanPham> danhsachSanPhams) {
		this.danhsachSanPhams = danhsachSanPhams;
	}
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public String getHinhdanhmuc() {
		return hinhdanhmuc;
	}
	public void setHinhdanhmuc(String hinhdanhmuc) {
		this.hinhdanhmuc = hinhdanhmuc;
	}
	
}
