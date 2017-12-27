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

<h3>${product.name} </h3>
<p>${product.description}</p>
<p> Product Code: ${product.productId}</p>
<p> UnitPrice: ${product.unitPrice} </p>
<p> Manufacturer: ${product.manufacturer} </p>
<p> Category: ${product.category}</p>
<p> Units In Stock: ${product.unitsInStock} </p>
<p> Units In Order: ${product.unitsInOrder} </p>
<p> Discontinued: ${product.discontinued} </p>
<p><a href="#"><b>Order Now!</b></a></p>
<p><a href="<spring:url value="/market/products" />">Back</a> </p>
</body>
</html>
