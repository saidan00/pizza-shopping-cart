<%--
This page willl be included in all jsp pages.
It uses the css and js files to be used in Pizza Online Store application.
--%>

<!DOCTYPE html>
<html>
<head>
<title>Pizza Online Store</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="pizzashoppingcart, shopping cart">
<!--  include css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pizzashoppingcart.css">
<%-- include js --%>
<script
	src="${pageContext.request.contextPath}/resources/js/pizzashoppingcart.js">
	
</script>
</head>
<body>
	<br>
	<%-- JSP Scriptlets and Expression --%>
	<%
 String userName = (String) session.getAttribute("userName");
if (userName != null)
%>
	<p style="text-align: right; color: maroon; width: 80%;">
		Welcome
		<%=userName%>
		<%--Call login servlet which will invalidate the user session and redirect to welcome page --%>
		<a href="${pageContext.request.contextPath}/Login">Logout</a>
	</p>
	<%
}
%><br>
	<br>
</body>
</html>