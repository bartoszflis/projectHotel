<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 19.06.18
  Time: 22:18
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



<h5>Do you really want to delete room number ${param.number} ?</h5>
<a href="delete?id=${param.id}" class="btn-secondary btn-sm" role="button">OK</a>
<a href="manage" class="btn-secondary btn-sm" role="button">Cancel</a>
</body>
</html>
