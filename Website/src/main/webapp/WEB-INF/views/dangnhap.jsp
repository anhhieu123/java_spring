<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập tài khoản</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-logo">WELCOME </span><br /> <span id="hint-logo">Hãy
						yêu theo cách của bạn</span>

				</div>

				<div id="header-bottom-left">
					<p>
						<img alt="icon-oval"
							src='<c:url value ="/resources/image/icon_oval.png " />' /><span>
							Luôn luôn cập nhật xu hướng </span>
					</p>
					<p>
						<img alt="icon-oval"
							src='<c:url value ="/resources/image/icon_oval.png " />' /><span>
							Giảm giá cho khách VIP </span>
					</p>
					<p>
						<img alt="icon-oval"
							src='<c:url value ="/resources/image/icon_oval.png " />' /><span>
							Tận tình tư vấn tạo lên phong cách</span>
					</p>
				</div>

			</div>

			<div id="container-login-right">
				<div class="header-login" id="header-top-right">
					<span class="act	ived" id="dangnhap">Đăng Nhập</span> / <span id="dangky">Đăng Ký</span>
				</div>
			<div id="container-center-login-right">
				<div class="container-login-form" id="container-center-login-right">
						<input id="email" class="material-textinput input-icon-email"
							placeholder="Email" type="text" name="email"> <p></p>
						<input id="matkhau"
							class="material-textinput input-icon-password"
							placeholder="Password" type="password" name="matkhau"> <p></p>
						<button id="btndangnhap" class="material-primary-bottom"
						type="submit">Đăng Nhập</button><br />

				</div>
				<div class="container-signup-form" id="container-center-login-right"><p></p>
					<form action="" method="post">
						<input id="email" class="material-textinput input-icon-email"
								placeholder="Email" type="text" name="email"><br /><p></p>
						<input id="matkhau"
								class="material-textinput input-icon-password"
								placeholder="Password" type="password" name="matkhau"><br /><p></p>
						<input id="nhapmatkhau"
								class="material-textinput input-icon-password"
								placeholder="Repeat Password" type="password" name="nhaplaimatkhau"><br />		
						<input id="btndangky" class="material-primary-bottom"
							type="submit" value="Đăng Ký"><br />
					</form>
				</div>
			</div>
				
				<span id="result">${result}</span>
				<div id="login-icon">
					<img alt="icon-oval"
						src='<c:url value ="/resources/image/facebook.png " />' /> <img
						alt="icon-oval"
						src='<c:url value ="/resources/image/google.png " />' />
				</div>

			</div>

		</div>

	</div>
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>