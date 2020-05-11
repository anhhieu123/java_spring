<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>NYC SHOP</title>

</head>
<body>
	<div class="container-fluid" id="header-chitiet" >
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light none_nav">
				<a class="navbar-brand" href="#"><img alt="logo"
					src='<c:url value = "/resources/image/logohn2.png"/>' /></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto navbar-center">
						<li class="active"><a class="nav-link" href="">TRANG CHỦ
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item dropdown open"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Sản Phẩm </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
						<li class="nav-item"><a class="nav-link disabled" href="#">DỊCH
								VỤ</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#">LIÊN
								HỆ</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${name != null }">
								<li><a class="circle glyphicon glyphicon-user" href="../giohang/"><span>${name }</span></a>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="../dangnhap/">Đăng nhập</a></li>
							</c:otherwise>
						</c:choose>
						
						<li><a href="giohang/"><img alt="logo" class="cccc"
							src='<c:url value = "/resources/image/icons8-favorite-cart-32.png"/>' />(${Giohang})</a></li>

					</ul>

				</div>
			</nav>

		
		</div>
	</div>

	<div class="container" id="chitiet_1">
		<div class="row">
			<div class="col-sm-2 col-md-2">

				<h4>Danh Mục</h4>
				<ul style="padding: 5%">
					<c:forEach var="getdmsp" items="${dmsp }">
						<li><a >${getdmsp.getTendanhmuc() }</a></li>
					</c:forEach>
				</ul>

			</div>

			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-5 col-md-5">
						<img alt="" style="width: 100%"
							src='<c:url value="/resources/image/sanpham/${getsp.getHinhsanpham() }"/>'/>
					</div>
					<div class="col-sm-7 col-md-7">
						<h4 id="tensp" data-masp="${getsp.getMasanpham() }">${getsp.getTensanpham() }</h4>
						<h5 id="giatien" data-value="${getsp.getGiatien() }"
							style="color: red !important;">${getsp.getGiatien() }VND</h5>
						<br>
						<table class="table">
							<thead>
								<tr>
									<td>Màu Sản Phẩm</td>
									<td>Size Sản Phẩm</td>
									<td>Số Lượng Còn</td>
									<td>Tuỳ chọn</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="ctsp" items="${getsp.getChitietsanpham() }">
									<tr>
										<td class="mau" data-mamau="${ctsp.getMausanpham().getMamau()}">${ctsp.getMausanpham().getTenmau()}</td>
										<td class="size" data-masize="${ctsp.getSizesanpham().getMasize()}">${ctsp.getSizesanpham().getSize()}</td>
										<td class="soluong">${ctsp.getSoluong()}</td>
										<td><button data-mact="${ctsp.getMachitietsanpham()}"
												class=" btn btn-success btn-giohangg">+giỏ hàng</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-2 col-md-2" >
				<h4 >Mô tả sản phẩm</h4>
				<span>${getsp.getMota() }</span>
				
			</div>
		</div>
	</div>
	

	<div id="footer" class="container-fluid">
		
		<div class="row">
			<div Class="col-sm-4 col-md-4">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Với mong muốn có thể đáp ứng được mọi nhu cầu về thời trang của khách hàng, 
				tạo ra sự đa dạng cho lựa chọn thường ngày của bạn,
				 TRUNG HIEU luôn quan tâm không chỉ là thiết kế, kiểu dáng mà còn là chất lượng của từng bộ đồ.</span>
			</div>
				
			<div Class="col-sm-4 col-md-4">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<p><span >Số 23 ngõ 3, Thái Hà, Đống Đa, Hà Nội.</span></p>
				<p><span>Email: nguyenhieu2501@gmail.com</span></p>
				<p><span>SĐT: 0355370909</span></p>
			</div>
			
			<div Class="col-sm-4 col-md-4">
				<p><span class="title-footer">GÓP Ý</span></p>
				<form action="">
					<input class="material-textinput" style="margin-bottom:8px;" type="text" placeholder="Email">
					<textarea class="material-textinput" rows="4"cols="50"placeholder="Nội Dung" style="margin-bottom:8px;"></textarea>
					<button class="material-primary-bottom">Đồng Ý</button>
				</form>
			</div>
		</div>
	
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>