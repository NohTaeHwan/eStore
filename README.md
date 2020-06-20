# eStore

## List

1. [Overview](#overview)
2. [Project info](#project-info)
3. [Description](#description)
4. [Configuration](#configuration)
5. [AngularJS](#angularjs)
6. [What's new?](#whats-new)





## Overview
Spring Framework를 이용하여 만든 쇼핑몰 웹 서비스 입니다. estore는 Spring mvc를 프레임워크로 이용하였으며 DB는 mysql , ORM으로 hibernate를 이용하였습니다. Rest Api를 이용하여 서버 처리를 하였습니다. 프론트엔드 프레임워크로 AngularJs를 사용했습니다. Bootstrap을 이용하여 웹 페이지를 디자인 하였습니다. 로그인 기능을 넣어 관리자와 일반 유저의 권한을 분리하였습니다. 일반 유저는 제품 조회 , 제품 상세 조회 ,장바구니 기능 사용 가능 합니다. 관리자는 제품 등록 ,수정 ,삭제 ,조회 등의 기능을 모두 이용할 수 있습니다. 또한 관리자는 유저들의 목록을 관리할 수 있습니다.




## Project info

version : ver 1.3

#### 사용 기술 및 라이브러리
- JDK 1.8
- spring 4.3.18
- mysql8
- hibernate 5.3.7
- lombok
- spring-security
- apache tiles 3.0.8
- bootstrap
- AngularJS 1.8





#### project structure
- project framework : maven , spring MVC , AngularJS
- directory tree
```
estore
.
├── README.md
├── documents
│   └── configurations.md
├── lib
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── thnoh
│   │               └── spring
│   │                   ├── controller
│   │                   │   ├── AdminController.java
│   │                   │   ├── CartController.java
│   │                   │   ├── CartRestController.java
│   │                   │   ├── HomeController.java
│   │                   │   ├── LoginController.java
│   │                   │   └── ProductController.java
│   │                   │   └── RegisterController.java
│   │                   │   ├── UserAdminController.java
│   │                   │   └── UserRestController.java
│   │                   ├── dao
│   │                   │   ├── CartDao.java
│   │                   │   ├── CartItemDao.java
│   │                   │   └── ProductDao.java
│   │                   │   └── UserDao.java
│   │                   ├── model
│   │                   │   ├── Cart.java
│   │                   │   ├── CartItem.java
│   │                   │   └── Product.java
│   │                   │   └── User.java
│   │                   │   └── ShippingAddress.java
│   │                   └── service
│   │                       ├── CartItemService.java
│   │                       ├── CartService.java
│   │                       └── ProductService.java
│   │                       └── UserService.java
│   └── test
│       └── java
└── web
    ├── WEB-INF
    │   ├── props
    │   │   └── jdbc.properties
    │   ├── servlets
    │   │   ├── dao-context.xml
    │   │   ├── dispatcher-servlet.xml
    │   │   ├── security-context.xml
    │   │   └── service-context.xml
    │   ├── templates
    │   │   ├── footer.jsp
    │   │   ├── layout.jsp
    │   │   └── menu.jsp
    │   ├── tiles-def
    │   │   └── tiles.xml
    │   ├── views
    │   │   ├── addProduct.jsp
    │   │   ├── admin.jsp
    │   │   ├── index.jsp        
    │   │   ├── cart.jsp
    │   │   ├── login.jsp
    │   │   ├── productInventory.jsp
    │   │   ├── products.jsp
    │   │   └── updateProduct.jsp
    │   │   └── registerUser.jsp
    │   │   └── registerUserSuccess.jsp
    │   │   └── viewProduct.jsp
    │   │   ├── userAdmin.jsp
    │   └── web.xml
    └── resource
        ├── css
        │   ├── bootstrap-grid.min.css
        │   ├── bootstrap-reboot.min.css
        │   ├── bootstrap.min.css
        │   ├── carousel.css
        │   └── main.css
        ├── images
        └── js
            ├── bootstrap.bundle.min.js
            ├── bootstrap.bundle.min.js.map
            ├── bootstrap.min.js
            └── bootstrap.min.js.map 
            └── cartController.js
            └── userAdminController.js
```



## Description

#### 주요 기능

유저
- 제품 조회 : 제품들의 목록 조회
- 제품 상세 정보 : 제품 목록에서 각 제품들의 상세 정보를 조회
- 장바구니 : 구입하고자 하는 제품 장바구니 서비스 이용 가능 

관리자
- 제품 관리 페이지 : 제품을 등록 , 수정 , 삭제할 수 있는 제품 목록 페이지
- 제품 등록 : spring form을 통해 제품 정보를 입력하여 새 제품 등록
- 제품 수정 : spring form을 통해 제품 정보를 입력하여 제품 수정
- 제품 삭제 : 선택한 제품을 삭제
- 유저 관리 : 유저 목록 조회 , 유저 삭제 (v1.3)

로그인 및 회원가입
- 로그인 : spring security 이용하여 admin과 일반 유저로 사용 권한이 분리되도록 구성
- 회원가입 : spring form을 통해 유저 정보를 입력하여 새 유저 등록. DB에 password가 encoding되어 저장

기타 기능

- file-upload : 제품을 등록, 수정할 경우 제품의 사진을 등록하는 기능



#### URL

메인 홈  : /estore

** 밑의 모든 url은 /estore뒤에 붙여서 씁니다.

유저

- 제품 조회 : /products
- 제품 상세 정보 : /viewProducts/:productId
- 장바구니 : /cart

관리자

- 제품 관리 페이지 : /admin/productInventory
- 제품 추가 : /admin/productInventory/addProduct
- 제품 삭제 : /admin/productInventory/deleteProduct/:productId
- 제품 업데이트 : /admin/productInventory/updateProduct/:productId
- 유저 관리 페이지 : /admin/userAdmin (v1.3)

로그인 및 회원가입

- 로그인 페이지 : /login
- 회원가입 : /register


#### REST API

장바구니(/api/cart) 

- 장바구니 조회 : GET /:cartId
- 장바구니 제품 전체 삭제 : DELETE /:cartId
- 장바구니 제품 삭제 : DELETE /cartitem/:productId
- 장바구니에 제품 추가 : PUT /add/:productId

유저 관리(/api/users) (v1.3)

- 유저 목록 조회 : GET 
- 유저 삭제 : DELETE /:userId



## Configuration

- spring-security
- apache-tiles
- hibernate-config

[자세히보기](https://github.com/NohTaeHwan/eStore/blob/master/documents/configurations.md)



## AngularJS

AngularJS Version : 1.8.0

#### CDN

```jsp
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
```

<br/>

#### Usage

##### 장바구니 ([cartController.js](https://github.com/NohTaeHwan/eStore/blob/master/web/resource/js/cartController.js))

Module : cartApp

Controller : cartCtrl

Methods :

- refreshCart (GET) : 장바구니 새로고침
- clearCart(DELETE) : 장바구니 전체 삭제
- addToCart(PUT) : 장바구니에 제품 추가
- removeFromCart(DELETE) : 장바구니 제품 삭제
- calGrandTotal : 카트 내의 제품 총합 계산
- setCsrfToken : [layout.js](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/templates/layout.jsp) meta 태그에 명시된 csrf 관련 내용을 설정.



##### 유저관리 ([userAdminController.js](https://github.com/NohTaeHwan/eStore/blob/master/web/resource/js/userAdminController.js)) (v1.3)

Module : userAdminApp

Controller : userAdminCtrl

Methods :

- refreshUsers (GET) : 유저 목록 새로고침
- removeUser(DELETE) : 유저 삭제
- setCsrfToken : [layout.js](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/templates/layout.jsp) meta 태그에 명시된 csrf 관련 내용을 설정.





## What's new?

- 유저 관리 페이지 기능 추가
- 유저 관리 기능에 REST API적용
- 유저 관리 기능에 AngularJS 적용

