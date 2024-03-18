<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body >
<jsp:include page="header.jsp"></jsp:include>

<h5>All Books</h5>
<div>
<a href="addbook" >Add New Book</a>
</div>
<table class="table table-striped">
	<tr>
	<th>Code</th> 
		<th>  Name</th>
		<th>  Price</th>
		<th>  Author</th>
		<th>  Action</th>
	
	</tr>
	<c:forEach var="book" items="${books}">
	<tr>
	<td>${book.code}</td>
		<td>${book.name}</td>
		<td>${book.price}</td>
		<td>${book.author}</td>
		<td> <a href="edit/${book.code}" class="btn btn-success">Update Book</a>
				<a href="delete/${book.code}" class="btn btn-danger" onclick="return deleteComfirmation()">Delete Book</a>
		
		</td>
	</tr>
	</c:forEach>
</table>
<script type="text/javascript">
function deleteComfirmation(){
	if(confirm("Do You really want to delete it?")){
		return true;
	}
	else{
		return false;
	}
}


 
</script>
</body>
</html>