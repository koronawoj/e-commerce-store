<%--
  Created by IntelliJ IDEA.
  User: Le
  Date: 1/7/2016
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>

        <h3>
            <a href="<c:url value="/admin/productInventory" />" >Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>

        <%-- <br><br>

        <h3>
            <a href="<c:url value="/admin/customer" />" >Customer Managementy</a>
        </h3>

        <p>Here you can view the customer information!</p> --%>


        <%@include file="/views/template/footer.jsp" %>
