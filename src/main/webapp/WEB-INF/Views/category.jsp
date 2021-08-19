<%--
  Created by IntelliJ IDEA.
  User: nuke
  Date: 22.07.2021
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Category Page</title>

    <link rel="stylesheet" href=https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css>
    <script src=https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js></script>
    <script src=https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js></script>

    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

        .btn {

            width: 100%;
        }


    </style>
</head>
<body>
<h1>Loan Records</h1>



<div class="container">


    <h1 id="mes">${errorMessage}</h1>
    <div class="container2">
        The following are the loan records...

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Client number</th>
                <th>Client Name</th>
                <th>Loan Amount</th>
                <th>Number of years</th>
                <th>Loan Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">



                <tr>


                    <td>${todo.clientno}</td>
                    <td>${todo.clientname}</td>
                    <td>${todo.loanamount}</td>
                    <td>${todo.years}</td>
                    <td>${todo.loantype}</td>


                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.clientno}" >Edit</a> </td>



                    <td>    <a type="button" class="btn btn-primary"
                               href="delete-todo?id=${todo.clientno}" >Delete</a> </td>



                    <td>    <a type="button" class="btn btn-primary" onmouseout="myFunction()"
                               href="see-todo?id=${todo.clientno}" >Amortization Table</a> </td>


                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>

    <form method="GET">

        <a class="btn btn-success" href="add-todo">Add</a>
    </form>


</div>

<script>

    function myFunction() {

        document.getElementById("mes").innerHTML = "";
    }

</script>

</body>
</html>
