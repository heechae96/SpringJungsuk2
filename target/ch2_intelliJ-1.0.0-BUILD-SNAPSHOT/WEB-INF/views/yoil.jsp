<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <h1>year = <%=request.getParameter("year")%></h1>--%>
<%--    <p>${year}년 ${month}월 ${day}일은 ${yoil}요일입니다.</p>--%>
<%--    getter와 setter를 만들어둬서 가능한것--%>
    <h1>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일입니다.</h1>
</body>
</html>
