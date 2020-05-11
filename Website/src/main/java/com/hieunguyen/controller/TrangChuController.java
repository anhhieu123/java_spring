package com.hieunguyen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hieunguyen.entity.SanPham;
import com.hieunguyen.service.SanPhamService;


@Controller
@RequestMapping("/")
public class TrangChuController {
	@Autowired
	SanPhamService sanphamService;
	@GetMapping
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		
		List<SanPham> listSanPham = sanphamService.LaySanPham(0);
		modelMap.addAttribute("listSanPham", listSanPham);
		
		return "trangchu";
	}

}
