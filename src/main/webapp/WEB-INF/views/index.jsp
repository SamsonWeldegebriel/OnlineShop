<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<body>
<h1> ${greeting}</h1>
<p> <b>${tagline}</b></p>


<p><a href="<spring:url value="/market/products"/>"> Products Page</a></p>
    <p><a href="<spring:url value="/market/update/stock"/>"> Update Stock Page</a></p>
        <p><a href="<spring:url value="/market/addproduct"/>"> Add New Product</a></p>



</body>
</html>
