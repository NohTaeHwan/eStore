var cartApp = angular.module('cartApp',[]);

//$scope : model 의존성 주입
//$http : service 객체 주입
cartApp.controller("cartCtrl",function ($scope, $http) {

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.refreshCart = function () {
        $http.get('/estore/api/cart/' + $scope.cartId).then(
          function successCallback(response){
              console.log(response.data);
              $scope.cart = response.data;
          });
    };

    $scope.clearCart = function () {

        $scope.setCsrfToken();

        $http({
            method : 'DELETE',
            url : '/estore/api/cart/' + $scope.cartId
        }).then(function successCallback(){
                $scope.refreshCart();
            }, function errorCallback(response) {
                console.log(response.data);
            });

    };

    $scope.addToCart = function(productId) {

        $scope.setCsrfToken();

        $http.put('/estore/api/cart/add/' + productId).then(
            function successCallback() {
                alert("Product Successfully added to the cart!");
            }, function errorCallback(){
                alert("Adding to the cart failed!");
            });
    };

    $scope.removeFromCart = function(productId){

        $scope.setCsrfToken();

        $http({
            method : 'DELETE',
            url : '/estore/api/cart/cartitem/' + productId
        }).then(
            function successCallback() {
                $scope.refreshCart();
            }, function errorCallback(response){
                console.log(response.data);
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal = 0;

        for (var i =0; i < $scope.cart.cartItems.length;i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    };

    $scope.plusQuantity = function(productId){

        $scope.setCsrfToken();

        $http({
            method : 'PUT',
            url : '/estore/api/cart/plus/' + productId
        }).then(
            function successCallback() {
                $scope.refreshCart();
            }).catch(function errorCallback(){
                alert("주문 최대 수량!");
        });
    };


    //csrf (rest 서버에 보내지는 메소드들에 추가)
    $scope.setCsrfToken = function() {
        var csrfToken = $("meta[name='_csrf']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");

        $http.defaults.headers.common[csrfHeader] = csrfToken;
    }

});
