<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="<c:url value="/resource/js/myPageController.js"/>"></script>
<%
    String pageContent ='/' + request.getParameter("pageContent");

    if(request.getParameter("pageContent")==null)
        pageContent = "firstPage.jsp";
%>

<div class="container-fluid">
    <div class="row" ng-app="myPageApp" ng-controller="myPageCtrl" >
        <div>
            <jsp:include page="myPageSidebar.jsp"/>
        </div>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <jsp:include page="<%=pageContent%>"/>

        </main>
    </div>
</div>