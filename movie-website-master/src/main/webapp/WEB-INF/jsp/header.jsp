<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookMyMovie</title>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="webjars/jquery/jquery.min.js"></script>
<script src="../../../js/script.js"></script>
<link rel="stylesheet" href="../../../css/movie.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- <script type="text/javascript">
	$(document).ready(function() {
		var dialogShown = localStorage.getItem('dialogShown')

		if (!dialogShown) {
			$(window).load(function() {
				$("#myModal").modal('show');
				localStorage.setItem('dialogShown', 1)
			});
		} else {
			$("#myModal").hide();
		}
	});
</script> -->
</head>
<header>
    <div class="container-fluid">   
        <div class="row">
            <div class="col-sm-4">
                <img alt="logo" src="../../images/bookmymovielogo.png">
            </div>
            <div class="col-sm-6">
                <center>
	<h2>Select City:</h2>
	<jstl:forEach items="${cities}" var="city" varStatus="status">
		<a href="cityToSearch?cityToSearch=${city}">${city}</a><br/>
	</jstl:forEach>
</center>  
            </div>
        </div>
    </div>
</header>
</html>