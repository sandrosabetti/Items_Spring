<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

</head>

<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">

        <h1>AS</h1>

        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Log In</a></p>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <p>Login: <sec:authentication property="principal.username"/></p>
            <p>Roles: <sec:authentication property="principal.authorities"/></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Log Out</a></p>
            <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
            <p align="center"><a class="btn btn-lg btn-success" href="<c:url value="/table" />" role="button">
                Items Page</a></p>
            <%--</sec:authorize>--%>
        </sec:authorize>
    </div>

    <div class="footer">
        <p>&copy; AS 2016</p>
    </div>

</div>
</body>
</html>
