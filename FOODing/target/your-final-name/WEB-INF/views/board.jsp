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
        <h1>${board.bname}</h1>
        <button><a href="${pageContext.request.contextPath}/write">글쓰기</a></button>
        <c:choose>
        <c:when test="${writes==null}">
            <p>게시물이 존재하지 않습니다.</p>
        </c:when>
        <c:otherwise>
        <table>
            <thead>
                <td>번호</td>
                <td>글제목</td>
                <td>글쓴이</td>
                <td>작성날짜</td>
            </thead>
            <tbody>

            <c:forEach var="write" items="${writes}">
                    <tr>
                        <td>${write.wno}</td>
                        <td><a href="#">${write.wtitle}</a></td>
                        <td>${write.member.mnick}</td>
                        <td>${write.wdate}</td>
                    </tr>
            </c:forEach>
            </c:otherwise>
            </c:choose>
            </tbody>
        </table>
        <input type="text">
        <button>검색</button>
        <button>수정</button>
    </div>
</section>
<c:import url = "/bottom.jsp" />