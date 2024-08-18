<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c"%>
<%@ include file="/WEB-INF/views/includes/cacheControl.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "UTF-8">
    <title>FOODing 모임 게시판</title>
</head>
<body>
<c:import url = "/top.jsp" />
<section>
    <c:forEach var="memberGroup" items="${leaderList}" varStatus="status">

    <h1>${memberGroup.group.gname} 게시판</h1>
    <table>
        <thead>
            <td>번호</td>
            <td>글제목</td>
            <td>글쓴이</td>
            <td>작성날짜</td>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>

    </table>
    </c:forEach>
</section>
<c:import url = "/bottom.jsp" />