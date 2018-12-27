<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 20.06.18
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#FFFAF0">

<nav class="navbar navbar-expand-sm bg-success navbar-dark">
    <a class="navbar-brand" href="../home">Homepage</a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="manage">Reservations</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="../room/manage">Rooms</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="../guest/manage">Guests</a>
        </li>

        <li>
            <a class="nav-link active" href="../user/manage">Users</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="../logout">Logout</a>
        </li>
    </ul>


</nav>


<form:form modelAttribute="guest" method="POST" class="form-horizontal">
    <div class="form-group">
        <div class="col-sm-4">
        Imię: <form:input path="firstName" class="form-control col-lg-5"/><br/>
        </div>
        <div class="col-sm-4">
        <label for="1"> Nazwisko:</label> <form:input path="lastName" id="1" class="form-control col-lg-5"/><br/>
        </div>
            <div class="col-sm-4">
        <label for="3"> Email :</label> <form:input path="email" class="form-control col-lg-5" id="3"/><br/>
            </div>
        <div class="col-sm-4">
            <label for="1"> Numer telefonu:</label> <form:input path="phoneNumber" id="4" class="form-control col-lg-5"/><br/>
        </div>

        <div class="col-sm-4">
        <input type="submit" value="Submit" class="btn btn-success"></input type><br><br>
        </div>

    </div>
</form:form>

</body>
</html>
