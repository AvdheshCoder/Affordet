<table width="95%" border="0" cellspacing="0" cellpadding="4"
	class="nom">

	<tr>
		<td colspan="4"><input type="hidden" id="productId"
			name="productId" value="${map.productId}" /> <input type="hidden"
			id="sellerId" name="sellerId" value="${map.sellerId}" /> <input
			type="hidden" id="isActive" name="isActive" value="1"></input>
			<h2>Add Product Form</h2></td>
	</tr>


	<tr>
		<td height="40" colspan="4" style="border-top: 1px solid #000"
			align="center">
			<h3>
				<font color="green">Product Information</font>
			</h3>
		</td>
	</tr>
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="4"
	class="nom">
	<tr>
		<td width='20%' align="center">Product Name</td>
		<td width='30%'><input type="text" class="text1" maxlength="80"
			id="productName" name="productName" style="widht: 20"
			onclick="hideSpan('productNameError')" /></td>
		<!-- <td width=10%></td> -->

		<td width='20%' align="center">Actual Price</td>
		<td width='30%'><input type="text" class="text1" id="actualPrice"
			name="actualPrice" maxlength="4"
			onkeypress="return isNumberKeyForMobile(event);" /></td>


	</tr>
	<tr>
		<td></td>
		<td><font color='red'> <span id=productNameError></span>
		</font></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>

	<tr valign="top">

		<td>Product Description</td>
		<td valign="top"><textarea rows="2" id="productDesc"
				name="productDescription" style="width: 88%; resize: none;"
				maxlength="1000">
									<c:out value=""></c:out> </textarea></td>

		<td>Discount Price</td>
		<td><input type="text" class="text1" id="discountedPrice"
			name="discountedPrice" maxlength="4"
			onkeypress="return isNumberKeyForMobile(event);" onblur="" value="" /></td>
	</tr>

	<!-- <tr>
		<td>Quantity in :</td>
		<td><span><input type="radio" ></span></td>
	</tr> -->

	<tr>
		<td>Quantity</td>
		<td><input type="text" class="text1" id="quantity"
			name="quantity" maxlength="2"
			onkeypress="return isNumberKeyForMobile(event);" onblur="" value="" /></td>


		<td></td>
		<td colspan="1" align="left">Discount %</td>
		<td><input type="text" class="text1" id="discount"
			name="discount" maxlength="2"
			onkeypress="return isNumberKeyForMobile(event);" onblur="" value="" /></td>
	</tr>
	<tr>




		<td>Select Category</td>
		<td><select class="select" id="categoryId" name="categoryId"
			onchange="">
				<option value="0">Please Select category</option>

				<c:forEach var="listItems" items="${map.catList}">
					<option value="${listItems.categoryId}">${listItems.categoryName}</option>



				</c:forEach>
		</select></td>


		<!-- <td></td>
		<td>Select Sub Category</td>
		<td><select class="select" id="subCategoryId"
			name="subCategoryId" onchange="">
				<option value="0">Please Select Sub Category</option>

		</select></td> -->

	</tr>

	<!-- <tr>
		<td><br /></td>
	</tr>
	<tr>

		<td align="left" colspan="2" class="heading1"><u>Delivery
				Information</u></td>
		<td align="left" colspan="2"></td>
		<td align="left" colspan="2"></td>
	</tr> -->
	<!-- <tr>
		<td width='10%'>Delivery Time (Days)</td>
		<td width='35%'><input type="text" class="text1" value=""
			id="deliveryTime" name="deliveryTime" maxlength="1"
			onkeypress="return isNumberKeyForMobile(event);" /></td>
		<td width=10%></td>

		<td width='10%' colspan="1" align="left">Delivery Charges</td>
		<td width='35%'><input type="text" class="text1"
			id="deliveryCharges" name="deliveryCharges" maxlength="4"
			onkeypress="return isNumberKeyForMobile(event);" onblur="" value="" /></td>


	</tr>

	<tr>
		<td width='10%'>Cash On Delivery</td>
		<td width='35%'><input type="radio" value="Y"
			name="cashOnDeliveryCheck" id="yes"
			onclick="selectValue('Y','cashOnDelivery','cashOnDeliveryCharges');">YES</input>
			<input type="radio" value="N" name="cashOnDeliveryCheck" id="no"
			checked="checked"
			onclick="selectValue('N','cashOnDelivery','cashOnDeliveryCharges');">NO</input>
			<input type="hidden" id="cashOnDelivery" name="cashOnDelivery"
			value="N"></input></td>
		<td width=10%></td>

		<td width='10%' colspan="1" align="left">C.O.D Charges</td>
		<td width='35%'><input type="text" class="text1"
			disabled="disabled" id="cashOnDeliveryCharges"
			name="cashOnDeliveryCharges" maxlength="4"
			onkeypress="return isNumberKeyForMobile(event);" onblur="" value="" /></td>


	</tr>

	<tr>
		<td width='10%'>One Day Delivery</td>
		<td width='35%'><input type="radio" value="Y"
			name="oneDayDeliveryCheck" id="y"
			onclick="selectValue('Y','oneDayDelivery','oneDayDeliveryCharges');">YES</input>
			<input type="radio" value="N" name="oneDayDeliveryCheck" id="n"
			checked="checked"
			onclick="selectValue('N','oneDayDelivery','oneDayDeliveryCharges');">NO</input>
			<input type="hidden" id="oneDayDelivery" name="oneDayDelivery"
			value="N"></input></td>
		<td width=10%></td>

		<td width='10%' colspan="1" align="left">O.D.D Charges</td>
		<td width='35%'><input type="text" class="text1"
			disabled="disabled" id="oneDayDeliveryCharges"
			name="oneDayDeliveryCharges" maxlength="4"
			onkeypress="return isNumberKeyForMobile(event);" onblur="" value="" /></td>


	</tr>




	<tr>
		<td width='10%'>Return Policy</td>
		<td width='35%'><input type="radio" value="Y"
			name="returnPolicyCheck" id="yes"
			onclick="selectValue('Y','returnPolicy','returnPolicyDays');">YES</input>
			<input type="radio" value="N" name="returnPolicyCheck" id="no"
			checked="checked"
			onclick="selectValue('N','returnPolicy','returnPolicyDays');">NO</input>
			<input type="hidden" id="returnPolicy" name="returnPolicy" value="N"></input></td>
		<td width=10%></td>

		<td width='10%' colspan="1" align="left">Return Days</td>
		<td width='35%'><input type="text" class="text1"
			disabled="disabled" id="returnPolicyDays" name="returnPolicyDays"
			maxlength="2" onkeypress="return isNumberKeyForMobile(event);"
			onblur="" value="" /></td>


	</tr>


	<tr>
		<td width='10%'>Gift Wrap</td>
		<td width='35%'><input type="radio" value="Y"
			name="giftWrapCheck" id="ye"
			onclick="selectValue('Y','giftWrap','giftWrapCharges');">YES</input>
			<input type="radio" value="N" name="giftWrapCheck" id="noe"
			checked="checked"
			onclick="selectValue('N','giftWrap','giftWrapCharges');">NO</input> <input
			type="hidden" id="giftWrap" name="giftWrap" value="N"></input></td>
		<td width=10%></td>

		<td width='10%' colspan="1" align="left">Charges</td>
		<td width='35%'><input type="text" class="text1"
			disabled="disabled" id="giftWrapCharges" name="giftWrapCharges"
			maxlength="2" onkeypress="return isNumberKeyForMobile(event);"
			onblur="" value="" /></td>


	</tr> -->



	<tr style="line-height: 25px;">
		<td align="left" colspan="2" class="heading1"><u>Images Panel</u></td>

	</tr>


	<tr>
		<td><font color="red">Main Image</font></td>

		<td><input type="file" name="upfile1" id="upfile1" /></td>
		<td colspan="2"><input type="button" value="Upload"
			onclick="saveImage('upfile1','1','byteimg1','image1');" /><input
			type="hidden" id="image1" name="image1" value="0" /></td>


	</tr>


	<tr>
		<td>1st Image</td>
		<td><input type="file" name="upfile2" id="upfile2" /></td>
		<td colspan="2"><input type="button" value="Upload"
			onclick="saveImage('upfile2','2','byteimg2','image2');" /><input
			type="hidden" id="image2" name="image2" value="0" /></td>


	</tr>

	<tr>
		<td>2nd Image</td>

		<td><input type="file" name="upfile3" id="upfile3" /></td>
		<td colspan="2"><input type="button" value="Upload"
			onclick="saveImage('upfile3','3','byteimg3','image3');" /><input
			type="hidden" id="image3" name="image3" value="0" /></td>


	</tr>



</table>

<table class="nom" width="100%">

	<tr>
		<td colspan="2" align="center"><input type="button"
			value="submit" onclick="add();"></td>
	</tr>
</table>