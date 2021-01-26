<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>JSP Exercises</h1>

<%--<p><%= out.println(LocalDateTime.now())%></p>--%>
<h2>out does work to print out directly to the page!</h2>
<p><% out.println(LocalDateTime.now()); %></p>
<h2>And so does with a scriptlet</h2>
<p><%= LocalDateTime.now() %>
</p>
<h2>System.out is legal but we don't see output in the page. Check your logs!</h2>
<p><% System.out.println(LocalDateTime.now());%></p>
</body>
</html>