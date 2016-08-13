<%@ page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form name="sellerform" id="sellerform" method="post">
	<div id="chakri"></div>

	<table width="95%" border="0" cellspacing="0" cellpadding="4"
		class="nom">

		<tr>
			<td colspan="4">
				<h2>List Of Orders</h2>
			</td>
		</tr>


		<tr>
			<td height="40" colspan="4" style="border-top: 1px solid #000"
				align="center">
				<h3>
					<font color="green"><u>Order Information</u></font>
				</h3>
			</td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${fn:length(porder.ordersInfo)>0}">
			<table id="tbl_report" align="center" cellpadding="3" cellspacing="2"
				border="0" class="gridviewnew" style="width: 97%; padding: 5px;">
				<thead style="background-color: #E0E0D1">
					<tr>

						<th width="23%">Order Id</th>
						<th width="20%">Order by</th>
						<th width="20%">Order Date</th>
						<th width="20%">Order Total Amount</th>
						<th width="20%">Order Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${porder.ordersInfo}"
						varStatus="status">
						<tr>
							<%-- <td><input type='radio' name='selection' value=""
								id='selRd2'
								onclick="load_product('editProduct','bhDtl','chakri', 'productId=${cust.productId}');">
							</td> --%>
							<td align="left"><a class="now-get get-cart-in"
								style="float: left;" rel="ibox"
								href="trackOrderDetails?orderId=${order.orderId}" id='bef'><span>
										${order.orderId}</span></a></td>
							<td>${order.emailId}</td>
							<td>${order.orderDate}</td>
							<td>${order.totalAmount}</td>
							<td>${order.statusDescription}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


			<div id="content">
				<div align="center">
					<c:if test="${!porder.navInfo.firstPage}">
						<a href="existingProduct?page=0">First</a>&nbsp;
					</c:if>
					<c:forEach var="i" items="${porder.navInfo.indexList}">
						<c:choose>
							<c:when test="${i != porder.navInfo.currentPage}">
								<a href="getOrdersList?page=${i}">${i}</a>&nbsp;
						</c:when>
							<c:otherwise>
								<b>${i}</b>&nbsp;
						</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${!porder.navInfo.lastPage}">
						<a href="getOrdersList?page=${porder.navInfo.pageCount - 1}">Last</a>
					</c:if>
				</div>
			</div>

		</c:when>
		<c:otherwise>


			<font color="red">No Details Found</font>

		</c:otherwise>

	</c:choose>

	<div id="bhDtl"></div>

</form>