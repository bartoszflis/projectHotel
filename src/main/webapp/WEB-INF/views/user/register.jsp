<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Twitter - rejestracja</title>

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
            <a class="nav-link" href="../room/manage">Rooms</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="../guest/manage">Guests</a>
        </li>

        <li>
            <a class="nav-link active" href="manage">Users</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/logout">Logout</a>
        </li>
    </ul>


</nav>


<h2 align="center">Zarejestruj nowego użytkownika</h2>

<div class="container">


    <form:form modelAttribute="user" method="POST" class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-sm-2" for="email">Email:</label>
        <div class="col-sm-4">
            <form:input path="email" class="form-control" name="email"/><br/>
        </div>
    </div>
    <div class="form-group">

        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First Name:</label>
            <div class="col-sm-4">
                <form:input path="firstName" class="form-control" name="firstName"/><br/>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lastName">Last Name:</label>
                <div class="col-sm-4">
                    <form:input path="lastName" class="form-control" name="lastName"/><br/>
                </div>
            </div>
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-4">
                <form:password path="password" class="form-control" name="pasword"/><br/>
            </div>

            <div class="col-sm-4">
                <label for="three">User type:</label>
                <form:select items="${type}" path="type" class="form-control" id="three"/><br>

            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="Submit" class="btn btn-success"></input>
                </div>
            </div>
            </form:form>
        </div>
    </div>

</body>
</html>