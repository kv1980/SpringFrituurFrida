<%@ page contentType='text' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html">
<html lang='nl'>
<vdab:head title='voorkeurtaal'/>
<body>
	<vdab:menu/>
	De voorkeurtaal van Frituur Frida is 
	${isNL?"Nederlands":"geen Nederlands"}.
</body>
</html>