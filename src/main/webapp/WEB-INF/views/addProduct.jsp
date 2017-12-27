<%--
  Created by IntelliJ IDEA.
  User: 986015
  Date: 12/26/2017
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<form:form action="/market/addproduct" modelAttribute="newProduct">
    <fieldset>
        <legend>Add New Product</legend>


        <p> Product Code: <form:input id="productId" path="productId"/></p>
        <p> Product Name: <form:input id="name" path="name"/></p>
        <p> Product Description: <form:input id="description" path="description"/></p>
        <p> Unit Price: <form:input id="unitPrice" path="unitPrice"/></p>
        <p> Manufacturer: <form:input id="manufacturer" path="manufacturer"/></p>
        <p> Category: <form:input id="category" path="category"/></p>
        <p> Units In Stock: <form:input id="unitsInStock" path="unitsInStock"/></p>
        <p> Units In Order: <form:input id="unitsInOrder" path="unitsInOrder"/></p>
        <p>
            <form:label path="discontinued"> Discontinued: </form:label>
            <form:checkbox path="discontinued" id="discontinued"/>
        </p>
        <div>
            <form:label path="condition">Condition</form:label>
            <form:radiobutton path="condition" value="New"/>New
            <form:radiobutton path="condition" value="Refurbished"/>Refurbished
            <form:radiobutton path="condition" value="Used"/>Used
        </div>
        <%--<p><a href="/market/addproduct"><b>Add Product!</b></a></p>--%>
        <P><input type="submit" id="btnAddProduct" value="Add Product!"></P>
    </fieldset>
</form:form>

</body>
</html>
