<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechBooks - Online Books Store</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div class="center">
		<div class="book-group">
			<h2>New Books:</h2>
			<c:forEach items="${listNewBooks}" var="book">
				<div class="book-list-category-index">
					<div>
						<a href="view_book?id=${book.bookId}"> 
						<img class="book-small"
							src="data:image/jpg;base64,${book.base64Image}" />
						</a>
					</div>
					<div>
						<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
						</a>
					</div>
					
					<div>
						<jsp:directive.include file="book_rating.jsp" />
					</div>
					
					<div>
						<i>by ${book.author}</i>
					</div>
					<div>
						<b>$${book.price}</b>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="next-row">
			<h2>Best-Selling Books:</h2>
		</div>
		<div class="next-row">
			<h2>Most-favored Books:</h2>
		</div>
		
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>