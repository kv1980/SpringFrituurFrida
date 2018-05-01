<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>

<!doctype html>
<html lang="nl">
	<vdab:head title='Sauzen'/>
	<body>
		<vdab:menu/>
    	<h1>Sauzen</h1>     
    	<c:forEach var='saus' items='${sauzen}'>
    		<div>
	    		<img class="sausFiguur" src='images/${saus.naam}.png' alt='${saus.naam}'> 
	    		<div class="sausTekst">
	    			<h2>${saus.naam}</h2>       
	    			ingrediënten:        
	    			<c:forEach var='ingrediënt' items='${saus.ingrediënten}'  varStatus='status'> 
	    		         	${ingrediënt}<c:if test='${not status.last}'>, </c:if>        
	    			</c:forEach><br>
	    		</div>    		
    		</div>       
    	</c:forEach> 
	</body>
</html>