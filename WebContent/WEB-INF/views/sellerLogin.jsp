<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Seller Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="application/x-javascript">
		
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
	 function goBackToLogin(){
		 document.sellerform.action = "login";
		 document.sellerform.submit();
	 }
	 function sellerLogin(){
		 document.sellerform.action = "validateSeller";
		 document.sellerform.submit();
	 }



	</script>
	<link href="style/style9.css" rel='stylesheet' type='text/css' />
	<!-- fonts -->
	<!-- fonts -->
</head>
<body>
	<!-- login-form-->
	<div class="login-form">
		<h1>Seller Login</h1>
		<!--form-left-->
		<div class="form-left">
			<form name="sellerform" id="sellerform" method="post">
				<div class="email">
					<span>Email:</span>
					<c:choose>
						<c:when test="${map.errorMsg == '1'}">
							<input type="text" class="form-control" id="sellerId"
								name="sellerId" value="${map.emailId}"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Your Email here';}" />
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control" id="sellerId"
								name="sellerId" value="Your Email here"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Your Email here';}" />
						</c:otherwise>
					</c:choose>

					<div class="clear"></div>
				</div>
				<div class="password">
					<span>Password:</span> <input type="password" class="form-control"
						id="sellerPassword" name="sellerPassword" value="123456789"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = '123456789';}" />
					<div class="clear"></div>
				</div>
				<c:if test="${map.errorMsg == '1'}">
					<font color="#e2e5e2;">${map.msg}</font>
				</c:if>
				</br> <input type="button" value="Login" onclick="sellerLogin();" /> <input
					type="button" value="Back" onclick="goBackToLogin();" />
			</form>
		</div>
		<!--form-left-->
		<!--copy-right-->
		<div class="copy-right">
			<p>Design By GG Solutions</p>
		</div>
		<div class="clear"></div>
		<!--copy-right-->
	</div>
	<!-- login-form-->
</body>
</html>