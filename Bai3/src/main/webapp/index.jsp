<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style type="text/css">
	* {
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box; 
	}
	
	body, html {
	    height: 100%; 
	   
	}
	
	.container {
		display: flex;
	    width: 100%; 
	    height: 100%;
	    border: 4px solid black; 
	    flex-direction: column;
	}
	
	.link{
		display: flex;
		border: 3px solid black;
		padding: 8px;
		justify-content: center;
		gap: 8px;
		font-weight: bold;
	}
	
	.link a {
		color: black;
		font-size: 20px;
		
	}
	
	.content{
		flex: 1;
	}
	
	.footer{
		display: flex;
	    justify-content: center;
	    font-weight: bold;
	    font-size: 18px;
	    padding: 8px;
	    border: 3px solid black;
	}
	
</style>
</head>
<body>
	<div class="container">
		<img alt="" src="${pageContext.request.contextPath}/images/logo.jpg" style="width: 100%"; height="150px">
		<div class="link">
			<a href="${pageContext.request.contextPath}/list">Danh sách tin tức</a>
			<p> | </p>
			<a href="${pageContext.request.contextPath}/add?action=showPage">Thêm tin tức mới</a>
			<p> | </p>
			<a href="${pageContext.request.contextPath}/manage?action=showPage">Chức năng quản lý</a>
		</div>
		<div class="content">
	
		</div>
		
		<div class="footer">
			<p>Trịnh NgocThai - 21096211 - DHKTPM17BTT</p>
		</div>
	</div>
</body>
</html>