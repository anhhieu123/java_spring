package com.hieunguyen.daoimp;

import com.hieunguyen.entity.SanPham;
import java.util.List;

public interface SanPhamImp {
	List<SanPham> LaySanPham(int spbd);
	SanPham getSPTheoMaSP(int masanpham);
}
