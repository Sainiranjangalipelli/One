		<%@ include file="common/header.jspf" %>
		
		<%@ include file="common/navigation.jspf" %>
<div class="container">
<body>
    <h2>Register</h2>
    <form action="/api/users/add-user" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address">

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber">

        <label for="emailAddress">Email Address:</label>
        <input type="email" id="emailAddress" name="emailAddress" required>

        <button type="submit">Add User</button>
    </form>
</body>
</div>
<%@ include file="common/footer.jspf" %>
