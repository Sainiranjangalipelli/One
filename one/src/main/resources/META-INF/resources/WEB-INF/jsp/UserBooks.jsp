		<%@ include file="common/header.jspf" %>
		
		<%@ include file="common/navigation.jspf" %>
		
		<div class="container">
		<!--<div>Welcome ${name}</div>
		<hr>-->
		<H1>Your books</H1>
			<table class="table">
				<thead>
					<tr>
						<!---<th>id</th>-->
						<th>bookName</th>
						<th>author</th>
						<th>description</th>
						<th>publicationYear</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${books}" var="book">
						<tr>
							<!--<td>${todo.id}</td>-->
							<td>${book.bookName}</td>
							<td>${book.author}</td>
							<td>${book.description}</td>
							<td>${book.publicationYear}</td>
							<td><a href="delete-book/${todo.id}" class="btn btn-warning">DELETE</a></td>
							<td><a href="update-book/${todo.id}" class="btn btn-success">UPDATE</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="borrow-book" class="btn btn-success">Borrow Book</a>
		</div>
<%@ include file="common/footer.jspf" %>
