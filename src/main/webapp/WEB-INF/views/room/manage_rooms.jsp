<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 19.06.18
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage rooms</title>
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
            <a class="nav-link" href="..../logout">Logout</a>
        </li>
    </ul>
    <ul class="nav navbar-nav ml-auto w-100 justify-content-end">
        <li>
            <a class="nav-link active" href="add">Add new room</a>
        </li>

    </ul>

</nav>


<div class="container">
    <table class="table table-striped">
        <thead class="thead">
        <tr>
            <th scope="col">Room numer</th>
            <th scope="col">Room occupants</th>
            <th scope="col">Room type</th>
            <th scope="col">Room price</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${rooms}" var="rooms">
            <tr>
                <td>${rooms.number}</td>
                <td>${rooms.occupants}</td>
                <td>${rooms.type}</td>
                <td>${rooms.roomPrice}</td>
                <td>

                    <a href="changePrice?id=${rooms.id}" class="btn-secondary btn-sm" role="button">Change room's price</a>
                    <a href="confirmDelete?id=${rooms.id}&number=${rooms.number}" class="btn-secondary btn-sm"
                       role="button">Delete room</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>


</body>
</html>
