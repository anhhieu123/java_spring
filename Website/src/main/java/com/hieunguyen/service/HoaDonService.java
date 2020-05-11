package com.hieunguyen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunguyen.dao.HoaDonDAO;
import com.hieunguyen.daoimp.HoaDonImp;
import com.hieunguyen.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {
	
	@Autowired
	HoaDonDAO hoaDonDAO;

	public int ThemHoaDon(HoaDon hoaDon) {
		
		return hoaDonDAO.ThemHoaDon(hoaDon);
	}
	
	

}