package com.hieunguyen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.hieunguyen.daoimp.NhanVienImp;
import com.hieunguyen.entity.NhanVien;

import javax.transaction.Transactional;

import  org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)

public class NhanVienDAO implements NhanVienImp {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean KiemTraDN(String email, String matkhau) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		try {
			NhanVien nhanvien = (NhanVien) session.createQuery("from nhanvien where email ='"+email+"' and matkhau = '"+matkhau+ "'").getSingleResult();
			if (nhanvien != null) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}


	}

	@Override
	@Transactional
	public boolean ThemNhanVien(NhanVien nhanvien) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		int manhanvien= (Integer) session.save(nhanvien);
		System.out.print(manhanvien);
		if (manhanvien > 0) {
			return true;
		} else {
			return false;
		}
	}
	

}
