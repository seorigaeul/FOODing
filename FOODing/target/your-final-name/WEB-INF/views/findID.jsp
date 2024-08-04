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
    <form action="${pageContext.request.contextPath}/findID" method="post">
        <table>
            <tr>
                <td><label for="mname">이름 : </label></td>
                <td><input type="text" id="mname" name="mname" required></td>
            </tr>
            <tr>
                <td><label for="memail">이메일 : </label></td>
                <td><input type="text" id="memail" name="memail" required></td>
            </tr>
            <tr>
                <td><label for="mphone">전화번호 : </label>
                <td><input type="text" id="mphone" name="mphone" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="ID 찾기"></td>
            </tr>
        </table>
    </form>
</section>

<c:import url="/bottom.jsp" />