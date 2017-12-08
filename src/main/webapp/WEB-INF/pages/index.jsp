<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<title>Security</title>
<body>
<h2>Security App</h2>
<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <h2>Welcome: <c:out value="${username}"/></h2>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <div class="loginmodal-container">
        <h1>Login to Your Account</h1><br>
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="Username (e-mail)">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="login" class="login loginmodal-submit" value="Login">
        </form>
    </div>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <a href="/logout"><input type="button" name="login" class="login loginmodal-submit" value="Logout"></a>
</sec:authorize>
</body>
</html>
