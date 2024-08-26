<%@ page import="java.util.List" %>
<%@ page import="com.lab4dx.l05_mvc_ex.dto.ProductDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="my-4">상품 수정</h1>
    <p class="text-end my-2">
        <a href="./productRegister.do">등록페이지</a>
    </p>

    <%
        Object productObj=request.getAttribute("product");
        ProductDto product=(ProductDto) productObj;
    %>
    <form action="./productModify.do" method="post">
        <div class="form-group mb-2">
            <label for="id">아이디</label>
            <input type="text" value="<%=product.getProductId()%>" readonly
                   class="form-control" name="id" id="id" aria-describedby="helpId" placeholder="">
            <small id="helpId" class="form-text text-muted">pk는 수정할 수 없습니다.</small>
        </div>
        <div class="form-group mb-2">
            <label for="name">이름</label>
            <input type="text" value="<%=product.getProductName()%>"
                   class="form-control" name="name" id="name" aria-describedby="helpName" placeholder="">
            <small id="helpName" class="form-text text-muted">꼭입력해 주세요</small>
        </div>
        <div class="form-group mb-2">
            <label for="price">가격</label>
            <input type="text" value="<%=product.getProductPrice()%>"
                   class="form-control" name="price" id="price" aria-describedby="helpPrice" placeholder="">
            <small id="helpPrice" class="form-text text-muted">100000</small>
        </div>
        <div class="form-group text-end">
            <a href="./productRemove.do?id=<%=product.getProductId()%>" class="btn btn-outline-danger">삭제</a>
            <button type="reset" class="btn btn-outline-warning">초기화</button>
            <button type="submit" class="btn btn-outline-primary">제출</button>
        </div>
    </form>
</div>
</body>
</html>
