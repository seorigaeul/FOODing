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

        <h1>글읽기</h1>
        <table>
            <tr>
                <td colspan="3">글쓴이 : ${write.member.mnick}</td>
            </tr>
            <tr>
                <td>글 번호</td>
                <td>${write.wno}</td>
            </tr>
            <tr>
                <td>글 제목</td>
                <td><h2>${write.wtitle}</h2></td>
            </tr>
            <tr>
                <td>작성날짜</td>
                <td>${write.dateToString}</td>
            </tr>
            <tr>
                <td>글 내용</td>
                <td colspan="3">${write.wcontent}</td>
            </tr>
        </table>

        <div class="button">
            <button type="submit">목록</button>
            <c:choose>
                <c:when test="${canEdit}">
                    <a href="${pageContext.request.contextPath}/writeEdit?wno=${write.wno}">수정</a>
                    <button type="submit">수정</button>
                    <button type="submit">삭제</button>
                </c:when>
                <c:otherwise>
                    <p>수정 권한이 없습니다.</p>
                </c:otherwise>
            </c:choose>

        </div>

    </div>
</section>
<c:import url = "/bottom.jsp" />