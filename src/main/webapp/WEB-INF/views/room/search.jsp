<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 19.06.18
  Time: 22:02
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


<form method="post" class="form-horizontal">
    <div class="form-group ">
        <div class="col-sm-4">
            <label for="1"> Start date: </label>

            <input type="date" name="Start" class="form-control col-lg-5" id="1" min="2018-01-02" value="2018-06-01" required> <br>
        </div>

        <div class="col-sm-4">
            <label for="2"> End date:</label>


            <input type="date" name="End" class="form-control col-lg-5" id="2" min="2018-01-02" value="2018-06-01"  required><br>
        </div>
        <div class="col-sm-4">


            <label for="3">Room type:</label>

            <select name="roomType" class="form-control col-lg-5" id="3"><br>
                <option value="Standard_Room">Standard Room</option>
                <option value="Special_Room">Special Room</option>
                <option value="Exclusive_Room">Exclusive Room</option>
            </select>
        </div>
        <div class="col-sm-4">
            <label for="4"> Occupants:</label>
            <select name="occupants" class="form-control col-lg-5" id="4">
                <option value="One">1</option>
                <option value="Two">2</option>
                <option value="Three">3</option>
                <option value="Four">4</option>
            </select><br>

        </div>
        <input type="submit" class="btn btn-success" value="Submit">
        <div style="color:red">${param.superError}</div>
    </div>
</form>
</body>
</html>
