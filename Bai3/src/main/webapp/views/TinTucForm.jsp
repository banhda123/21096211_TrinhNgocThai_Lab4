<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm tin tức</title>
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
			<a href="${pageContext.request.contextPath}/add">Thêm tin tức mới</a>
			<p> | </p>
			<a href="${pageContext.request.contextPath}/manage?action=showPage">Chức năng quản lý</a>
		</div>
		<div class="content" style="padding: 20px; background-color: #f9f9f9;">
	    <form action="${pageContext.request.contextPath}/add" method="POST" style="margin-bottom: 20px;">
	        <p style="font-size: 20px; color: red; font-style: italic;">${requestScope.error}</p>
	        <div style="margin-bottom: 15px;">
	            <label for="tenDanhMuc" style="font-weight: bold; margin-right: 10px;">Tên danh mục</label>
	            <select name="tenDM" id="tenDanhMuc" style="padding: 5px; border-radius: 5px; border: 1px solid #ddd; width: 100%;">
	                <c:forEach var="danhMuc" items="${requestScope.dsDanhMuc}">
	                    <option value="${danhMuc.tenDanhMuc}">
	                        ${danhMuc.tenDanhMuc}
	                    </option>
	                </c:forEach>
	            </select>
	        </div>
	        <div style="margin-bottom: 15px;">
	            <label for="lienKet" style="font-weight: bold; margin-right: 10px;">Liên Kết</label>
	            <input type="text" placeholder="Liên kết" name="lienKet" id="lienKet" style="padding: 5px; border-radius: 5px; border: 1px solid #ddd; width: 100%;" />
	        </div>
	        <div style="margin-bottom: 15px;">
	            <label for="noiDung" style="font-weight: bold; margin-right: 10px;">Nội dung tin tức</label>
	            <textarea rows="7" cols="50" id="noiDung" name="noiDung" placeholder="Nội dung tin tức" style="padding: 5px; border-radius: 5px; border: 1px solid #ddd; width: 100%;"></textarea>
	        </div>
	        <div style="margin-bottom: 15px;">
	            <label for="tieuDe" style="font-weight: bold; margin-right: 10px;">Tiêu Đề</label>
	            <input type="text" placeholder="Tiêu đề" name="tieuDe" id="tieuDe" style="padding: 5px; border-radius: 5px; border: 1px solid #ddd; width: 100%;" />
	        </div>
	        <div>
	            <input type="submit" value="Thêm" style="padding: 5px 10px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">
	        </div>
	    </form>
	</div>

		<div class="footer">
			<p>Trần Vũ Duy - 21026331 - DHKTPM17ATT</p>
		</div>
	</div>
</body>
</html>