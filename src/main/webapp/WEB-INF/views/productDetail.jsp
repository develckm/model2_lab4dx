<%@ page import="java.util.List" %>
<%@ page import="com.lab4dx.l05_mvc_ex.dto.ProductDto" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
  <title>상품상세</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
  <h1>상품상세</h1>
  <%
    Object productObj =request.getAttribute("product");
    ProductDto product=(ProductDto) productObj;
  %>
  <%=product%>
  <div class="card text-left">
    <div class="card-body">
      <h4 class="card-title">상품이름 : <%=product.getProductName()%></h4>
      <p class="card-text">상품번호 : <%=product.getProductId()%></p>
      <p class="card-text">상품가격 : <%=product.getProductPrice()%></p>
    </div>
  </div>
</div>
</body>
</html>