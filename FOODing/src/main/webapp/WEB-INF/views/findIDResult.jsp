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

<section class="findID-section">
    <h2>ID 찾기</h2>

    <p>${message}</p>
    <a href="${pageContext.request.contextPath}/login">로그인</a>
</section>

<c:import url="/bottom.jsp" />