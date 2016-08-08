<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	function show(url) {
		window.location = url;
	}
</script>
<div class="sub-cate">
	<div class=" top-nav rsidebar span_1_of_left">
		<h3 class="cate">CATEGORIES</h3>

		<ul class="menu">
			<li class="item1"><a href='#' onclick="addProduct();"> Add
					Product</a></li>
			<li class="item1"><a href='#' onclick="existingProduct();">
					Existing Products</a></li>
			<li class="item1"><a href='#' onclick="orders();"> Orders</a></li>
			<li class="item1"><a href='#' onclick="rating();"> Rating</a></li>
		</ul>



	</div>
	<!--initiate accordion-->
	<script type="text/javascript">
		$(function() {
			var menu_ul = $('.menu > li > ul'), menu_a = $('.menu > li > a');
			menu_ul.hide();
			menu_a.click(function(e) {
				e.preventDefault();
				if (!$(this).hasClass('active')) {
					menu_a.removeClass('active');
					menu_ul.filter(':visible').slideUp('normal');
					$(this).addClass('active').next().stop(true, true)
							.slideDown('normal');
				} else {
					$(this).removeClass('active');
					$(this).next().stop(true, true).slideUp('normal');
				}
			});

		});
	</script>


</div>
