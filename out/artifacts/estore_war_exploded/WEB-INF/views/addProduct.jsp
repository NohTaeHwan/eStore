<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-29
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-wrapper">
    <div class="container">
        <h1>Add Product</h1>

        <p class="lead">Fill the below information to add a product : </p>

        <sf:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
            method="post" modelAttribute="product">

            <div class="form-group">
                <label for="name">Name</label>
                <sf:input path="name" id="name" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="category">Category : </label>
                <sf:radiobutton path="category" id="category" value="컴퓨터"/> 컴퓨터
                <sf:radiobutton path="category" id="category" value="가전"/> 가전
                <sf:radiobutton path="category" id="category" value="잡화"/> 잡화
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <sf:textarea path="description" id="description" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <sf:input path="price" id="price" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="unitInStock">Unit In Stock</label>
                <sf:input path="unitInStock" id="unitInStock" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <sf:input path="manufacturer" id="manufacturer" class="form-control"/>
            </div>

            <input type="submit" value="submit" class="btn btn-primary">
            <a href="<c:url value="/admin/productInventory"/>" class="btn btn-dark">Cancel</a>
        </sf:form>
        <br/>
    </div>
</div>