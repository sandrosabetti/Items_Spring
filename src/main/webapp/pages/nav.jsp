<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">AS</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li><a href="${pageContext.request.contextPath}/">Start Page</a></li>
                <li><a href="${pageContext.request.contextPath}/table">Items Table</a></li>

                <c:if test="${items != null}">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Items
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <c:forEach var="item" items="${items}" varStatus="counter">
                                <li>
                                    <a href="${pageContext.request.contextPath}/show_item?id=${item.ID}">Item ${item.ID}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:if>

            </ul>

            <ul class="nav navbar-nav navbar-right">

                <form class="navbar-form navbar-left" method="get"
                      action="${pageContext.request.contextPath}/find_item">
                    <div class="form-group">
                        <input type="text" class="form-control" id="txt" name="name">
                    </div>
                    <button class="btn btn-default" id="button-id" type="submit">Search</button>
                </form>

                <sec:authorize access="isAuthenticated()">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><sec:authentication
                                property="principal.username"/>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="/pages/show_user.jsp"/>">Details</a></li>
                            <li><a href="<c:url value="/logout"/>">Log Out</a></li>
                            </li>
                        </ul>
                    </li>

                </sec:authorize>
                <li>
                    <sec:authorize access="!isAuthenticated()">
                        <a href="<c:url value="/login" />">Log In</a>
                    </sec:authorize>
                </li>
                <li>"   "</li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>