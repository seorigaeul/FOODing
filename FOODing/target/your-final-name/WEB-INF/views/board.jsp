<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c"%>
<%@ include file="/WEB-INF/views/includes/cacheControl.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "UTF-8">
    <title>FOODing 모임 게시판</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css">

</head>
<body>
<c:import url = "/top.jsp" />
<section class="board-section">
    <div class="board-container">
    <c:forEach var="board" items="${board}">
        <h1>${board.bname}</h1>
        <button>글쓰기</button>
    </c:forEach>
        <table>
            <thead>
                <td>번호</td>
                <td>글제목</td>
                <td>글쓴이</td>
                <td>작성날짜</td>
            </thead>
            <tbody>
            <c:forEach var="write" items="${write}">
                    <tr>
                        <td>${write.wno}</td>
                        <td>${write.wtitle}</td>
                        <td>${write.wcontent}</td>
                        <td>${write.wdate}</td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="text">
        <button>검색</button>
        <button>수정</button>
    </div>
</section>
<c:import url = "/bottom.jsp" />