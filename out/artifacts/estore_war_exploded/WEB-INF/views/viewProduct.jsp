<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="<c:url value="/resource/js/cartController.js"/>"></script>



<!-- print products -->
<div class="container-wrapper">
    <div class="container" ng-app = "cartApp">

        <h2>Product Detail</h2>
        <p class="lead">제품 상세 정보</p>

        <div class="row" ng-controller="cartCtrl">
            <div class="col-md-6">
                <img src="<c:url value="/resource/images/${product.imageFilename}"/>" alt="image" style="width: 80%"/>
            </div>

            <div class="col-md-6">
                <h3>${product.name}</h3>
                <p><strong>Category : </strong> ${product.category}</p>
                <p><strong>Manufacturer : </strong> ${product.manufacturer}</p>
                <p><strong>Description : </strong> ${product.description}</p>
                <p><strong>Price : </strong> ${product.price}</p>

                <br/>
                <p>
                    <a href="<c:url value="/products"/>" class="btn btn-danger">Back</a>
                    <c:if test="${pageContext.request.userPrincipal.name != 'admin' and pageContext.request.userPrincipal.name != null }">

                            <button class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
                                <i class="fa fa-shopping-cart"></i>Order Now
                            </button>

                            <a href="<c:url value="/cart"/>" class="btn btn-info">
                                <i class="fa fa-eye"></i> View Cart
                            </a>


                    </c:if>
                </p>
            </div>

        </div>

    </div><!-- product table div-->
</div><!-- container wraaper div-->
