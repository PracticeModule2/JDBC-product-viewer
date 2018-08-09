<%--
  Created by IntelliJ IDEA.
  User: hue
  Date: 8/8/18
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Products</h1>
<table border="1">
    <tr>
        <td>Product_Id</td>
        <td>Product_Code</td>
        <td>Product_Name</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/p?action=view&&id=${product.getProduct_id()}">${product.getProduct_id()}</a></td>
            <td>${product.getProduct_code()}</td>
            <td>${product.getProduct_name()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
