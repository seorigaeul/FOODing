
<%
    // 캐시 무효화 헤더 설정
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    if(request.getProtocol().equals("http/1.1")) {
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    }


%>