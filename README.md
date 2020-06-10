# eStore

## List
1. [Overview](#overview)
2. [Project info](#project-info)
3. [Description](#description)
4. [Configuration](#configuration)

## Overview
Spring Framework를 이용하여 만든 쇼핑몰 웹 서비스 입니다. estore는 Spring mvc를 프레임워크로 이용하였으며 DB는 mysql , ORM으로 hibernate를 이용하였습니다. 
Bootstrap을 이용하여 웹 페이지를 디자인 하였습니다. 로그인 기능을 넣어 관리자와 일반 유저의 권한을 분리하였습니다. 일반 유저는 제품 조회 기능만 사용 가능 합니다.
관리자는 제품 등록 ,수정 ,삭제 ,조회 등의 기능을 모두 이용할 수 있습니다. 


## Project info

version : ver 1.0

#### 사용 기술 및 라이브러리
- JDK 1.8
- spring 4.3.18
- mysql8
- hibernate 5.3.7
- lombok
- spring-security
- apache tiles 3.0.8
- bootstrap

#### project structure
- project framework : maven , spring MVC
- directory tree
```
estore
.
├── README.md
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
│   │                   │   ├── HomeController.java
│   │                   │   ├── LoginController.java
│   │                   │   └── ProductController.java
│   │                   ├── dao
│   │                   │   └── ProductDao.java
│   │                   ├── model
│   │                   │   └── Product.java
│   │                   └── service
│   │                       └── ProductService.java
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
    │   │   ├── login.jsp
    │   │   ├── productInventory.jsp
    │   │   ├── products.jsp
    │   │   └── updateProduct.jsp
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

```

## Description

#### 수행 가능 기능

user
- 제품 조회 : /estore/products

admin
- 제품 조회 : /estore/admin/productInventory
- 제품 생성 : /estore/admin/productInventory/addProduct
- 제품 수정 : /estore/admin/productInventory/updateProduct
- 제품 삭제 : /estore/admin/productInventory/deleteProduct/:id

etc
- 로그인 : spring security 이용하여 admin과 일반 유저로 사용 권한이 분리되도록 구성하였습니다.
- file-upload : 제품을 등록, 수정할 경우 제품의 사진을 등록하는 기능을 넣었습니다.

## Configuration

#### [spring security](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/servlets/security-context.xml)
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">

    <security:authentication-manager>
        <security:authentication-provider>
            <security:jdbc-user-service data-source-ref="dataSource"
                                        users-by-username-query="select username, password, enabled from users where username=?"
                                        authorities-by-username-query="select username, authority from authorities where username=?"/>
        </security:authentication-provider>
    </security:authentication-manager>

    <security:http auto-config="true" use-expressions="true">
        <security:intercept-url pattern="/admin/**" access='hasRole("ROLE_ADMIN")'/>
        <security:form-login login-page="/login" authentication-failure-url="/login/?error=1"/>
    </security:http>
</beans>

```

#### [apache-tiles](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/tiles-def/tiles.xml)
```
<!------tiles.xml-------->

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE tiles-definitions PUBLIC
        "-//Apache Software Foundation//DTD Tiles Configuration 3.0//EN"
        "http://tiles.apache.org/dtds/tiles-config_3_0.dtd">
<tiles-definitions>

    <definition name="base" template="/WEB-INF/templates/layout.jsp">
        <put-attribute name="title" value="eStore homepage" />
        <put-attribute name="menu" value="/WEB-INF/templates/menu.jsp" />
        <put-attribute name="footer" value="/WEB-INF/templates/footer.jsp" />
    </definition>

    <definition name="index" extends="base">
        <put-attribute name="title" value="My eStore homepage" />
        <put-attribute name="body" value="/WEB-INF/views/index.jsp" />
    </definition>

    <definition name="products" extends="base">
        <put-attribute name="title" value="Products page" />
        <put-attribute name="body" value="/WEB-INF/views/products.jsp" />
    </definition>
    
    <!-- 이하 생략.-->

</tiles-definitions>

```

## What's new?