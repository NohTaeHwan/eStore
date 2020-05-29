<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-05-28
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- print products -->
<div class="container-wrapper">
    <div class="container">
        <h2>Product Inventory</h2>
        <p>제품 제고 현황</p>
        <table class="table table-striped">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Manufacturer</th>
                <th>UnitInStock</th>
                <th>Description</th>
                <th>  </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td> ${product.name} </td>
                    <td> ${product.category} </td>
                    <td> ${product.price} </td>
                    <td> ${product.manufacturer} </td>
                    <td> ${product.unitInStock} </td>
                    <td> ${product.description} </td>
                    <td> <a href="<c:url value="/admin/productInventory/deleteProduct/${product.id}"/>">
                        <i class="fa fa-times"></i>  </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="<c:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary"> Add Product </a>
    </div><!-- product table div-->
</div><!-- container wraaper div-->
