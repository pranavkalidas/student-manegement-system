<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student | Login</title>
<link rel="stylesheet" type="text/css" href="signup.css">
</head>
<body>
	<div class="cont">
		<div class="form sign-in">
			<form action="Signin" method="post">
				<h2>Sign In</h2>
				<label> <span>Email Address</span> <input type="email"
					name="email">
				</label> <label> <span>Password</span> <input type="password"
					name="password">
				</label>
				<button class="submit" type="submit">Sign In</button>
				<p class="forgot-pass">Forgot Password ?</p>
			</form>
		</div>
		<div class="sub-cont">
			<div class="img">
				<div class="img-text m-up">
					<h2>New here?</h2>
					<p>Sign up</p>
				</div>
				<div class="img-text m-in">
					<h2>One of us?</h2>
					<p>If you already has an account, just sign in. We've missed
						you!</p>
				</div>
				<div class="img-btn">
					<span class="m-up">Sign Up</span> <span class="m-in">Sign In</span>
				</div>
			</div>
			<div class="form sign-up">
				<form action="Signup" method="post">
					<h2>Sign Up</h2>
					<label> <span>Name</span> <input type="text" name="name">
					</label> <label> <span>Email</span> <input type="email"
						name="email">
					</label> <label> <span>Password</span> <input type="password"
						name="password">
					</label> <label> <span>Confirm Password</span> <input
						type="password" name="passwordConfirm">
					</label>
					<button type="submit" class="submit">Sign Up Now</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="signup.js"></script>
</body>
</html>