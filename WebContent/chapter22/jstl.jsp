<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- c:set ... 変数への代入 i=0 --%>
<c:set var="i" value="0" />

<%-- forEach ... for(p : list)の役割 --%>
<c:forEach var="p" items="${list}">

	${p.id}:${p.name}:${p.price}

	<%-- c:choose ... if~elseの役割 --%>
	<c:choose>
		<c:when test="${ p.price>100 }">高い</c:when>
		<c:otherwise>安い</c:otherwise>
	</c:choose>

	<%-- c:if ... 条件式がTrueだったら出力 elseは書けない！ --%>
	<c:if test="${ i%2==1 }">
		<br>
	</c:if>

	<%-- i = i+1 --%>
	<c:set var="i" value="${i+1}" />

	</c:forEach>

<%@include file="../footer.html"%>