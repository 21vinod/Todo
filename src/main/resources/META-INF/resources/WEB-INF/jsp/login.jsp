<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="page-search-header">
    <h3> Login</h3>
</div>
<div class="container">
    <pre>${error}</pre>
    <form method="post">
        UserName <input type="text" name="username">
        Password <input type="password" name="password">
        <input type="submit" class="btn btn-success">
    </form>
</div>

<%@ include file="common/footer.jspf" %>