<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="container-wrapper">
        <div class="jumbotron">
            <h2>회원 탈퇴</h2>

            <p>회원 탈퇴 페이지입니다.</p>
        </div>

        <section class="container" ng-app="myPageApp">
            <div ng-controller="myPageCtrl" ng-init="initUser('${user}')">
                <p>탈퇴 버튼을 누르면 다시 되돌릴 수 없습니다!</p>
                <button class="btn btn-danger" style="color: white" ng-click="deleteAccount()">
                    Delete Account
                </button>

                <form id="logout" action="<c:url value="/logout"/>" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </section>


    </div>
</div>
