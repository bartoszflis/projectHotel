<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Price</title>
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


<p class="h3">Change price of room number: ${room.number}</p>



<form:form modelAttribute="room" method="POST" class="form-horizontal">
<div class="form-group ">
  <form:hidden path="id"/>
  <form:hidden path="occupants"/>
  <form:hidden path="number"/>
  <form:hidden path="type"/>
    <div class="col-sm-4">
        <label for="four">Price per night(PLN):</label>
        <form:input type="text" pattern="\d*" path="roomPrice" class="form-control" id="four"/><br>


    </div>


    <div class="col-sm-4">
        <input type="submit" value="Submit" class="btn btn-success"></input type><br>
    </div>
    </form:form>
    <p style="color: red"> ${requestScope.error}</p>

</div>
</body>
</html>
