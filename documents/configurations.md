## Configurations

#### [spring security](https://github.com/NohTaeHwan/eStore/blob/master/web/WEB-INF/servlets/security-context.xml) (ver 1.1)

```xml
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

```xml
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

