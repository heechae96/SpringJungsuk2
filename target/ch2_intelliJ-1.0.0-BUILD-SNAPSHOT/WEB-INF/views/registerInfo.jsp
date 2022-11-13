<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        div {
            width: auto;
            height: auto;
            border: 3px solid dodgerblue;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div>
    <h1>id=${user.id}</h1>
    <h1>pwd=${user.pwd}</h1>
    <h1>name=${user.name}</h1>
    <h1>email=${user.email}</h1>
    <h1>birth=${user.birth}</h1>
    <h1>hobby=${user.hobby}</h1>
    <h1>sns=${user.sns}</h1>
</div>
</body>
</html>