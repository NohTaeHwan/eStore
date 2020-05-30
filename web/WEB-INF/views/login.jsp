<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-30
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-wrapper">
    <div class="container">
        <h2>Login with username and password</h2>

        <c:if test="${not empty errorMsg}">
            <div style="color:#ff0000"> <h3>${errorMsg}</h3></div>
        </c:if>

        <c:if test="${not empty logoutMsg}">
            <div style="color:#0000ff"> <h3>${logoutMsg}</h3></div>
        </c:if>

        <form action="<c:url value="/login"/>" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" style="width: 50%">
            </div>

            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" style="width: 50%">
            </div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button type="submit" class="btn btn-primary">Login</button>
            <a href="<c:url value="/"/>" class="btn btn-dark">Cancel</a>
        </form>
    </div>

</div>