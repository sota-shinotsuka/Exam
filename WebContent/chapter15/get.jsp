<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<p>商品IDを入力してください。</p>

<form action="get" method="post">
	<input type="text" name="id">
	<input type="submit" value="検索">
</form>

<%@include file="../footer.html"%>