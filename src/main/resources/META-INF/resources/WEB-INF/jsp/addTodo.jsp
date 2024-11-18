<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter Todo details</h1>
    <%--@elvariable id="todo" type="Todo"--%>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="name">Name</form:label>
            <form:input type="text" path="name" required="required"/>
            <form:errors path="name" cssClass="alert-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="Date" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" name="name" path="id"/>
        <form:input type="hidden" name="name" path="done"/>
        <input type="submit" class="btn btn-success">
    </form:form>
</div>

<%@ include file="common/footer.jspf" %>