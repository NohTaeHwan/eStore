<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="<c:url value="/resource/js/userAdminController.js"/>"></script>

<!-- print products -->
<div class="container-wrapper">
    <div class="container">
        <div class="jumbotron">
            <div class="container">
                <h2>유저 관리 페이지</h2>

            </div>
        </div>

        <section class="container" ng-app="userAdminApp">
            <div ng-controller="userAdminCtrl" ng-init="initUsers('${users}')">
                <table class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>email</th>
                        <th>Address</th>
                        <th>Country</th>
                        <th>ZipCode</th>
                        <th>Authority</th>
                        <th>  </th>
                    </tr>

                    <tr ng-repeat="user in users">
                        <td>{{user.username}}</td>
                        <td>{{user.email}}</td>
                        <td>{{user.shippingAddress.address}}</td>
                        <td>{{user.shippingAddress.country}}</td>
                        <td>{{user.shippingAddress.zipCode}}</td>
                        <td>{{user.authority}}</td>
                        <td>
                            <a class="btn btn-danger" ng-click="removeUser(user.id)">
                                <i class="fa fa-minus">delete</i>
                            </a>
                        </td>
                    </tr>
                </table>

                <a href="<c:url value="/admin"/>" class="btn btn-dark">Back</a>
            </div>
        </section>


    </div><!-- product table div-->
</div><!-- container wraaper div-->
