<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Item ${item.ID}</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/pages/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="nav.jsp"/>

<div align="center">
    <h2 class="h2">Item ${item.ID}</h2>

    <ul class="list-group" style="width: 30%">
        <li class="list-group-item"><h4>Name: ${item.name}</h4></li>
        <li class="list-group-item"><h4>Value: ${item.value}</h4></li>
        <li class="list-group-item">
            <h4></h4>
            <a class="btn btn-success" href="<c:url value="/table" />" role="button">Back</a>
        </li>
    </ul>

</div>

</body>
</html>
