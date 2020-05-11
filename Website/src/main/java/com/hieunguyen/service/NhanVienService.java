package com.hieunguyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunguyen.dao.NhanVienDAO;
import com.hieunguyen.daoimp.NhanVienImp;
import com.hieunguyen.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp {
	@Autowired
	NhanVienDAO nhanvienDAO;

	@Override
	public boolean KiemTraDN(String email, String matkhau) {
		boolean kt = nhanvienDAO.KiemTraDN(email, matkhau);
		return kt;
	}

	@Override
	public boolean ThemNhanVien(NhanVien nhanvien) {
		// TODO Auto-generated method stub
		boolean ktthem= nhanvienDAO.ThemNhanVien(nhanvien);
		return ktthem;
	}
	


}
