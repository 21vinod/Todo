<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title> Todo-add</title>

</head>
<body>
<div class="container">
    <h1>Enter Todo details</h1>
    <%--@elvariable id="todo" type=""--%>
    <form:form method="post" modelAttribute="todo">
        Name <form:input type="text" name="name" path="name"/>
        <form:errors path="name" cssClass="alert-warning"/>

        Description <form:input type="text" name="desc" path="description"/>
        <form:errors path="description" cssClass="alert-warning"/>
        <form:input type="hidden" name="name" path="id"/>
        <form:input type="hidden" name="name" path="done"/>
        <input type="submit" class="btn btn-success">
    </form:form>
</div>

<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>