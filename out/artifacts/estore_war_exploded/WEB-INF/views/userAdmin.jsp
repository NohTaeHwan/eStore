<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- print products -->
<div class="container-wrapper">
    <div class="container">
        <h2>유저 관리 페이지</h2>

        <table class="table table-striped">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>email</th>
                <th>Address</th>
                <th>Country</th>
                <th>ZipCode</th>
                <th>Authority</th>
                <th>  </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td> ${user.username} </td>
                    <td> ${user.email} </td>
                    <td> ${user.shippingAddress.address} </td>
                    <td> ${user.shippingAddress.country} </td>
                    <td> ${user.shippingAddress.zipCode} </td>
                    <td> ${user.authority} </td>
                    <td>
                       <a href="#">
                           <i class="fa fa-times"></i>
                       </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div><!-- product table div-->
</div><!-- container wraaper div-->
