<%@ page contentType='text' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html">
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name="title" value="Frituur Frida voorkeurtaal"/>
	</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp'/>
	De voorkeurtaal van Frituur Frida is 
	${isNL?"Nederlands":"geen Nederlands"}.
</body>
</html>