<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<%
// servletから渡された、data-zという名前のデータを取得
// 保存されたObject型のデータをキャストする必要がある
int z = (Integer)request.getAttribute("data-z");
%>

<p>フォワード先のJSPファイルです。</p>
<p>zの値は<%= z %>です。</p>

<form action="forward" method="post">
	<input type="text" name="user">
	<input type="submit" value="確定">
</form>

<%@include file="../footer.html"%>