<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<!--  -->


<%@include file="header.jsp"%>
<body>	
	<!--GITHUB LOGIC  -->
	<!-- <div class="container unauthenticated">
		<a href="/login">Login</a>
	</div>
	<div class="container authenticated" style="display: none">
		Logged in as: <span id="user"></span>
		<div>
			<button onClick="logout()" class="btn btn-primary">Logout</button>
		</div>
	</div>
 -->

	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
					<h4 class="modal-title">Select Your favourite City</h4>

				</div>
				<%-- <div class="modal-body">
					<p>Popular Cities</p>
					<form action="cityToSearch">
						<select name="cityToSearch">
							<option value="" disabled selected>--Select--</option>
							<jstl:forEach items="${cities}" var="city" varStatus="status">

								<option value="${city}">${city}</option>
							</jstl:forEach>
						</select>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

				</div> --%>
			</div>
		</div>
	</div>


</body>

<!--  GITHUB-->
<!-- <script>
	$.get("/user", function(data) {
		$("#user").html(data.userAuthentication.details.name);
		$(".unauthenticated").hide()
		$(".authenticated").show()
	});

	var logout = function() {
		$.post("/logout", function() {
			document.location.href = "http://localhost:9090";
			$("#user").html('');
			$(".unauthenticated").show();
			$(".authenticated").hide();
		})
		return true;
	}
</script> -->
</html>