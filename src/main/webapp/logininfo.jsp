<html>
<head>
    <meta charset="utf-16">
    <title>Login view</title>
    <link rel="stylesheet" href="styles/login.css" type="text/css">
</head>
<body>
<h1>ВАХАХАХА!</h1>
<p>Пусть ваши данные увидят все!</p>
<label>Login:</label>
<span><%= request.getParameter("login")%></span><br>
<label>Password:</label>
<span><%= request.getParameter("password")%></span><br>
</body>
</html>