<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Items Table</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/pages/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="nav.jsp"/>

<h2 align="center">Items Table</h2>
<table class="table table-striped" style="table-layout:fixed; width:70%" align="center">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Value</th>
        <sec:authorize access="!hasRole('ROLE_ADMIN')">
            <th style="text-align:center">Action</th>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th style="text-align:center" colspan="3" align="center">Actions</th>
        </sec:authorize>
    </tr>
    <c:forEach var="item" items="${items}" varStatus="counter">
        <tr>
            <td><c:out value="${item.ID}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.value}"/></td>
            <td style="text-align:center"><a href="<c:url value="/show_item?id=${item.ID}" />" role="button"
                                             class="btn btn-info">Show</a>
            </td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td style="text-align:center"><a href="<c:url value="/edit_item?id=${item.ID}" />" role="button"
                                                 class="btn btn-primary">Edit</a>
                </td>
                <td style="text-align:center">
                    <form:form method="post" action="/delete_item">
                        <input type="hidden" value="${item.ID}" name="id"/>
                        <input type="submit" class="btn btn-danger" value="Delete"
                               onclick="return confirm('Are you sure you want to delete?')"/>
                    </form:form>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>

<div align="center">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="<c:url value="/add_item" />" role="button" class="btn btn-warning">Add Item</a>
    </sec:authorize>
</div>

</body>
</html>