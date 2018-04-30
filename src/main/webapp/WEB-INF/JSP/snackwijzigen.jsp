<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>

<!doctype html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='${snack.naam} wijzigen'/>
	</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp'/>
	<h1>${snack.naam} wijzigen</h1>
	<spring:url value='/snacks/{id}/wijzigen' var='url'>
		<spring:param name='id' value='${snack.id}'/>
	</spring:url>
	<form:form action='${url}' modelAttribute='snack' method='post' id='wijzigenForm'>
		<form:label path='naam'>Naam:<form:errors path='naam'/></form:label>
		<form:input path='naam' autofocus='autofocus' required='required'/>
		<form:label path='prijs'>Prijs:<form:errors path='prijs'/></form:label>
		<form:input path='prijs' required='required'/>
		<input type='submit' value='Opslaan' id='opslaanKnop'/>
		<form:errors/>
	</form:form>
	<script>
		document.getElementById('wijzigenForm').onsubmit = function() {
			document.getElementById('opslaanKnop').disabled = true;
		};
	</script>
</body>
</html>