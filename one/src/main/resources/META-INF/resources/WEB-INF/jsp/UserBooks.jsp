		<%@ include file="common/header.jspf" %>
		
		<%@ include file="common/navigation.jspf" %>
		<link rel="stylesheet" href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
		
		<div class="container">
		<!--<div>Welcome ${name}</div>
		<hr>-->
		<H1>All books</H1>
			<table class="table">
				<thead>
					<tr>
						<!---<th>id</th>-->
						<th>bookName</th>
						<th>author</th>
						<th>description</th>
						<th>publicationYear</th>
						<th>available</th>
						<th></th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${books}" var="book">
					<c:if test="${book.quantity > 0}">
						<tr>
							<!--<td>${todo.id}</td>-->
							<td>${book.bookName}</td>
							<td>${book.author}</td>
							<td>${book.description}</td>
							<td>${book.publicationYear}</td>
							<td>${book.quantity}</td>
							
							<td><a href="/book/${book.id}" class="btn btn-warning">Borrow</a></td>
						<!--  	<td><a href="delete-book/${todo.id}" class="btn btn-warning">DELETE</a></td>
							<td><a href="update-book/${todo.id}" class="btn btn-success">UPDATE</a></td> -->
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
		<!-- 	<a href="borrow-book" class="btn btn-success">Borrow Book</a>  -->
		</div>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<%@ include file="common/footer.jspf" %>
