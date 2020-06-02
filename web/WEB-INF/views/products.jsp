<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-27
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- print products -->
<div class="container-wrapper">
    <div class="container">
        <h2>All Products</h2>
        <p>착한 가격으로 상품을 살펴보세요</p>
        <table class="table table-striped">
            <thead>
                <tr class="bg-success">
                    <th>Photo Thumb</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Manufacturer</th>
                    <th>UnitInStock</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td> <img src="<c:url value="/resource/images/${product.imageFilename}"/>"
                                  alt="image" style="width: 100%;"/> </td>
                        <td> ${product.name} </td>
                        <td> ${product.category} </td>
                        <td> ${product.price} </td>
                        <td> ${product.manufacturer} </td>
                        <td> ${product.unitInStock} </td>
                        <td> ${product.description} </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div><!-- product table div-->
</div><!-- container wraaper div-->
