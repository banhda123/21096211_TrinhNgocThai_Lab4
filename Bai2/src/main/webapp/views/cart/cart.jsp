<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<style type="text/css">
	.btn{
		text-decoration: none;
	    color: black;
	    background-color: lightgray;
	    border: 1px solid gray;
	    margin-top: 8px;
	}

</style>
<script type="text/javascript">
	function updateLinkUpdate(id, input) {
		const updateLink = document.getElementById('updateLink-' + id);
		updateLink.href = "${pageContext.request.contextPath}/cart?action=update&id=" + id +"&quantity=" + input.value
	}
</script>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/product" style="font-size: 24px; ">Product</a>
		<h1>Cart</h1>
		<table border="1">
			<tr>
				<th>Model Description</th>
				<th>Quantity</th>
				<th>Unit Price</th>
				<th>Total</th>
			</tr>
			<c:set var="subTotal" value="0"></c:set>
			<c:choose>
				<c:when test="${empty sessionScope.cart}">
					<tr>
						<td>Cart is currently empty-</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="cartItem" items="${sessionScope.cart}">
						<c:set var="total" value="${ cartItem.product.price * cartItem.quantity }"></c:set>
						<c:set var="subTotal" value="${ subTotal + total }"></c:set>
						<tr>
							<th>${ cartItem.product.name}</th>
							<th>
								<input style="height: 20px; width: 35px; font-size: 16px" value="${ cartItem.quantity }" onchange="updateLinkUpdate(${cartItem.product.id}, this)">
								<a class="btn" id="updateLink-${ cartItem.product.id }" href="${pageContext.request.contextPath}/cart?action=update&id=${cartItem.product.id}&quantity=${ cartItem.quantity }">Update</a>
								<a class="btn" href="${pageContext.request.contextPath}/cart?action=remove&id=${cartItem.product.id}">Remove</a>
							</th>
							<th>
								<fmt:formatNumber value="${ cartItem.product.price }" type="currency"/>
							</th>
							<th> <fmt:formatNumber value="${ total }" type="currency"/></th>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="2"></td>
				<td></td>
				<td>
					Subtotal: <fmt:formatNumber value="${ subTotal }" type="currency"/>
				</td>
			</tr>
		</table>
	
	</div>
</body>
</html>