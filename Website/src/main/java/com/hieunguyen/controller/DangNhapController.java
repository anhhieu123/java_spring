package com.hieunguyen.controller;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hieunguyen.entity.NhanVien;
import com.hieunguyen.service.NhanVienService;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

@Controller
@RequestMapping("dangnhap/")
@SessionAttributes("email")
public class DangNhapController {

	@Autowired
	NhanVienService nhanVienService;
	@GetMapping
	public String getDangNhap() {
		return "dangnhap";
	}

	@PostMapping
	public String signIn( @RequestParam String email, @RequestParam String matkhau,
			@RequestParam String nhaplaimatkhau,ModelMap modelMap) {

		boolean ktemail= validate(email);
		if (ktemail) {
			if (matkhau.equals(nhaplaimatkhau)) {
				NhanVien nv= new NhanVien();
				nv.setEmail(email);
				nv.setTendangnhap(email);
				nv.setMatkhau(matkhau);
					
				
				nhanVienService.ThemNhanVien(nv);
			}
			
			else {
				modelMap.addAttribute("result", "Password không trùng nhau !");
			}
		}
		else {
			modelMap.addAttribute("result", "Email không đúng định dạng !");
			
		}
		return "dangnhap";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

}