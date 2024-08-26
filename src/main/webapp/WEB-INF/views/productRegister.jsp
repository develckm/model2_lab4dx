<%@ page import="java.util.List" %>
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
    <h1>상품 등록</h1>
    <form action="./productRegister.do" method="post">
        <div class="form-group mb-2">
            <label for="id">아이디</label>
            <input type="text" value=""
                   class="form-control" name="id" id="id" aria-describedby="helpId" placeholder="">
            <small id="helpId" class="form-text text-muted">중복되면 오류가 발생합니다.</small>
        </div>
        <div class="form-group mb-2">
            <label for="name">이름</label>
            <input type="text" value=""
                   class="form-control" name="name" id="name" aria-describedby="helpName" placeholder="">
            <small id="helpName" class="form-text text-muted">꼭입력해 주세요</small>
        </div>
        <div class="form-group mb-2">
            <label for="price">가격</label>
            <input type="text" value=""
                   class="form-control" name="price" id="price" aria-describedby="helpPrice" placeholder="">
            <small id="helpPrice" class="form-text text-muted">100000</small>
        </div>
        <div class="form-group text-end">
            <button type="submit" class="btn btn-outline-primary">제출</button>
        </div>
    </form>
</div>
</body>
</html>
