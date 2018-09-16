$(document).ready(function() {
	$("#submit").click(function(e)
			{
			e.preventDefault();
			//remove cookie
			$.removeCookie("role", { path: '/' });
			$.removeCookie("jwt", { path: '/' });
			localStorage.removeItem("loggedIn");

			//redirect
			window.location.href = "index.html"
			}
	);
	
	$("#logout-link").click(function(e)
			{
			e.preventDefault();
			//remove cookie
			$.removeCookie("role", { path: '/' });
			$.removeCookie("jwt", { path: '/' });
			localStorage.removeItem("loggedIn");

			//redirect
			window.location.href = "index.html"
			}
	);
});