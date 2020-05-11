package com.hieunguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunguyen.dao.DanhMucDAO;
import com.hieunguyen.daoimp.DanhMucImp;
import com.hieunguyen.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp {

	@Autowired
	DanhMucDAO danhMucSPDAO;
	
	public List<DanhMucSanPham> getDanhMucSanPhams() {
		 return danhMucSPDAO.getDMSP();
		
	}

}