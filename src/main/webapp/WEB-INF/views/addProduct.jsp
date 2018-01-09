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
<%@ page session="false" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<section>
    <div class="pull-right">
        <a href="?language=en">English</a>|
        <a href="?language=am">Amharic</a>
    </div>
</section>

<div>
    <a href="<c:url value="/logout" />">Logout</a>
</div>

<form:form action="/market/addproduct" modelAttribute="newProduct" enctype="multipart/form-data">
    <fieldset>
        <legend>Add New Product</legend>


        <p><label for="productId"><spring:message code="addProduct.form.productId.label"/> </label>
            <form:input id="productId" path="productId"/></p>
        <p><label for="name"><spring:message code="addProduct.form.name.label"/> </label>
            <form:input id="name" path="name"/></p>
        <p><label for="description"><spring:message code="addProduct.form.description.label"/> </label>
            <form:input id="description" path="description"/></p>
        <p><label for="unitPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>
            <form:input id="unitPrice" path="unitPrice"/></p>
        <p><label for="manufacturer"><spring:message code="addProduct.form.manufacturer.label"/></label>
            <form:input id="manufacturer" path="manufacturer"/></p>
        <p><label for="category"><spring:message code="addProduct.form.category.label"/></label>
            <form:input id="category" path="category"/></p>
        <p><label for="unitsInStock"><spring:message code="addProduct.form.unitsInStock.label"/></label>
            <form:input id="unitsInStock" path="unitsInStock"/></p>
            <%--<p><label for="productId"><spring:message code="addProduct.form.unitsInOrder.label"/></label>
                <form:input id="unitsInOrder" path="unitsInOrder"/></p>
                <p>
                <form:label path="discontinued"> Discontinued: </form:label>
                <form:checkbox path="discontinued" id="discontinued"/>
            </p>--%>
        <div>
            <form:label path="condition"><spring:message code="addProduct.form.condition.label"/></form:label>
            <form:radiobutton path="condition" value="New"/>New
            <form:radiobutton path="condition" value="Refurbished"/>Refurbished
            <form:radiobutton path="condition" value="Used"/>Used
        </div>

        <div>
            <form:label path="productImage"><spring:message code="addProduct.form.productImage.label"/> </form:label>
            <form:input path="productImage" id="productImage" type="file"></form:input>

        </div>
            <%--<p><a href="/market/addproduct"><b>Add Product!</b></a></p>--%>
        <P><input type="submit" id="btnAddProduct" value="Add Product!"></P>
    </fieldset>
</form:form>

</body>
</html>
