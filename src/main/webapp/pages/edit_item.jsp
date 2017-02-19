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
    <form:form class="form-horizontal" method="post" modelAttribute="item" action="/edit_item">

        <ul class="list-group" style="width: 30%">
            <li class="list-group-item"><h4>Name</h4>
                <form:input class="form-control" path="name"/>
            </li>
            <li class="list-group-item"><h4>Value</h4>
                <form:input class="form-control" path="value"/>
            </li>
            <li class="list-group-item">
                <h4></h4>
                <form:input type="hidden" value="${item.ID}" path="ID"/>
                <input class="btn btn-warning" type="submit" value="Submit"/>
                <a class="btn btn-success" href="<c:url value="/table" />" role="button">Cancel</a>
            </li>
        </ul>

    </form:form>
</div>

</body>
</html>
