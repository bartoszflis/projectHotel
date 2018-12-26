<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 19.06.18
  Time: 20:54
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
            <a class="nav-link" href="../reservation/manage">Reservations</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="manage">Rooms</a>
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


<p class="h3">Add/Edit Room</p>



<form:form modelAttribute="room" method="POST" class="form-horizontal">
<div class="form-group ">
    <div class="col-sm-4">
        <label for="one">Room number: </label>
        <form:input type="text" pattern="\d*"  path="number" class="form-control" id="one"/><br>
    </div>
    <div class="col-sm-4">
        <label for="two">Number of occupants: </label>
        <form:select items="${occupants}" path="occupants" class="form-control" id="two"/><br>
    </div>
    <div class="col-sm-4">
        <label for="three">Room type:</label>
        <form:select items="${type}" path="type" class="form-control" id="three"/><br>

    </div>
    <div class="col-sm-4">
        <label for="four">Price per night(PLN):</label>
        <form:input type="text" pattern="\d*" path="RoomPrice" class="form-control" id="four"/><br>


    </div>


    <div class="col-sm-4">
        <input type="submit" value="Submit" class="btn btn-success"></input type><br>
    </div>
    </form:form>
   <p style="color: red"> ${requestScope.error}</p>

</div>
</body>
</html>
