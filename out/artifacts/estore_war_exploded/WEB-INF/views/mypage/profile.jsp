<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-29
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String isRedirect = request.getParameter("isRedirect");

    if(isRedirect==null)
        isRedirect = "";
%>

<div class="container-wrapper">
    <div class="container">

        <div class="jumbotron">
            <div class="container">
                <h2>회원 정보 수정</h2>
            </div>
        </div>

        <% if(isRedirect.equals("true")) {%>
            <h3 style="color: blue">회원 정보 수정완료!</h3>
        <% } else if(isRedirect.equals("false")){%>
            <h3 style="color: red">회원 정보 수정실패!</h3>
        <% } %>

        <sf:form action="${pageContext.request.contextPath}/updateAccount"
                 modelAttribute="user" method="put">


            <sf:hidden path="id"/>

            <h3>개인 정보</h3>

            <div class="form-group">
                <label for="email">이메일 주소</label>
                <sf:input path="email" id="email" class="form-control"/>
                <sf:errors path="email" cssStyle="color: #ff0000"/>
            </div>

            <br/>

            <h3>배송 정보</h3>

            <div class="form-group">
                <label for="shippingStreet">주소</label>
                <sf:input path="shippingAddress.address" id="shippingStreet" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="shippingCountry">국가</label>
                <sf:input path="shippingAddress.country" id="shippingCountry" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="shippingZip">우편번호</label>
                <sf:input path="shippingAddress.zipCode" id="shippingZip" class="form-control"/>
            </div>

            <input type="submit" value="submit" class="btn btn-primary">
        </sf:form>

        <br/>
    </div>
</div>