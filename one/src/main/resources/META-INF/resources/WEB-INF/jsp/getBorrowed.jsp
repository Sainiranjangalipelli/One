		<%@ include file="common/header.jspf" %>
		
		<%@ include file="common/navigation.jspf" %>
		
		<div class="container">
		<!--<div>Welcome ${name}</div>
		<hr>-->
		<H1>Your Books</H1>
			<table class="table">
				<thead>
					<tr>
						<!---<th>id</th>-->
						<th>BookName</th>
						<th>Author</th>
						<th>Description</th>
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
						 	<td><a href="/user/book/${book.id}" class="btn btn-success">Return</a></td>  
						<!--  	<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td> btn btn-warning  -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<!-- 	<a href="all-books/${id}" class="btn btn-success">See All Books</a>  -->
		
		<!--<form action="all-books/${id}" method="get"> 
		<input type="hidden" name="id" value="${id}" /> -->
		<form action="/all-books" method="get">
        <button type="submit" class="btn btn-success">See All Books</button>
    </form>
		
		</div>
<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<%@ include file="common/footer.jspf" %>
