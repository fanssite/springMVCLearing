<%--
  Created by IntelliJ IDEA.
  User: Fannsite
  Date: 2018/8/12
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input</title>
</head>
<body>
<div id="global">
    <c:if test="${requestScope.errors != null}">
        <p id="errors">
        Error(s)!
        <ul>
        <c:forEach var="error" items="${requestScope.errors}">
            <li>${error}</li>
        </c:forEach>
        </ul>
        </p>
    </c:if>
    <form action="product_save.action" method="post">
        <fieldset>
            <p>
                <label for="name">Product Name</label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Product Description</label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="name">Product Price</label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
