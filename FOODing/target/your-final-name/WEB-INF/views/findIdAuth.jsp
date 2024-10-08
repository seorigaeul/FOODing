<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/includes/cacheControl.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/findPassAuth.css">
</head>
<body>
<c:import url="/topNoneNav.jsp" />

<section>
    <div class="container">
        <h2>비밀번호 찾기</h2>
        <form action="${pageContext.request.contextPath}/findPassAuth" method="post">
            <div class="form-group">
                <label for="mid">ID:</label>
                <input type="text" id="mid" name="mid" required>
            </div>
                <p>${message}</p>


            <button type="submit" class="btnPass">다음</button>
        </form>
    </div>
</section>

<c:import url="/bottom.jsp" />