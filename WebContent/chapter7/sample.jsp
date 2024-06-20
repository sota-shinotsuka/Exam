<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.html"%>

<%
int x = 10;
int y = 20;
String[] values = {"1", "2", "3"};
String[] strs = {"xxx", "yyy", "zzz"};
%>

<p>Hello!</p>
<p>こんにちは！</p>

<select>
<% for(int i=0; i<values.length; i++) {
		String s="";
		if(i==0) {
			s="selected";
		}
%>

<option value="<%= values[i] %>" <%= s %> > <%= strs[i] %></option>

<% } %>
</select>

<%@include file="../footer.html"%>