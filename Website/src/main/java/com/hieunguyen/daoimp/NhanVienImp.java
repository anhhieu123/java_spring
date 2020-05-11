package com.hieunguyen.daoimp;

import com.hieunguyen.entity.NhanVien;

public interface NhanVienImp {
	boolean KiemTraDN(String email, String matkhau);
	boolean ThemNhanVien(NhanVien nhanvien);
}
