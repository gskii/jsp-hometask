<html>
<head>
    <meta charset="utf-8">
    <title>Login page</title>
    <link rel="stylesheet" href="styles/login.css" type="text/css">
</head>
<body>
<h1><b>MailSender</b></h1>
<form action="mail" method="post">
    <label>To: </label>
    <input type="text" name="to" required><br>
    <label>Subject: </label>
    <input type="text" name="subject" required><br>
    <label>Content: </label>
    <input type="text" name="content" required><br>
    <label>&nbsp;</label>
    <input type="submit" value="Send" id="butget"><br>
    <label>
        Status: <%=request.getAttribute("status")%>
    </label>

</form>
</body>
</html>
