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
        <p class="lead">Product 관리 페이지입니다.</p>
    </div> <!-- container.div-->

    <div class="container">
        <h2> <a href="<c:url value="/admin/productInventory"/>">제품 관리 현황 </a> </h2>
        <p class="lead">Here you can view , check , modify the product inventory.</p>
    </div> <!-- container.div-->


</div> <!-- container-wrapper.div-->