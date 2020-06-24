<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script src="<c:url value="/resource/js/cartController.js"/>"></script>

<div class="container-wrapper">
    <div class="container">
        <div class="jumbotron">
            <div class="container">
                <h2>Cart</h2>

                <p>All the Selected products in your shopping cart</p>
            </div>
        </div>

        <section class="container" ng-app="cartApp" style="width: 105%">
          <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
              <a class="btn btn-warning pull-left" ng-click="clearCart()">
                  <i class="fa fa-trash"></i> Clear Cart
              </a>

              <br/>

              <table class="table table-hover" >
                  <tr>
                      <th>Product</th>
                      <th>Unit Price</th>
                      <th>Quantity</th>
                      <th>Total Price</th>
                      <th>Action</th>
                  </tr>

                  <tr ng-repeat="item in cart.cartItems">
                      <td>{{item.product.name}}</td>
                      <td>{{item.product.price}}</td>
                      <td>{{item.quantity}}</td>
                      <td>{{item.totalPrice}}</td>
                      <td>

                          <div style="display: inline; color: white ">
                              <a class="btn btn-danger" ng-click="removeFromCart(item.product.id)" style="font-size: x-small">
                                  <i class="fa fa-times"></i>remove</a>

                              <a class="btn btn-danger" ng-click="plusQuantity(item.product.id)" style="font-size: x-small">
                                  <i class="fa fa-plus"></i>plus</a>

                              <a class="btn btn-danger" ng-click="minusQuantity(item.product.id)" style="font-size: x-small">
                                  <i class="fa fa-minus"></i>minus</a>
                          </div>

                      </td>
                  </tr>

                  <tr>
                      <td></td>
                      <td></td>
                      <td>Grand Total</td>
                      <td>{{calGrandTotal()}} 만원</td>
                      <td></td>
                  </tr>
              </table>

              <a class="btn btn-info" href="<c:url value="/products"/>" class="btn btb-default">Continue Shopping</a>
          </div>
        </section>
    </div>
</div>