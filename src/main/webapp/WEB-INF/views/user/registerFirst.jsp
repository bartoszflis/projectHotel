<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Bartosz
  Date: 26.12.2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Twitter - rejestracja</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style>
    .error {
        color: red;
    }


</style>
</head>
<body style="background-color:#FFFAF0">

<h2 align="center">Zarejestruj nowego użytkownika</h2>

<div class="container">


    <form:form modelAttribute="user" method="POST" class="form-horizontal">

    <div class="form-group">
        <label class="control-label col-sm-2" for="email">Email:</label>
        <div class="col-sm-4">
            <form:input path="email" class="form-control" name="email"/><form:errors path="email" cssClass="error"/><br/>
        </div>
    </div>
    <div class="form-group">

        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First Name:</label>
            <div class="col-sm-4">
                <form:input path="firstName" class="form-control" name="firstName"/><form:errors path="firstName" cssClass="error"/> <br/>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lastName">Last Name:</label>
                <div class="col-sm-4">
                    <form:input path="lastName" class="form-control" name="lastName"/><form:errors path="lastName" cssClass="error"/><br/>
                </div>
            </div>
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-4">
                <form:password path="password" class="form-control" name="pasword"/><form:errors path="password" cssClass="error"/><br/>
            </div>

            <form:hidden path="type" value = "Admin"/><br>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="Submit" class="btn btn-success">
                </div>
            </div>
            </form:form>
        </div>
    </div>










</body>
</html>
