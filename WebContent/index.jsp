<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Entry</title>
</head>
<body>
<form action="BookEntry" method="post">
<pre>
Book name:
<input type="text" name="bookname" required>
Book id:
<input type="text" name="bookid" required>
Author name:
<input type="text" name="authorname">
Subject:
<input type="text" name="subject" required>

<input type="submit" value="submit">
</pre>
</form>
</body>
</html>