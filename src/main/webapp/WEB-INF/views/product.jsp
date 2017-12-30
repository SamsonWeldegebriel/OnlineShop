<%--
  Created by IntelliJ IDEA.
  User: 986015
  Date: 12/26/2017
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Products Page</title>
</head>
<body>

<section>
    <div class="pull-right" style="padding-right:50px">
        <a href="?language=en">English</a>|
        <a href="?language=am">Amharic</a>
    </div>
</section>

<h3>${product.name} </h3>
<p>${product.description}</p>
<img src="<c:url value="/img/${product.productId}.png"/>" alt="Product Image" style="width: 100%">
<p> <labe><spring:message code="product.productId.label"/> </labe> ${product.productId}</p>
<p> <label><spring:message code="product.unitPrice.label"/></label> ${product.unitPrice} </p>
<p> <label><spring:message code="product.manufacturer.label"/></label> ${product.manufacturer} </p>
<p> <label><spring:message code="product.category.label"/></label> ${product.category}</p>
<p> <label><spring:message code="product.unitsInStock.label"/></label>Units In Stock: ${product.unitsInStock} </p>
<p> <label><spring:message code="product.unitsInOrder.label"/></label>Units In Order: ${product.unitsInOrder} </p>
<p> <label><spring:message code="product.discontinued.label"/></label>Discontinued: ${product.discontinued} </p>
<p><a href="#"><b><spring:message code="product.orderNow.button"/></b></a></p>
<p><a href="<spring:url value="/market/products" />"><spring:message code="product.back.button"/> </a> </p>
</body>
</html>