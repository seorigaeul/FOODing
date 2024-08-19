<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c"%>
<%@ include file="/WEB-INF/views/includes/cacheControl.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "UTF-8">
    <title>FOODing 모임 게시판</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/write.css">

</head>
<body>
<c:import url = "/top.jsp" />
<section class="write-section">
    <div class="write-container">
        <h1>글쓰기</h1>
        <table>
            <tr>
                <td>아이디 : ${member}</td>
            </tr>
            <tr>
                <td><input type="text" value="글 제목"></td>
            </tr>
            <tr>
                <td><textarea>글 내용</textarea></td>
            </tr>

        </table>
        <button>글쓰기</button>
    </div>
</section>
<c:import url = "/bottom.jsp" />