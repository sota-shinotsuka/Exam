<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<%-- EL ${}の中身を出力する --%>
<%-- 出力する変数は、自動的にリクエスト属性・セッションから参照される --%>
<%-- オブジェクトの場合、メソッドを使わず直接フィールドにアクセスできる --%>
<p>${product.id}:${product.name}:${product.price}</p>
<p>${data}</p>

<%-- ${}の中身は「文字列」として出力される --%>
<%-- オブジェクトの場合は、暗黙的にtoStringメソッドが呼ばれる --%>
<p>${product}</p>

<%-- メソッドの実行結果も出力できる --%>
<p>${product.getTaxPrice()}</p>

<%@include file="../footer.html"%>