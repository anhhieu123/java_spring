package com.hieunguyen.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hieunguyen.daoimp.DanhMucImp;
import com.hieunguyen.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<DanhMucSanPham> getDMSP() {
		
		Session session= sessionFactory.getCurrentSession();
		String query= "from danhmucsanpham";
		  List<DanhMucSanPham> getDanhMucSPs= (List<DanhMucSanPham>) session.createQuery(query).getResultList();
		// TODO Auto-generated method stub
		return getDanhMucSPs;
	}
 
}
