<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- menu -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark site-header py-1">
    <div class="container d-flex flex-column flex-md-row justify-content-between" id="navbarCollapse">

        <a class="py-2" href="<c:url value="/"/>" aria-label="Product">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
        </a>


        <a class="py-2 d-none d-md-inline-block" href="<c:url value="/"/>"> Home <span class="sr-only">(current)</span></a>
        <a class="py-2 d-none d-md-inline-block" href="<c:url value="/products"/>">Products</a> <!-- product menu -->

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                <a class="py-2 d-none d-md-inline-block" href="<c:url value="/admin"/>">Admin Page</a>

            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                <a class="py-2 d-none d-md-inline-block" href="<c:url value="/cart"/>">Cart</a>

            </c:if>

            <a class="py-2 d-none d-md-inline-block"
               href="javascript:document.getElementById('logout').submit()">Logout</a>

            <form id="logout" action="<c:url value="/logout"/>" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a class="py-2 d-none d-md-inline-block" href="<c:url value="/login"/>">Login</a>

            <a class="py-2 d-none d-md-inline-block" href="<c:url value="/register"/>">Register</a>
        </c:if>

        <%-- 검색창
        <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>--%>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name != 'admin' and pageContext.request.userPrincipal.name != null}">
        <a class="py-2 d-none d-md-inline-block" href="<c:url value="/mypage"/>">My page</a>
    </c:if>
</nav>

