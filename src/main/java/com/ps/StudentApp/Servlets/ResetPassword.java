package com.ps.StudentApp.Servlets;

import java.io.IOException;

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

@WebServlet("/Reset")
public class ResetPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		StudentDAO sdao = new StudentDAOimplement();
		Student s = (Student) session.getAttribute("student");
		if (s != null) {
			System.out.println(req.getParameter("phone"));
			if (Long.parseLong(req.getParameter("phone")) == s.getPhone() && req.getParameter("mail").equals(s.getMail())) {
				if (req.getParameter("password").equals(req.getParameter("confirm"))) {
					s.setPassword(req.getParameter("password"));
					boolean res = sdao.updateStudent(s);
					if (res) {
						req.setAttribute("success", "Password updated successfully!");
						RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
						rd.forward(req, resp);
					} else {
						req.setAttribute("error", "Failed to update the password!");
						RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
						rd.forward(req, resp);
					}
				} else {
					req.setAttribute("error", "Password mismatch!");
					RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("error", "Something went wrong!");
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("error", "Session expired!");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}
}
