<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='Woordspel'/>
	</c:import>
</head>
<body>
	<h1>Saus raden</h1>
	<c:choose>
		<c:when test="${woordspel.verloren}">U bent verloren, de saus was ${woordspel.teRadenSaus}.</c:when>
		<c:when test="${woordspel.gewonnen}">U bent gewonnen, de saus was ${woordspel.teRadenSaus}.</c:when>
		<c:otherwise>
			Te raden saus: ${woordspel.reedsGeradenLetters}
			<c:url value='/sauzen/spel' var='url'/>
			<form:form action='${url}' method='post' id='radenform' modelAttribute="woordspelForm">
				<form:label path='letter'>letter:</form:label>
				<form:input path='letter' size='1' maxlength='1' autofocus='autofocus' required='required'/>
				<input type='submit' value='Raden' id='radenknop'>
			</form:form>
			<script>
				document.getElementById('radenform').onsubmit = function() {
					document.getElementById('radenknop').disabled = true;
				};
			</script>
		</c:otherwise>
	</c:choose>
	<c:url value='/sauzen/spel/nieuwspel' var='url'/>
	<form method='post' action='${url}'>
		<input type='submit' value='Nieuw spel'>
	</form>
	<img src="<c:url value='/images/${woordspel.aantalVerkeerdePogingen}.png'/>" alt='${woordspel.aantalVerkeerdePogingen} verkeerde beurten'>
</body>
</html>
				