<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<%-- ページ内で使用するモジュールをインポート --%>
<%@page import="bean.Product, java.util.List" %>

<%
// 本来は教科書準拠で一行で記述する
// リクエスト属性から「list」という名前のデータを取得
// 　戻り値はObject型＝すべてのクラスのスーパークラス
// 　　　　　　　　　＝どんなクラスでも保持できるようにするため
Object obj = request.getAttribute("list");

// ObjectをList<Product>として扱うために、キャストを行う
List<Product> list=(List<Product>)obj;
%>

<% for (Product p : list) { %>
	<%=p.getId() %>:<%=p.getName() %>:<%=p.getPrice() %><br>
<% } %>

<%@include file="../footer.html"%>