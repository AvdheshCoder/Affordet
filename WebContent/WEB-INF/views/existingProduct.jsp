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
				<h2>Existing Products</h2>
			</td>
		</tr>


		<tr>
			<td height="40" colspan="4" style="border-top: 1px solid #000"
				align="center">
				<h3>
					<font color="green"><u>Product Information</u></font>
				</h3>
			</td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${fn:length(pagedcust.productInfo)>0}">
			<table id="tbl_report" align="center" cellpadding="3" cellspacing="2"
				border="0" class="gridviewnew" style="width: 97%; padding: 5px;">
				<thead style="background-color: #E0E0D1">
					<tr>
						<th width="15">Select</th>
						<th width="10">S.No</th>
						<th width="25">Product Id</th>
						<th width="25">Product Name</th>
						<th width="25">Active status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cust" items="${pagedcust.productInfo}"
						varStatus="status">
						<tr>
							<td><input type='radio' name='selection' value=""
								id='selRd2'
								onclick="load_product('editProduct','bhDtl','chakri', 'productId=${cust.productId}');">
							</td>

							<td><c:choose>
									<c:when test="${status.count == 10}">
					  	   ${page+1}0
					  	   </c:when>
									<c:otherwise>
					  	   ${page}${status.count}
					  	  </c:otherwise>
								</c:choose></td>
							<td>${cust.productId}</td>
							<td>${cust.productName}</td>
							<td><c:choose>
									<c:when test="${cust.isActive == '1'}">Active</c:when>
									<c:otherwise>Inactive</c:otherwise>
								</c:choose></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>


			<div id="content">
				<div align="center">
					<c:if test="${!pagedcust.navInfo.firstPage}">
						<a href="existingProduct?page=0">First</a>&nbsp;
					</c:if>
					<c:forEach var="i" items="${pagedcust.navInfo.indexList}">
						<c:choose>
							<c:when test="${i != pagedcust.navInfo.currentPage}">
								<a href="existingProduct?page=${i}">${i}</a>&nbsp;
						</c:when>
							<c:otherwise>
								<b>${i}</b>&nbsp;
						</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${!pagedcust.navInfo.lastPage}">
						<a href="existingProduct?page=${pagedcust.navInfo.pageCount - 1}">Last</a>
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