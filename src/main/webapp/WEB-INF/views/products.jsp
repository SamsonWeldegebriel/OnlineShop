<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 986015
  Date: 12/22/2017
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Page</title>
</head>
<body>

<h1>Products</h1>
<p> All the Available Products in our shop!</p>


<c:forEach items="${products}" var="product">

    <div>
        <img src="<c:url value="/img/${product.productId}.png"/>" alt="Product Image" style="width: 100%">
    </div>

    <h3>${product.name}</h3>
    <p>${product.description}</p>
    <p>${product.unitPrice}</p>
    <p>Available ${product.unitsInStock} units in stock.</p>
    <p><a href="<spring:url value="/market/product/?id=${product.productId}" />"> Details</a></p>


</c:forEach>


</body>
</html>
