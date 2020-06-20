var userAdminApp = angular.module('userAdminApp',[]);

userAdminApp.controller("userAdminCtrl", function ($scope,$http) {

    $scope.initUsers = function (users){
      $scope.users = users;
      $scope.refreshUsers();
    };

    //csrf (rest 서버에 보내지는 메소드들에 추가)
    $scope.setCsrfToken = function() {
        var csrfToken = $("meta[name='_csrf']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");

        $http.defaults.headers.common[csrfHeader] = csrfToken;
    };


    $scope.refreshUsers = function () {
        $http.get('/estore/api/users/').then(
            function successCallback(response){
                console.log(response.data);
                $scope.users = response.data;
            });
    };


    $scope.removeUser = function(userId){

        $scope.setCsrfToken();

        $http({
            method : 'DELETE',
            url : '/estore/api/users/' + userId
        }).then(
            function successCallback() {
                $scope.refreshUsers();
            }, function errorCallback(response){
                console.log(response.data);
            });
    };



});