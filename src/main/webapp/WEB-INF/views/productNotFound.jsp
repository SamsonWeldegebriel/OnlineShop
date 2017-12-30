<%--
  Created by IntelliJ IDEA.
  User: 986015
  Date: 12/29/2017
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Not Found</title>
</head>
<body>

<div>
    <h1> There is no product found with the Product id ${invalidProduct}</h1>

</div>
<div>${url}</div>
<div>${exception}</div>

<div>
    <a href="<spring:url value="/market/products" />  ">Products Page</a>
</div>
</body>
</html>
