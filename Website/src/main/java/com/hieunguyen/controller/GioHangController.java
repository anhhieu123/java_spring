package com.hieunguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hieunguyen.entity.ChiTietHoaDon;
import com.hieunguyen.entity.ChiTietHoaDonid;
import com.hieunguyen.entity.GioHang;
import com.hieunguyen.entity.HoaDon;
import com.hieunguyen.service.HoaDonService;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
	@Autowired 
	HoaDonService hoaDonService;
	
	@GetMapping
	public String DefaultGioHang(HttpSession httpSession, ModelMap modelMap) {
		if (null != httpSession.getAttribute("listGioHang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs= (List<GioHang>) httpSession.getAttribute("listGioHang");
			modelMap.addAttribute("soluongSP",gioHangs.size());
			modelMap.addAttribute("giohangs", gioHangs);	
		}
		return "giohang";	
	}
	
	@PostMapping
	public String ThemHoaDon( @RequestParam String tenKH, @RequestParam String soDT,@RequestParam String diaChi,
			@RequestParam String hinhthucgiao,@RequestParam String ghichu, HttpSession httpSession) {
		
		if (null != httpSession.getAttribute("listGioHang")) {
			
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs= (List<GioHang>) httpSession.getAttribute("listGioHang");
			
			HoaDon hoaDon= new HoaDon();
			hoaDon.setTenkhachhang(tenKH);
			hoaDon.setSdt(soDT);
			hoaDon.setDiachigiaohang(diaChi);
			hoaDon.setGhichu(ghichu);
			hoaDon.setHinhthucgiaohang(hinhthucgiao);		
			
			
			int idhoadon= hoaDonService.ThemHoaDon(hoaDon);
			if (idhoadon > 0) {
				
				for (GioHang gioHang : gioHangs) {
					
					ChiTietHoaDonid chiTietHDId= new ChiTietHoaDonid();
					chiTietHDId.setMachitietsanpham(gioHang.getMachitiet());
					chiTietHDId.setMahoadon(hoaDon.getMahoadon());
					
					ChiTietHoaDon chiTietHD= new ChiTietHoaDon();
					chiTietHD.setChiTietHoaDonid(chiTietHDId);
					chiTietHD.setGiatien(gioHang.getGiatien().toString());
					chiTietHD.setSoluong(gioHang.getSoluong());					
				}			
			}
			else {
				System.out.println("Them That Bai !");	
			}
		}
		return "giohang";
	}
}
