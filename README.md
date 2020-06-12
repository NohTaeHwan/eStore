# eStore

## List

1. [Overview](#overview)
2. [Project info](#project-info)
3. [Description](#description)
4. [Configuration](#configuration)



## Overview
Spring Framework를 이용하여 만든 쇼핑몰 웹 서비스 입니다. estore는 Spring mvc를 프레임워크로 이용하였으며 DB는 mysql , ORM으로 hibernate를 이용하였습니다. 
Bootstrap을 이용하여 웹 페이지를 디자인 하였습니다. 로그인 기능을 넣어 관리자와 일반 유저의 권한을 분리하였습니다. 일반 유저는 제품 조회 , 제품 상세 조회 기능 사용 가능 합니다.
관리자는 제품 등록 ,수정 ,삭제 ,조회 등의 기능을 모두 이용할 수 있습니다. 




## Project info

version : ver 1.1

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
│   │                   │   └── RegisterController.java
│   │                   ├── dao
│   │                   │   └── ProductDao.java
│   │                   │   └── UserDao.java
│   │                   ├── model
│   │                   │   └── Product.java
│   │                   │   └── User.java
│   │                   │   └── ShippingAddress.java
│   │                   └── service
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
    │   │   ├── login.jsp
    │   │   ├── productInventory.jsp
    │   │   ├── products.jsp
    │   │   └── updateProduct.jsp
    │   │   └── registerUser.jsp
    │   │   └── registerUserSuccess.jsp
    │   │   └── viewProduct.jsp
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

#### 주요 기능

유저
- 제품 조회 : 제품들의 목록 조회
- 제품 상세 정보 : 제품 목록에서 각 제품들의 상세 정보를 조회(v1.1)

관리자
- 제품 관리 페이지 : 제품을 등록 , 수정 , 삭제할 수 있는 제품 목록 페이지
- 제품 등록 : spring form을 통해 제품 정보를 입력하여 새 제품 등록
- 제품 수정 : spring form을 통해 제품 정보를 입력하여 제품 수정
- 제품 삭제 : 선택한 제품을 삭제

로그인 및 회원가입
- 로그인 : spring security 이용하여 admin과 일반 유저로 사용 권한이 분리되도록 구성
- 회원가입 : spring form을 통해 유저 정보를 입력하여 새 유저 등록. db에 password가 encoding되어 저장(v1.1)

기타 기능

- file-upload : 제품을 등록, 수정할 경우 제품의 사진을 등록하는 기능



#### URL

메인 홈  : /estore

** 밑의 모든 url은 /estore뒤에 붙여서 씁니다.

유저

- 제품 조회 : /products
- 제품 상세 정보 : /viewProducts/:productId

관리자

- 제품 관리 페이지 : /admin/productInventory
- 제품 추가 : /admin/productInventory/addProduct
- 제품 삭제 : /admin/productInventory/deleteProduct/:productId
- 제품 업데이트 : /admin/productInventory/updateProduct/:productId

로그인 및 회원가입

- 로그인 페이지 : /login
- 회원가입 : /register




## Configuration

#### [spring security](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/servlets/security-context.xml) (ver 1.1)

```
<!--security-context.xml-->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">

    <security:authentication-manager>
        <security:authentication-provider>
            <security:jdbc-user-service data-source-ref="dataSource"
                                        users-by-username-query="select username, password, enabled from users where username=?"
                                        authorities-by-username-query="select username, authority from users where username=?"/>
            <security:password-encoder ref="passwordEncoder"/>
        </security:authentication-provider>
    </security:authentication-manager>

    <security:http auto-config="true" use-expressions="true">
        <security:intercept-url pattern="/admin/**" access='hasRole("ROLE_ADMIN")'/>
        <security:form-login login-page="/login" authentication-failure-url="/login/?error=1"/>
    </security:http>

    <bean class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" id="passwordEncoder">
    </bean>
</beans>

```
ver1.0과 변경점.
- bean으로 BCryptPasswordEncoder 등록 후 password의 보안을 위해 password-encoding 기능 이용




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



#### [hibernate-config](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/servlets/dao-context.xml)

```xml
<!-- dao-context.xml 중 hibernate 설정 파트 -->

    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <property name="packagesToScan">
            <list>
                <value>com.thnoh.spring.model</value>
            </list>
        </property>

        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">false</prop>
            </props>
        </property>
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager"/>

    <bean id="transactionManager"
          class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"></property>
    </bean>

```

- hibernate.hbm2ddl.auto 프로퍼티에 대한 내용은 [여기 참조!](https://velog.io/@think2wice/Hibernate-hbm2ddl.auto-프로퍼티-설정)
- show_sql 은 매핑될 때 변환되어지는 sql문을 보여주는 옵션이고 format_sql은 보여지는 sql을 포맷팅하여 보여주는 옵션



## What's new?

- 제품 상세 페이지
- 회원가입 기능
- User , ShippingAddress 모델 추가.