package com.hieunguyen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.hieunguyen.daoimp.SanPhamImp;
import com.hieunguyen.entity.SanPham;

import org.hibernate.SessionFactory;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)

public class SanPhamDAO implements SanPhamImp{
	
	@Autowired
	 SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<SanPham> LaySanPham(int spbd) {
		// TODO Auto-generated method stub
		
		Session session= sessionFactory.getCurrentSession();
		
		List<SanPham> listSanPham= (List<SanPham>) session.createQuery("from sanpham").setFirstResult(spbd).setMaxResults(20).getResultList();
		return listSanPham;
	}
	
	@Transactional
	public SanPham getSPTheoMaSP(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from sanpham sp where sp.masanpham=" + masanpham;

		SanPham sanPham = (SanPham) session.createQuery(queryString).getSingleResult();

		return sanPham;
	}

	@Transactional
	public List<SanPham> getDSSPTheoDM(int maDM) {
		Session session = this.sessionFactory.getCurrentSession();
		String queryString = "from sanpham sp where sp.danhMucSP.maDM=" + maDM;

		@SuppressWarnings("unchecked")
		List<SanPham> listsptheoDM = (List<SanPham>) session.createQuery(queryString).getResultList();
		return listsptheoDM;
	}
	
}
 