<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>

<style type="text/css">
	.container{
		width: 100%;
		height: 100vh;
		display: flex;
		align-items: center;
		justify-content: center;
		
	}
	
	.content{
		display: flex;
		flex-direction: column;
		border: 10px solid 	lightgray;
		width: 500px;
		align-items: center;
		justify-content: center;
		padding: 24px
	}
	
	.input-group {
		width: 100%;
		
		
	}
	
	.input {
		width: 100%;
		height: 30px;
		font-size: 17px;
		padding: 8
	} 
	

</style>
<script type="text/javascript">
	window.onload = function () {
		const day = document.getElementById('day');
		const month = document.getElementById('month');
		const year = document.getElementById('year');
		
		for (let i = 1; i < 32; i++) {
			const option = document.createElement('option');
			option.textContent = i;
			option.value = i;
			day.appendChild(option);
		}
		
		for (let i = 1; i < 13; i++) {
			const option = document.createElement('option');
			option.textContent = i;
			option.value = i;
			month.appendChild(option);
		}
		
		const currentYear = new Date().getFullYear();
		for (let i = 1900; i <= currentYear ; i++) {
			const option = document.createElement('option');
			option.textContent = i;
			option.value = i;
			year.appendChild(option);
		}
	}
	
	
	
</script>
</head>
<body>
	<div class="container">
		<form class="content" action="user-servlet" method="GET">
			<h2>User Registration Form</h2>
			<div style="display: flex; flex-direction: column; gap: 20px; ">
				<div class="input-group">
					<input placeholder="First Name" name="firstName" type="text" style="height: 30px; font-size: 17px; padding: 8">
					<input placeholder="Last Name" name="lastName" type="text" style="height: 30px; font-size: 17px; padding: 8">
				</div>
				<div class="input-group">
					<input placeholder="Your Email" name="email" type="email" class="input">
				</div>
				<div class="input-group">
					<input placeholder="Re-enter Email" name="reEmail" type="email" class="input">
				</div>
				<div class="input-group">
					<input placeholder="New Password" name="password" type="password" class="input">
				</div>
				
				<div>
					<label style="color: gray; font-size: 17px">Birthday</label>
					<div style="margin-top: 5px"> 
						<select id="day" style="margin-right: 8px; height: 30px;">
							<option value="">Day</option>
							
						</select>
						<select id="month" style="margin-right: 8px; height: 30px;">
							<option value="">Month</option>
							
						</select>
						<select id="year" style="height: 30px;">
							<option value="">Year</option>
							
						</select>
					</div>
				</div>
				<div>
					<span>
						<input type="radio" id="female" name="gender" value="female">
						<label for="female" style="font-size: 18px">Female</label>
					</span>
					<span>
						<input type="radio" id="male" name="gender" value="male">
						<label for="male" style="font-size: 18px">Male</label>			
					</span>
				</div>
				<input type="submit" style=" height: 40px; background-color: lightblue; margin: 16px 0 16px 0">
			</div>
		</form>
	</div>
</body>
</html>