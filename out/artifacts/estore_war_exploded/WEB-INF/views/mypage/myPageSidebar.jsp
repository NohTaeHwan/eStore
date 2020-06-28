<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<script>

    function changeView(value){

        if(value == "0") // HOME 버튼 클릭시 첫화면으로 이동
        {
            location.href="<c:url value="/mypage"/>";
        }
        else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
        {
            location.href="<c:url value="/mypage?pageContent=deleteAccount"/>";
            // location.href="MainForm.jsp?contentPage=member/view/LoginForm.jsp";
        }
        else if(value == "2") // 로그인 버튼 클릭시 로그인 화면으로 이동
        {

        }
    }

</script>


<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column" id="myPage_button">
            <li class="nav-item" >
                <button class="nav-link" onclick="changeView(0)">
                    회원 정보 수정
                </button>
            </li>
            <li class="nav-item">
                <button class="nav-link" onclick="changeView(1)">
                    회원 탈퇴
                </button>
            </li>
            <li class="nav-item">
                <button class="nav-link" onclick="changeView(2)">
                    Test3
                </button>
            </li>
        </ul>

    </div>
</nav>