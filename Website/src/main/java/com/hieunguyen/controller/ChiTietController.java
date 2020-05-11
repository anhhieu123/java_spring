package com.hieunguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hieunguyen.entity.DanhMucSanPham;
import com.hieunguyen.entity.GioHang;
import com.hieunguyen.entity.SanPham;
import com.hieunguyen.service.DanhMucService;
import com.hieunguyen.service.SanPhamService;


@Controller
@RequestMapping("/chitiet/")
@SessionAttributes("listGioHang")
public class ChiTietController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhmucService;
	
	@GetMapping("{masanpham}")
	public String getChiTiet(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession){
		SanPham sanpham =sanPhamService.getSPTheoMaSP(masanpham);
		
		
		if (null != httpSession.getAttribute("listGioHang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs= (List<GioHang>) httpSession.getAttribute("listGioHang");
			modelMap.addAttribute("Giohang",gioHangs.size());
		}
		
		List<DanhMucSanPham> danhmucsanphams=danhmucService.getDanhMucSanPhams();
		modelMap.addAttribute("getsp",sanpham);
		modelMap.addAttribute("dmsp", danhmucsanphams);
		
		
		return "chitiet";
	}
}