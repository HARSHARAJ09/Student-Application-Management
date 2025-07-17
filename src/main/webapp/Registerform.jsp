<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <title>Pentagon Space - Application Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: left;
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        h4 {
            text-align: center;
            color: #007bff;
            margin-top: -10px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn {
            width: 100%;
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            margin-top: 20px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .login-link {
            text-align: center;
            margin-top: 10px;
        }
        .login-link a {
            color: #007bff;
            text-decoration: none;
        }
           .failur{
    color:red;
    }
    </style>
</head>
<body>
     <div class="container">
        <h2>Pentagon Space</h2>
        <h4>Application form</h4>
         <%String error=(String)request.getAttribute("error"); %>
    <%if(error!=null){ %>
    <h3 class="failur"><%=error %></h3>
    <%} %>
        <form action="Registerform" method="post">
        
            <label>Enter your Name:</label>
            <input type="text" name="name" required>

            <label>Enter the Phone number:</label>
            <input type="text" name="phone" required>

            <label>Enter the Mail ID:</label>
            <input type="email" name="email" required>

            <label>Enter the Branch:</label>
            <input type="text" name="branch" required>

            <label>Enter the Location:</label>
            <input type="text" name="location" required>

            <label>Enter the password:</label>
            <input type="password" name="password" required>

            <label>Confirm the password:</label>
            <input type="password" name="confirm_password" required>

            <button type="submit" class="btn">create account</button>

            <div class="login-link">
                already have a account? <a href="Login.jsp">login</a>
            </div>
            
        </form>
    </div>
</body>
</html>


   
