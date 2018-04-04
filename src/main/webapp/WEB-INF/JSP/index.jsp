<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Frituur Frida welkom" />
</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp' />
	<h1>
		<c:choose>
			<c:when test='${reedsBezocht}'>Frituur Frida heet je terug welkom!</c:when>
			<c:otherwise>Welkom bij Frituur Frida</c:otherwise>
		</c:choose>
	</h1>
	<img class="groot" src="images/${openOfGesloten}.png">
	<h2>Adres</h2>
	${adres.straat} ${adres.huisNr}
	<br> ${adres.gemeente.postcode} ${adres.gemeente.naam}
</body>
</html>