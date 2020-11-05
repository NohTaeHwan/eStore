<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-25
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="position-relative overflow-hidden p-3 p-md-5  text-center bg-light">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">e-commerce Market Grand Open</h1>
        <p class="lead font-weight-normal">다양한 종류의 제품들을 만나보세요</p>
        <a class="btn btn-outline-secondary" href="<c:url value="/products"/>">시작하기</a>
    </div>
    <div class="product-device shadow-sm d-none d-md-block"></div>
    <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
</div>
