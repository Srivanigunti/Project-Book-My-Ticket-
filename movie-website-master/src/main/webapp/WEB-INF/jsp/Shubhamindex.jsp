<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Demo</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<base href="/" />
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/webjars/bootstrap/js/bootstrap.min.js"></script>


<script type="text/javascript" src="/webjars/js-cookie/js.cookie.js"></script>
</head>
<body>
	<form action="cityToSearch">
		<h1>Book My Movie</h1>
		City: <input type="search" name="cityToSearch"> <br/><br/>
		<input type="submit" value="search">
	</form>
<br>	
	
	
	<div class="container"></div>
	<div class="container unauthenticated">
		With github: <a href="/login">click here</a>
	</div>
	<div class="container authenticated" style="display: none">
		Logged in as: <span id="user"></span>
	</div>

	<div class="container authenticated"> 	
		Logged in as: <span id="user"></span>
		<div>
			<button onClick="logout()" class="btn btn-primary">Logout</button>
		</div>
	</div>

	<!-- Spring Security has built in support for a /logout endpoint which will do the right thing for us 
	(clear the session and invalidate the cookie).
 -->

	<script type="text/javascript">
		$.get("/user", function(data) {
			$("#user").html(data.userAuthentication.details.name);
			$(".unauthenticated").hide()
			$(".authenticated").show()
		});

		var logout = function() {
			$.post("/logout", function() {
				$("#user").html('');
				$(".unauthenticated").show();
				$(".authenticated").hide();
			})
			return true;
		}
	</script>
</body>
</html>