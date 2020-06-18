<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-28
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container-wrapper">
    <div class="container">
        <h2>관리자 페이지</h2>
    </div> <!-- container.div-->

    <div class="container">
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-primary"> 제품 관리 </a>
        <a href="#" class="btn btn-primary">회원 관리</a>
        <a href="<c:url value="/"/>" class="btn btn-dark">Back</a>
    </div> <!-- container.div-->


</div> <!-- container-wrapper.div-->