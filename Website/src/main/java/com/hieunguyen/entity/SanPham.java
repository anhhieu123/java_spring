package com.hieunguyen.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name = "sanpham")
public class SanPham {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int masanpham;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "madanhmuc")
	DanhMucSanPham danhmucsanpham;
	
	String tensanpham;
	String giatien;
	String mota;
	String hinhsanpham;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name ="masanpham")
	Set<ChiTietSanPham> chitietsanpham;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ChiTietKhuyenMai",
	joinColumns = {@JoinColumn(name = "masanpham", referencedColumnName = "masanpham")},
	inverseJoinColumns = {@JoinColumn(name="makhuyenmai",referencedColumnName = "makhuyenmai")})
	Set<KhuyenMai> danhsachkhuyenmai;
	
	public Set<KhuyenMai> getDanhsachkhuyenmai() {
		return danhsachkhuyenmai;
	}
	public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}
	public Set<ChiTietSanPham> getChitietsanpham() {
		return chitietsanpham;
	}
	public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}
	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhsanpham() {
		return hinhsanpham;
	}
	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}
	
	
	
	
}
