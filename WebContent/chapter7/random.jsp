<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../header.html"%>

<%
int x = (int) (Math.random() * 4);
String[] unsei = {"大吉", "中吉", "吉", "凶"};
%>

<h1>おみくじアプリ</h1>
<p>あなたの今日の運勢は</p>
<h2><%=unsei[x] %>です！</h2>

<%@include file ="../footer.html"%>