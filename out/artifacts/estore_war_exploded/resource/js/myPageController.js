var myPageApp = angular.module('myPageApp',[]);

myPageApp.controller("myPageCtrl", function ($scope,$http) {

    $scope.initMyPage = function (user){
        $scope.user = user;
        $scope.refreshMyPage();
    };

    //csrf (rest 서버에 보내지는 메소드들에 추가)
    $scope.setCsrfToken = function() {
        var csrfToken = $("meta[name='_csrf']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");

        $http.defaults.headers.common[csrfHeader] = csrfToken;
    };


    $scope.refreshMyPage = function () {
        $http.get('/estore/api/mypage').then(
            function successCallback(response){
                console.log(response.data);
                $scope.user = response.data;
            });
    };


    $scope.deleteAccount = function(){

        $scope.setCsrfToken();

        $http({
            method : 'DELETE',
            url : '/estore/api/mypage'
        }).then(
            function successCallback() {

                document.getElementById('logout').submit();

            }, function errorCallback(response){
                alert("회원 탈퇴 실패!");
                console.log(response.data);
            });
    };

    


});