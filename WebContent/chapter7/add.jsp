<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.html"%>

<%-- <%! ~~~ %>：関数の定義 --%>
<%!
int add(int a, int b){
	return a+b;
}
%>

<p>1+2=<%=add(1,2) %></p>
<p>3+4=<%=add(3,4) %></p>

<%@include file="../footer.html"%>