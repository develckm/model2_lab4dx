<%@ page import="java.util.List" %>
<%@ page import="com.lab4dx.l05_mvc_ex.dto.ProductDto" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
  <title>상품리스트</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
  <h1 class="my-4">상품리스트</h1>
  <p class="text-end my-2">
    <a href="./productRegister.do">등록페이지</a>
  </p>

  <%
    Object productsObj =request.getAttribute("products");
    List<ProductDto> products=(List<ProductDto>)productsObj;
  %>
  <table class="table">
    <thead>
    <tr>
      <th>아이디</th>
      <th>이름</th>
      <th>가격</th>
      <th>상세</th>
    </tr>
    </thead>
    <tbody>
    <%for(ProductDto p : products){%>
    <tr>
      <td><%=p.getProductId()%></td>
      <td><%=p.getProductName()%></td>
      <td><%=p.getProductPrice()%></td>
      <td><a href="./productDetail.do?id=<%=p.getProductId()%>">이동</a></td>
    </tr>
    <%}%>
    </tbody>
  </table>

</div>
</body>
</html>