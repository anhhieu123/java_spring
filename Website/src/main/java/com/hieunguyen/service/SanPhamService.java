package com.hieunguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunguyen.dao.SanPhamDAO;
import com.hieunguyen.daoimp.SanPhamImp;
import com.hieunguyen.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp
{
	@Autowired
	SanPhamDAO sanphamDAO;
	@Override
	public List<SanPham> LaySanPham(int spbd) {
		// TODO Auto-generated method stub
		
		return sanphamDAO.LaySanPham(spbd);
	}
	@Override
	public SanPham getSPTheoMaSP(int masanpham) {
		// TODO Auto-generated method stub	
		return sanphamDAO.getSPTheoMaSP(masanpham);
	}


}
