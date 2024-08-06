<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/includes/cacheControl.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ID 찾기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/findID.css">
</head>
<body>
<c:import url="/topNoneNav.jsp" />

<section>
    <div class="container">
        <h2>비밀번호 찾기</h2>
        <form action="${pageContext.request.contextPath}/findPass" method="post">
            <div class="form-group">
                <label for="mid">ID:</label>
                <input type="text" id="mid" name="mid" value="${mid}" required>
            </div>
            <div class="form-group">
                <label for="mname">이름:</label>
                <input type="text" id="mname" name="mname" required>
            </div>
            <div class="form-group">
                <label for="memail">이메일:</label>
                <input type="email" id="memail" name="memail" required>
            </div>

            <button type="submit" class="btnPass">비밀번호 인증번호 받기</button>
                <p>${message}</p>

            <div>
                <label>인증번호</label>
                <input type="text" id ="auth" name="auth" >
            </div>
            <button type="submit" class="btnAuth">인증받기 </button>
        </form>
    </div>
</section>

<c:import url="/bottom.jsp" />