<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý tin tức</title>
<style type="text/css">
	* {
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box; /* Đảm bảo padding và viền không làm tăng kích thước phần tử */
	}
	
	body, html {
	    height: 100%; /* Đảm bảo body và html có chiều cao 100% */
	   /*  overflow-x: hidden; */ /* Ẩn scroll ngang */
	}
	
	.container {
		display: flex;
	    width: 100%; /* Sử dụng 100% thay vì 100vw để tránh cộng thêm margin/scroll */
	    height: 100%; /* Chiều cao cũng 100% */
	    border: 4px solid black; /* Border có thể gây scroll, nhưng sẽ được tính trong kích thước nhờ box-sizing */
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
		<div class="content" style="padding: 20px; background-color: #f9f9f9;">
		    <h1 style="margin-bottom: 20px;">Quản lý tin tức</h1>
		    <table border="1" style="width: 100%; border-collapse: collapse;">
		        <tr>
		            <th style="padding: 10px; background-color: #007bff; color: white;">Mã danh mục</th>
		            <th style="padding: 10px; background-color: #007bff; color: white;">Mã tin tức</th>
		            <th style="padding: 10px; background-color: #007bff; color: white;">Liên kết</th>
		            <th style="padding: 10px; background-color: #007bff; color: white;">Nội dung tin tức</th>
		            <th style="padding: 10px; background-color: #007bff; color: white;">Tiêu đề</th>
		            <th style="padding: 10px; background-color: #007bff; color: white;">Actions</th>
		        </tr>
		        <c:forEach var="tinTuc" items="${requestScope.dsTinTuc}">
		            <tr>
		                <td style="padding: 10px;">${tinTuc.danhMuc.maDM}</td>
		                <td style="padding: 10px;">${tinTuc.maTT}</td>
		                <td style="padding: 10px;">${tinTuc.lienKet}</td>
		                <td style="padding: 10px;">${tinTuc.noiDungTT}</td>
		                <td style="padding: 10px;">${tinTuc.tieuDe}</td>
		                <td style="padding: 10px;">
		                    <a href="${pageContext.request.contextPath}/manage?action=remove&id=${tinTuc.maTT}" style="color: #007bff; text-decoration: none;">Remove</a>
		                </td>
		            </tr>
		        </c:forEach>
		    </table>
		</div>

		
		<div class="footer">
			<p>Trần Vũ Duy - 21026331 - DHKTPM17ATT</p>
		</div>
	</div>
</body>
</html>