package com.hieunguyen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hieunguyen.entity.GioHang;
import com.hieunguyen.service.NhanVienService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user","giohang"})

public class ApiController {
	@Autowired
	NhanVienService nhanVienService;

	@GetMapping("KiemTraDN")
	@ResponseBody
	public String KiemTraDN(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {

		boolean kt = nhanVienService.KiemTraDN(email, matkhau);

		modelMap.addAttribute("user", email);

		return "" + kt;
	}
	
	@GetMapping("AddGioHang")
	@ResponseBody
	private String ThemGioHang(@RequestParam int masp, @RequestParam int masize, @RequestParam int mamau,
			@RequestParam int soluong, @RequestParam String tensize, @RequestParam String tensp,
			@RequestParam String giatien, @RequestParam String tenmau,@RequestParam int machitiet, HttpSession httpSession) {

		if (null == httpSession.getAttribute("listGioHang")) {
			List<GioHang> listGioHangs = new ArrayList<GioHang>();
			GioHang gioHang = new GioHang();
			gioHang.setMasp(masp);
			gioHang.setMasize(masize);
			gioHang.setMamau(mamau);
			gioHang.setSoluong(1);
			gioHang.setTenmau(tenmau);
			gioHang.setTensize(tensize);
			gioHang.setTensp(tensp);
			gioHang.setGiatien(giatien);
			gioHang.setMachitiet(machitiet);
			listGioHangs.add(gioHang);

			httpSession.setAttribute("listGioHang", listGioHangs);
			return listGioHangs.size() + "";

		} else {

			@SuppressWarnings("unchecked")
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("listGioHang");
			int vitri = checkSPTonTai(listGioHang, masp, masize, mamau, httpSession);
			if (vitri == -1) {

				GioHang gioHang = new GioHang();
				gioHang.setMasp(masp);
				gioHang.setMasize(masize);
				gioHang.setMamau(mamau);
				gioHang.setSoluong(1);
				gioHang.setTenmau(tenmau);
				gioHang.setTensize(tensize);
				gioHang.setTensp(tensp);
				gioHang.setGiatien(giatien);
				gioHang.setMachitiet(machitiet);

				listGioHang.add(gioHang);
			} else {

				int soluongcu = listGioHang.get(vitri).getSoluong();
				listGioHang.get(vitri).setSoluong(soluongcu + 1);
			}

			return listGioHang.size() + "";

		}
		
		
	}
	private int checkSPTonTai(List<GioHang> listGiohang, int masp, int masize, int mamau, HttpSession httpSession) {
		@SuppressWarnings("unchecked")
		List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("listGioHang");
		for (int i = 0; i < listGioHang.size(); i++) {

			if (listGioHang.get(i).getMasp() == masp && listGioHang.get(i).getMasize() == masize
					&& listGioHang.get(i).getMamau() == mamau) {
				return i;
			}
		}

		return -1;
	}

	@GetMapping("GetSoLuongGioHang")
	@ResponseBody
	public String getSoLuongGioHang(HttpSession httpSession) {
		if (null != httpSession.getAttribute("listGioHang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("listGioHang");

			return gioHangs.size() + "";
		}
		return "";
	}

	@GetMapping("updateGioHang")
	@ResponseBody
	public void UpdateGioHang(HttpSession httpSession, @RequestParam int soluong, @RequestParam int masp,
			@RequestParam int masize, @RequestParam int mamau) {
		if (null != httpSession.getAttribute("listGioHang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("listGioHang");
			int vitri = checkSPTonTai(gioHangs, masp, masize, mamau, httpSession);
			gioHangs.get(vitri).setSoluong(soluong);
		}
	}
	
	@GetMapping("XoaGioHang")
	@ResponseBody
	public void XoaGioHang(HttpSession httpSession,@RequestParam int masp,
			@RequestParam int masize, @RequestParam int mamau) {
		if (null != httpSession.getAttribute("listGioHang")) {
			@SuppressWarnings("unchecked")
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("listGioHang");
			int vitri = checkSPTonTai(gioHangs, masp, masize, mamau, httpSession);
			gioHangs.remove(vitri);
		}

	}
	
	
}
