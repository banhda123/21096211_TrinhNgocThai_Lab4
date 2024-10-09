<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	.container{
		display: flex; 
		flex-direction: column; 
		align-items: center;
		width: 50%;
		justify-content: space-between;
		border: 10px solid gray;
	}

	.content{
	    width: 100%;
	    display: flex;
	    flex-wrap: wrap;
	    align-items: center;
	    justify-content: space-around;
	}

	.item {
		width: 200px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		padding: 16px;
   		border: 1px solid black;
   		margin-bottom: 14px
	}
	
	.btn{
		text-decoration: none;
	    color: black;
	    padding: 7px;
	    background-color: lightgray;
	    border: 2px solid black;
	    margin-top: 8px;
	}

</style>
<script type="text/javascript">
	function getQuantity() {
		return document.getElementById('quantity').value;
	}

</script>
</head>
<body>
	<div style="display: flex; align-items: center; justify-content: center;">
		<div class="container">
			<a href="${pageContext.request.contextPath}/cart?action=show" style="font-size: 24px; align-self: flex-start; margin: 8px 0 0 8px">View Cart</a>
			<h1 style="margin: 0 0 16px 0;">List Of Product</h1>
			<div class="content">
				<c:forEach var="product" items="${ products }">
					<div class="item">
						<p>${product.name}</p>
						<img alt="" src="${pageContext.request.contextPath }/images/product/${product.url}" width="120">
						<p>
							Price: <fmt:formatNumber value="${product.price}" type="currency"/>
						
						</p>
						<input value="1" style="height: 30px; width: 50px; font-size: 16px" readonly="readonly">
						<a class="btn" href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}">Add to cart</a>
					</div>
				</c:forEach>
			</div>
		</div>
	
	</div>
</body>
</html>