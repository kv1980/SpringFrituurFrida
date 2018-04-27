<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<!doctype html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='Snacks (beginnaam)'/>
	</c:import>
</head>
<body>
	<h1>Snacks (beginnaam)</h1>
	<c:url var='url' value='snacks'/>
	<form:form action='${url}' modelAttribute='beginNaamForm' method='get'>
		<form:label path='beginNaam'>Begin van de naam:</form:label>
		<form:input path='beginNaam' autofocus='autofocus'/>
		<input type='submit' value='Zoeken'/>
		<form:errors/>
	</form:form>
	<c:if test='${not empty snacks}'>
		<ul>
			<c:forEach var='snack' items='${snacks}'>
				<li>${snack.naam}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>