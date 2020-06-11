<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- print products -->
<div class="container-wrapper">
    <div class="container">

        <h2>Product Detail</h2>
        <p class="lead">제품 상세 정보</p>

        <div class="row">
            <div class="col-md-6">
                <img src="<c:url value="/resource/images/${product.imageFilename}"/>" alt="image" style="width: 80%"/>
            </div>

            <div class="col-md-6">
                <h3>${product.name}</h3>
                <p><strong>Category : </strong> ${product.category}</p>
                <p><strong>Manufacturer : </strong> ${product.manufacturer}</p>
                <p><strong>Description : </strong> ${product.description}</p>
                <p><strong>Price : </strong> ${product.price}</p>
            </div>

        </div>

    </div><!-- product table div-->
</div><!-- container wraaper div-->
