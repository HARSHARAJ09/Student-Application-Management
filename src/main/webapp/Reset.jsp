<%@page import="com.ps.StudentApp.DTO.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f4f8;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .form-container {
        background-color: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        width: 400px;
        text-align: center;
    }
    h1 {
        color: #002366;
        margin-bottom: 10px;
    }
    h2 {
        color: #0077cc;
        font-size: 18px;
        margin-bottom: 20px;
    }
    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 90%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        background-color: #28a745;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #218838;
    }
    .back-button {
        background-color: #007bff;
        color: white;
        padding: 8px 15px;
        text-decoration: none;
        border-radius: 5px;
        margin-top: 10px;
        display: inline-block;
    }
    .back-button:hover {
        background-color: #0056b3;
    }
    .failure{
    color:red;
    }
</style>
</head>
<body>
<%Student s=(Student)session.getAttribute("student");%>

<div class="form-container">
<h1>Pentagon Space</h1>
<h2 >Reset your password here</h2>
   <%String error=(String)request.getAttribute("error"); %>
    <%if(error!=null){ %>
    <h3 class="failure"><%=error %></h3>
    <%}%>
<form action="Reset" method="post">
       
        Enter your Phone number:
        <input type="text" name="phone" required value="<%=s.getPhone()%>"><br><br>
        Enter your mail:
        <input type="email" name="mail"  required value="<%=s.getMail()%>"><br><br>
        Enter your password:
        <input type="password" name="password" required ><br><br>
        Enter your conform password:
        <input type="password" name="confirm" required><br><br>
        <input type="submit" value="Reset Password">
    </form>
    <a href="Login.jsp" class="back-button">Back</a>
   </div> 
</body>
</html>
</body>
</html>