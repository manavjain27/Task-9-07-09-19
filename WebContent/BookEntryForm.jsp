
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Book Entry</h2>
	<hr>
	
	<form method="post" action="BookEntry">
	<table>
	<tr>
	<td>Enter Book Title</td>
	<td><input type="text" name="title"/>
	</tr>
	
	<tr>
	<td>Enter Book Subject</td>
	<td><input type="text" name="subject"/>
	</tr>
	
	<tr>
	<td>Enter Book Price</td>
	<td><input type="text" name="price"/>
	</tr>
	
	<tr>
	<td></td>
	<td><input type="submit" value="Add Book"/>
	</tr>
	</table>
	
	<hr>
	<br>
	<a href="BookSearch.jsp">Book Search By Subject</a>
	<br>
	<hr>
	<a href="BookShow">Book List</a>
	</form>
</body>
</html>