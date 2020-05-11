$(document).ready(
		function() {
			$("#btndangnhap").click(function() {
				
				var email = $("#email").val();
				var matkhau = $("#matkhau").val();

				$.ajax({
					url : "/website/api/KiemTraDN",
					type : "GET",
					data : {
						email : email,
						matkhau : matkhau
					},
					success : function(value) {
						if (value == "true") {
							linkhientai = window.location.href;
							link = linkhientai.replace("dangnhap/", "");
							window.location = link;
						} else {
							$("#result").text("Email hoặc mật khẩu không đúng!")
							
						}
					}
				})
			});
			
			
			$(".btn-giohangg").click(
					function() {
						
						var mamau = $(this).closest("tr").find(".mau").attr(
								"data-mamau");
						var tenmau = $(this).closest("tr").find(".mau").text();
						var masize = $(this).closest("tr").find(".size").attr(
								"data-masize");
						var tensize = $(this).closest("tr").find(".size")
								.text();
						var tensp = $("#tensp").text();
						var masp = $("#tensp").attr("data-masp");
						var soluong = $(this).closest("tr").find(".soluong")
								.text();
						var giatien = $("#giatien").attr("data-value");
						var machitiet = $(this).attr("data-mact");

						$.ajax({
							url : "/website/api/AddGioHang",
							type : "GET",
							data : {
								masp : masp,
								masize : masize,
								mamau : mamau,
								tensp : tensp,
								tensize : tensize,
								giatien : giatien,
								tenmau : tenmau,
								soluong : soluong,
								machitiet : machitiet

							},
							success : function(value) {
								$(".cccc").html("("+value+")");
							}
										
						})
					});
			
			$("#btn-xoa").click(
					function() {
						var self = $(this);
						var mamau = $(this).closest("tr").find(".mau").attr(
								"data-mamau");
						var masize = $(this).closest("tr").find(".size").attr(
								"data-masize");
						var masp = $(this).closest("tr").find(".tensp").attr(
								"data-masp");

						$.ajax({
							url : "/website/api/XoaGioHang",
							type : "GET",
							data : {
								masp : masp,
								masize : masize,
								mamau : mamau
							},
							success : function(value) {
								self.closest("tr").remove();
								Gantongtien(true);
							}
						})

					})

			Gantongtien();

			function Gantongtien(isEventChange) {
				var ttsp = 0;
				$(".gt").each(
						function() {
							var giatien = $(this).closest("tr").find(".gt")
									.attr("data-value");
							var soluong = $(this).closest("tr").find(".slg")
									.val();

							var tongtien = soluong * giatien;

							ttsp = ttsp + tongtien;

							if (!isEventChange) {
								$(this).html(tongtien);
							}

							var fomatttsp = ttsp.toString().replace(
									/(\d)(?=(\d{3})+(?!\d))/g, '$1.');
							$("#tongtien").html(
									"Tổng tiền :" + fomatttsp + " VND");
						})
			}

			$(".slg").change(
					function() {
						var soluong = $(this).val();
						var giatien = $(this).closest("tr").find(".gt").attr(
								"data-value");
						var tongtien = soluong * parseInt(giatien);

						$(this).closest("tr").find(".gt").html(tongtien);

						Gantongtien(true);

						var mamau = $(this).closest("tr").find(".mau").attr(
								"data-mamau");
						var masize = $(this).closest("tr").find(".size").attr(
								"data-masize");
						var masp = $(this).closest("tr").find(".tensp").attr(
								"data-masp");

						$.ajax({
							url : "/website/api/updateGioHang",
							type : "GET",
							data : {
								masp : masp,
								masize : masize,
								mamau : mamau,
								soluong : soluong

							},
							success : function(value) {

							}
						})
					})

			
			
			
			$("#dangnhap").click(function() {
				$(this).addClass("active");
				$("#dangky").removeClass("active");
				$(".container-login-form").show();
				$(".container-signup-form").hide()
				
			});
			
			$("#dangky").click(function() {
				$(this).addClass("active");
				$("#dangnhap").removeClass("active");
				$(".container-login-form").hide();
				$(".container-signup-form").show()
				
			});
			
			
			
		})