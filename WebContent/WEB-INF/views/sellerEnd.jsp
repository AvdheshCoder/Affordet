<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller-End</title>
<link rel="stylesheet" type="text/css" href="style/style_3.css" />
<%@ include file="/WEB-INF/views/header_seller.jsp"%>
<script type="text/javascript">
	$(function() {
		var menu_ul = $('.menu > li > ul'), menu_a = $('.menu > li > a');
		menu_ul.hide();
		menu_a.click(function(e) {
			e.preventDefault();
			if (!$(this).hasClass('active')) {
				menu_a.removeClass('active');
				menu_ul.filter(':visible').slideUp('normal');
				$(this).addClass('active').next().stop(true, true).slideDown(
						'normal');
			} else {
				$(this).removeClass('active');
				$(this).next().stop(true, true).slideUp('normal');
			}
		});

	});
	$(window).load(function() {
		$("#flexiselDemo1").flexisel({
			visibleItems : 5,
			animationSpeed : 1000,
			autoPlay : true,
			autoPlaySpeed : 3000,
			pauseOnHover : true,
			enableResponsiveBreakpoints : true,
			responsiveBreakpoints : {
				portrait : {
					changePoint : 480,
					visibleItems : 1
				},
				landscape : {
					changePoint : 640,
					visibleItems : 2
				},
				tablet : {
					changePoint : 768,
					visibleItems : 3
				}
			}
		});

		$("#flexiselDemo2").flexisel({
			visibleItems : 5,
			animationSpeed : 1000,
			autoPlay : true,
			autoPlaySpeed : 3000,
			pauseOnHover : true,
			enableResponsiveBreakpoints : true,
			responsiveBreakpoints : {
				portrait : {
					changePoint : 480,
					visibleItems : 1
				},
				landscape : {
					changePoint : 640,
					visibleItems : 2
				},
				tablet : {
					changePoint : 768,
					visibleItems : 3
				}
			}
		});
		$("#flexiselDemo3").flexisel({
			visibleItems : 5,
			animationSpeed : 1000,
			autoPlay : true,
			autoPlaySpeed : 3000,
			pauseOnHover : true,
			enableResponsiveBreakpoints : true,
			responsiveBreakpoints : {
				portrait : {
					changePoint : 480,
					visibleItems : 1
				},
				landscape : {
					changePoint : 640,
					visibleItems : 2
				},
				tablet : {
					changePoint : 768,
					visibleItems : 3
				}
			}
		});
	});
</script>
<script type="text/javascript" src="js/jquery.flexisel.js"></script>


</head>
<body>
	<form name="sellerform" id="sellerform" method="post">
		<div class="container">

			<div id="chakri"></div>
			<div class="shoes-grid">

				<div class="wrap-in">
					<div class="wmuSlider example1 slide-grid">
						<div class="wmuSliderWrapper">
							<c:choose>
								<c:when test="${map.menuType == '1'}"><%@ include
										file="/WEB-INF/views/SellerAddProduct.jsp"%></c:when>
								<c:when test="${map.menuType == '2'}"><%@ include
										file="/WEB-INF/views/existingProduct.jsp"%></c:when>
								<c:when test="${map.menuType == '4'}"><%@ include
										file="/WEB-INF/views/ListOrder.jsp"%></c:when>
							</c:choose>


						</div>

						<script src="js/jquery.wmuSlider.js"></script>
					</div>
				</div>
			</div>

			<%@ include file="/WEB-INF/views/SellerActionMenu.jsp"%>


		</div>
		<div class="clearfix"></div>
		<div class="clear"></div>


	</form>
	<%-- 	<%@ include file="/WEB-INF/views/footer.jsp"%> --%>


	<script type="text/javascript">
		function addProduct() {
			document.sellerform.action = "sellerEnd";
			document.sellerform.submit();
		}

		function add() {

			//alert("1");
			alert(document.getElementById("productName").value)
			if (document.getElementById("productName").value == "") {
				document.getElementById("productNameError").innerHTML = "Please fill Product Name";
				return false;
			}

			else {

				document.sellerform.action = "addProduct";
				document.sellerform.submit();
			}

		}

		function existingProduct() {
			document.sellerform.action = "existingProduct";
			document.sellerform.submit();
		}

		function orders() {
			document.sellerform.action = "orders";
			document.sellerform.submit();
		}

		function rating() {
			document.sellerform.action = "rating";
			document.sellerform.submit();
		}

		function selectValue(val, ID1, ID2) {
			document.getElementById(ID1).value = val;
			if (val == "N") {
				document.getElementById(ID2).value = "";
				document.getElementById(ID2).disabled = true;
			} else {
				document.getElementById(ID2).disabled = false;
			}
		}

		function saveImage(imgId, id, imageSetter, hiddenImageId) {
			if (document.getElementById(imgId).value == "") {
				alert("Please select Image");
				return false;
			}

			imageVal = document.getElementById(imgId).value.split('.');
			var ext = imageVal[imageVal.length - 1].toLowerCase();
			if ((ext != 'jpg') && (ext != 'jpeg') && (ext != 'png')) {
				alert("कृपया फाइल jpg, jpeg, png फॉर्मेट में चुने|");
				return false;
			}

			var filesize = ((document.getElementById(imgId).files[0].size) / (1024 * 1024))
					.toFixed(2);
			var oMyForm = new FormData();
			oMyForm.append("upfile", document.getElementById(imgId).files[0]);
			oMyForm.append("imageId", id);
			oMyForm.append("pId", document.getElementById("productId").value);
			oMyForm.append("categoryId",
					document.getElementById("categoryId").value);
			oMyForm.append("subCategoryId", document
					.getElementById("subCategoryId").value);
			loader('chakri');
			$
					.ajax({
						url : 'saveImage',
						data : oMyForm,
						dataType : 'text',
						processData : false,
						contentType : false,
						type : 'POST',
						success : function(data) {
							remove_popup('chakri');
							if (data != "2") {
								document.getElementById(imageSetter).innerHTML = "<img width='110' src=data:image/png;base64,"+ data + " />";
								document.getElementById(hiddenImageId).value = "1";
							} else {
								alert("IMAGE NOT SAVED");
							}
						}
					});

		}

		function listOrders() {
			document.sellerform.action = "getOrdersList";
			document.sellerform.submit();
		}
	</script>
</body>
</html>