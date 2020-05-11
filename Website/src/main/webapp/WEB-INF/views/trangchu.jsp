<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta charset="utf-8">
<title>NYC SHOP</title>

</head>
<body>
	<div class="container-fluid" id="header">
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light none_nav">
				<a class="navbar-brand" href="/"><img alt="logo"
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
							aria-expanded="false"> Sản Phẩm	 </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
						<li class="nav-item"><a class="nav-link disabled" href="">DỊCH
								VỤ</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="website/">LIÊN
								HỆ</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${name != null }">
								<li><a class="circle glyphicon glyphicon-user" href="dangnhap/"><span>${name }</span></a>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="dangnhap/">Đăng nhập</a></li>
							</c:otherwise>
						</c:choose>
						
						<li><a href="giohang/"><img alt="logo"
							src='<c:url value = "/resources/image/icons8-favorite-cart-32.png"/>' /></a></li>

					</ul>

				</div>
			</nav>

			<div class="event-header container wow bounceIn">
				<span>Ngày 17/10- 23/10/2017</span><br /> <span
					style="font-size: 50px">Mua 1 tặng 1</span><br />
				<button>Xem ngay</button>

			</div>
		</div>
	</div>

	<div class="container" id="info">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 wow bounceIn" data-wow-duration="1s">
				<img class="icon1" alt="logo"
					src='<c:url value = "/resources/image/icons8-good-quality-96.png"/>' /><br>
				<span style="font-size: 36px; font-weight: bold;">CHẤT LƯỢNG</span><br>
				<span>Chúng tôi cam kết chất lượng tốt nhất dành cho bạn</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow bounceIn" data-wow-duration="1s" data-wow-delay="2s">
				<img class="icon1"alt="logo"
					src='<c:url value = "/resources/image/icons8-pig-64.png"/>' /><br>
				<span style="font-size: 36px; font-weight: bold;">TIẾT KIỆM
					CHI PHÍ</span><br> <span>Tiết kiệm chi phí cho bạn.</span>
			</div>

			<div class="col-12 col-sm-4 col-md-4 wow bounceIn " data-wow-duration="1s" data-wow-delay="3s">
				<img class="icon1" alt="logo"
					src='<c:url value = "/resources/image/icons8-delivery-64.png"/>' /><br>
				<span style="font-size: 36px; font-weight: bold;">GIAO HÀNG</span><br>
				<span>Chúng tôi cam kết giao hàng tận nơi cho bạn trong 7
					ngày</span>
			</div>
		</div>
	</div>

	<div id="tittle-sanpham" class="container">
		<span>SẢN PHẨM HOT</span>

		<div class="row">
			
			
			<c:forEach var="sanpham" items="${listSanPham}">
				<div class="col-md-3 col-sm-6">
				<a href="chitiet/${sanpham.getMasanpham()}">
					<div class="sanpham wow zoomIn">
						<img class="icon" alt="logo"
							src='<c:url value = "/resources/image/sanpham/${sanpham.getHinhsanpham()}"/>' /><br>
						<span>${sanpham.getTensanpham()}</span><br> <span class="gia">>${sanpham.getGiatien()}VND</span>
					</div>
				</a>
				</div>
			</c:forEach>
			
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