<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- menu -->
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="<c:url value="/"/>">estore</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/"/>"> Home <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/products"/>">Products</a> <!-- product menu -->
                </li>

                <%--
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin"/>">Admin</a> <!-- admin menu -->
                </li> --%>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin"/>">Admin Page</a>
                        </li>

                    </c:if>

                    <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/cart"/>">Cart</a>
                        </li>

                    </c:if>

                    <li class="nav-item">
                        <a class="nav-link" href="javascript:document.getElementById('logout').submit()">Logout</a>
                    </li>

                    <form id="logout" action="<c:url value="/logout"/>" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>

                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login"/>">Login</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register"/>">Register</a>
                    </li>
                </c:if>

            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>