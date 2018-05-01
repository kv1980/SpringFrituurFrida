<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>


<!doctype html>
<html lang='nl'>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='spel'/>
	</c:import>
</head>
<body>
	<c:import url='/WEB-INF/JSP/menu.jsp'/>
	<h1>Zoek de friet</h1>
	<c:url var='url' value='/spel'/>
	<form action='${url}' method='post'>
		<c:forEach var='deur' items='${deuren}' varStatus='status'>
			<button type='submit' name='index' value='${status.index}'>
				<c:choose>
					<c:when test='${deur.open}'>
						<c:choose>
							<c:when test='${deur.metFrietjes}'>
								<img src='<c:url value="/images/gevonden.png"/>' alt='friet gevonden'>
							</c:when>
							<c:otherwise>
								<img src='<c:url value="/images/deuropen.png"/>' alt='deur open'>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe'>
					</c:otherwise>
				</c:choose>		
			</button>
		</c:forEach>	
	</form>
	<c:url value='/spel/nieuwspel' var='url'/>
	<form method='post' action='${url}'>
		<input type='submit' value='Nieuw spel'>
	</form>
</body>
</html>