<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1>URL rewriting exercises:</h1>
<h2>Viva Forever</h2>
<form action="left">
    <input type="hidden" name="leftName" value="Viva"/><br/>
    <input type="submit" value="Build Lyric Name"/>
</form>

<h2>Girl band store</h2>
<label>(Hint: User and password are equal and the user is admin...)</label>
<form action="LoginGirlBandRecordStoreServlet" method="post">
    Username: <input type="text" name="username" value="admin">
    <br>
    Password: <input type="password" name="password" value="admin">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>