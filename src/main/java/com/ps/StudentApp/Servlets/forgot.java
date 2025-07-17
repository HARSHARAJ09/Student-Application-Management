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

@WebServlet("/Forgot")
public class forgot extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		StudentDAO sdao=new StudentDAOimplement();
		PrintWriter out=resp.getWriter();
		
		s = sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("mail"));
		if (s != null) {
			if (req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("password"));
				boolean res = sdao.updateStudent(s);
				if (res) {
					//out.println("<h1>Password Updated successfully!!</h1>");
					req.setAttribute("success", "Password Updated successfully");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
				} else {
					//out.println("<h1>Failed to Update the password</h1>");
					req.setAttribute("error","Failed to Update the password!");
					RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
					rd.forward(req, resp);
				}
			} else {
				//out.println("<h1>Password mismatch</h1>");
				req.setAttribute("error","Password Mismatch!");
				RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
				rd.forward(req, resp);
			}
		}
	}
}
