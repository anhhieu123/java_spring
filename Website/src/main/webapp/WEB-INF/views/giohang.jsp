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
				<a class="navbar-brand" href=""><img alt="logo"
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
								<li><a class="circle glyphicon glyphicon-user" href="dangnhap/"><span>${name }</span></a>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="../dangnhap/">Đăng nhập</a></li>
							</c:otherwise>
						</c:choose>
						
						<li><a href="../giohang/"><img alt="logo"
							src='<c:url value = "/resources/image/icons8-favorite-cart-32.png"/>' />(${Giohang})</a></li>

					</ul>

				</div>
			</nav>

		
		</div>
	</div>

	<div class="container" id="chitiet_1">
		<div class="row ">
			<div class="col-md-6">
				<h2>Giỏ Hàng Sản Phẩm</h2>
				<table class="table">
					<thead>
						<tr>
							<td><h5>Tên</h5></td>
							<td><h5>Màu</h5></td>
							<td><h5>Size</h5></td>
							<td><h5>Số Lượng</h5></td>
							<td><h5>Giá Tiền</h5></td>
							<td><h5>Tuỳ Chọn</h5></td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="value" items="${giohangs }">
							<tr>
								<td class="tensp" data-masp="${value.getMasp() }">${value.getTensp() }</td>
								<td class="mau" data-mamau="${value.getMamau() }">${value.getTenmau() }</td>
								<td class="size" data-masize="${value.getMasize() }">${value.getTensize() }</td>
								<td><input class="slg"  type="number" min="1" value="${value.getSoluong() }" /></td>
								<td class="gt" data-value="${value.getGiatien() }"> ${value.getGiatien() }</td>
								<td id="btn-xoa" class=" btn btn-danger">Xoá</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h4 style="color: red;" id="tongtien"></h4>
			</div>


			<div class="col-md-6">
				<h2>Thông tin người nhận</h2>
				<form action="" method="post">
					<div class="form-group">
						<label>Tên người nhận</label> <input type="text"
							class="form-control" id="tennguoinhan" name="tenKH"> <label>Địa
							Chỉ</label> <input type="text" class="form-control" id="diachi" name="diaChi">
						<label>Số Điện Thoại</label> <input type="text"
							class="form-control" id="sodienthoai" name="soDT">
					</div>
					<div class="form-group">
					<label>Phương thức nhận hàng</label>
					<div class="radio">
						<label ><input checked="checked" type="radio" name="hinhthucgiao" value="Nhận tại cửa hàng">Nhận tại cửa hàng</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="hinhthucgiao" value="Giao hàng online">Giao hàng online</label>
					</div>
					</div>
					<div class="form-group">
						<label>Nội dung</label>
						<textarea class="form-control" rows="3" name="ghichu"></textarea>
					</div>
					<button class="btn btn-success">Đặt Hàng</button>
					<button class="btn btn-danger">Huỷ bỏ</button>

				</form>
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