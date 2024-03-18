<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  .error{
  	color:red;
  }
  </style>
</head>
<body class="text-bg-info">
<jsp:include page="header.jsp"></jsp:include>

<div style="color:red">${errors}</div>
	<h5>New Book Info</h5>
	<form:form action="/bookmanagement/addbook" method="post" modelAttribute="book">
	
	

    
    
	<div class="form-floating mb-3 mt-3">
	<form:input type="text" class="form-control"  placeholder="Enter Code" path="code"/>
	<form:label path="code" >Book Code</form:label>
	<form:errors path="code" cssClass="error"></form:errors>
	</div>
	<div class="form-floating mb-3 mt-3">
	<form:input type="text"  class="form-control" placeholder="Enter Name" path="name"/>
		<form:label path="name">Book Name</form:label>
		<form:errors path="name" cssClass="error"></form:errors>
	
	</div>
	<div class="form-floating mb-3 mt-3">
	<form:input type="number"  class="form-control" placeholder="Enter Price" path="price"/>
		<form:label path="price">Price</form:label>
		<form:errors path="price" cssClass="error"></form:errors>
		
	
	</div>
	<div class="form-floating mb-3 mt-3">
	
		<form:label path="author_id">Author</form:label>
		<form:select path="author_id">
			<form:option value="0">Select Author</form:option>
			<c:forEach var="author" items="${authors}">
				<form:option value="${author.id}">${author.name }</form:option>
				</c:forEach>
		
		</form:select>
		<form:errors path="author" cssClass="error"></form:errors>
		
	
	</div>
	<div>
	<input type="submit" class="btn btn-primary" value="Create Book" id="showAlertButton"></div>
	</form:form>
	
	
</body>
</html>