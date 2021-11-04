<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- include header jsp dynamically --%>

<jsp:include page="jsp/header.jsp" />

<center>
	<h3>
		<spring:message code="welcome.to.pizzashoppingcart"></spring:message>
	</h3>
	<br>
	<p>
		<spring:message code="pizza.online.store.desc"></spring:message>
	</p>
	<h3>
		<a href="${pageContext.request.contextPath}/users">Click Here To Begin</a> <br> <br>
	</h3>
</center>
<%-- include footer html tatically --%>
<%@ include file="resources/html/footer.html"%>