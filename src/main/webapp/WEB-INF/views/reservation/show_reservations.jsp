<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 19.06.18
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <title>Title</title>

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





<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Room</th>
            <th scope="col">Guest</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
            <th scope="col">Created</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations}" var="reservation">
            <td>${reservation.id}</td>
            <td>${reservation.room.numer}</td>
            <td>${reservation.guest.id}</td>
            <td>${reservation.from}</td>
            <td>${reservation.to}</td>
            <td>${reservation.created}</td>
            <td> <button onClick="javascript:location.href='delete?id=${reservation.id}'">Usuń rezerwację</button>
                <button onClick="javascript:location.href='add?id=${reservation.id}'">Edytuj rezerwację</button>

            </td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
