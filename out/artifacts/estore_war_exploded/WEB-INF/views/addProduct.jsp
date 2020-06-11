<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-wrapper">
    <div class="container">
        <h1>Add Product</h1>

        <p class="lead">Fill the below information to add a product : </p>

        <sf:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct?${_csrf.parameterName}=${_csrf.token}"
            method="post" modelAttribute="product" enctype="multipart/form-data">

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

            <div class="form-group">
                <label for="productImage">Upload picture</label>
                <sf:input path="productImage" id="productImage" type="file" class="form-control"/>
            </div>

            <input type="submit" value="submit" class="btn btn-primary">
            <a href="<c:url value="/admin/productInventory"/>" class="btn btn-dark">Cancel</a>
        </sf:form>
        <br/>
    </div>
</div>