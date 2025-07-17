<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Pentagon Space - Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f2f2f2;
      display: flex;
      height: 100vh;
      justify-content: center;
      align-items: center;
    }

    .login-container {
      background: white;
      padding: 40px;
      border-radius: 8px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
      width: 300px;
      text-align: center;
    }

    h2 {
      color: #003366;
    }

    input[type="email"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border-radius: 4px;
      border: 1px solid #ccc;
    }

    button {
      background-color: #2d7f5e;
      color: white;
      padding: 10px;
      border: none;
      width: 100%;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #25694e;
    }

    .links {
      margin-top: 15px;
      font-size: 14px;
    }

    .links a {
      text-decoration: none;
      color: #0066cc;
    }
    .success{
    color:green;
    }
    .failure{
    color:red;
    }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>Pentagon Space</h2>
    <h2>Login</h2>
    <%String success=(String)request.getAttribute("success"); %>
    <%if (success!=null){ %>
   <h3 class="success" ><%=success %></h3>
    <%}%>
    <%String error=(String)request.getAttribute("error"); %>
    <%if(error!=null){ %>
    <h3 class="failure"><%=error %></h3>
    <%} %>
    <form action="Login" method="post">
      <input type="email" placeholder="Enter your mail ID" name="email" required />
      <input type="password" placeholder="Enter the password" name="password" required />
      <button type="submit">Login</button>
    </form>
    <div class="links">
      <a href="Forgot.jsp">forgot password?</a><br />
      <p>Don't have an account? <a href="Registerform.jsp">Signup</a></p>
    </div>
  </div>
</body>
</html>