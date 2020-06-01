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

<div class="container-wrapper">
    <div class="container">
        <h1>Update Product</h1>

        <p class="lead">Fill the below information to update a product : </p>


        <sf:form action="${pageContext.request.contextPath}/admin/productInventory/updateProduct"
                 method="post" modelAttribute="product">

            <!-- update 시에는 id값을 따로 바인딩해줘야함.그래야 맞는 id로 update가능 -->
            <sf:hidden path="id"/>

            <div class="form-group">
                <label for="name">Name</label>
                <sf:input path="name" id="name" class="form-control"/>
                <sf:errors path="name" cssStyle="color:#ff0000;"/>
            </div>

            <div class="form-group">
                <label for="category">Category : </label>
                <sf:radiobutton path="category" id="category" value="컴퓨터"/> 컴퓨터
                <sf:radiobutton path="category" id="category" value="가전"/> 가전
                <sf:radiobutton path="category" id="category" value="잡화"/> 잡화
                <sf:radiobutton path="category" id="category" value="자동차"/> 자동차
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <sf:textarea path="description" id="description" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <sf:input path="price" id="price" class="form-control"/>
                <sf:errors path="price" cssStyle="color:#ff0000;"/>
            </div>

            <div class="form-group">
                <label for="unitInStock">Unit In Stock</label>
                <sf:input path="unitInStock" id="unitInStock" class="form-control"/>
                <sf:errors path="unitInStock" cssStyle="color:#ff0000;"/>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <sf:input path="manufacturer" id="manufacturer" class="form-control"/>
                <sf:errors path="manufacturer" cssStyle="color:#ff0000;"/>
            </div>

            <input type="submit" value="submit" class="btn btn-primary">
            <a href="<c:url value="/admin/productInventory"/>" class="btn btn-dark">Cancel</a>
        </sf:form>
        <br/>
    </div>
</div>