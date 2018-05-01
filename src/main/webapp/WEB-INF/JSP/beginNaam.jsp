<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>

<!doctype html>
<html lang='nl'>
<vdab:head title='Snack (beginletters)'/>
<body>
	<vdab:menu/>
	<h1>Snacks (beginnaam)</h1>
	<c:url var='url' value='/snacks'/>
	<form:form action='${url}' modelAttribute='beginNaamForm' method='get'>
		<form:label path='beginNaam'>Begin van de naam:<form:errors path='beginNaam'/></form:label>
		<form:input path='beginNaam' autofocus='autofocus' required='required'/>
		<input type='submit' value='Zoeken'/>
		<form:errors/>
	</form:form>
	<c:if test='${not empty snacks}'>
		<ul>
			<c:forEach var='snack' items='${snacks}'>
				<spring:url value='snacks/{id}/wijzigen' var='url'>
					<spring:param name='id' value='${snack.id}'/>
				</spring:url>	
				<li>
					<a href='${url}'>${snack.naam}</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>