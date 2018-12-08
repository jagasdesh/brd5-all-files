<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
<h1>welcome</h1>
<h1><%=(String) request.getSession(false).getAttribute("username") %></h1>

<a href="maker.html">FILE UPLOAD</a>
<a href="viewpage">NEW USER</a>
</form>
</body>
</html>