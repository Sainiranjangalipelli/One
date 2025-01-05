<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter Your Details</h1>
    <form:form method="post" action="/add-user" modelAttribute="user">
        <fieldset class="mb-3">
            <form:label path="name">Name</form:label>
            <form:input type="text" path="name" required="required" />
            <form:errors path="name" cssClass="text-warning" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="address">Address</form:label>
            <form:input type="text" path="address" required="required" />
            <form:errors path="address" cssClass="text-warning" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="phoneNumber">Phone Number</form:label>
            <form:input type="text" path="phoneNumber" required="required" />
            <form:errors path="phoneNumber" cssClass="text-warning" />
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="emailAddress">Email Address</form:label>
            <form:input type="text" path="emailAddress" required="required" />
            <form:errors path="emailAddress" cssClass="text-warning" />
        </fieldset>

        <form:input type="hidden" path="id" />

        <input type="submit" class="btn btn-success" />
    </form:form>
</div>

<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

<%@ include file="common/footer.jspf" %>


<!-- 
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
 -->
