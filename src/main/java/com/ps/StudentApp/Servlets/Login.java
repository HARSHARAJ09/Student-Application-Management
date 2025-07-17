package com.ps.StudentApp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.ps.StudentApp.DAO.StudentDAO;
import com.ps.StudentApp.DAO.StudentDAOimplement;
import com.ps.StudentApp.DTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	Student s=new Student();
        StudentDAO sdao = new StudentDAOimplement();
//        PrintWriter out = resp.getWriter();
        HttpSession session=req.getSession(true);

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        s= sdao.getStudent(email, password);

        if (s != null) {
//            out.println("<h1>Login Successful!</h1>");
//            out.println("<h2>Welcome, " + s.getName() + "</h2>");
//        	req.setAttribute("student", s);
        	session.setAttribute("student", s);
        	req.setAttribute("success", "Login successfull");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
        } else {
//            out.println("<h1>Invalid Email or Password</h1>");
        	req.setAttribute("error","Invalid Email or Password!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
        }
    }
}
