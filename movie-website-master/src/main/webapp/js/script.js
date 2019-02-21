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