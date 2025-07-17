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

@WebServlet("/updateAccount")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Student s = (Student) session.getAttribute("student");
		StudentDAO sdao = new StudentDAOimplement();
		if (s != null) {
			s.setName(req.getParameter("name"));
			s.setPhone(Long.parseLong(req.getParameter("phone")));
			s.setMail(req.getParameter("mail"));
			s.setBranch(req.getParameter("branch"));
			s.setLoc(req.getParameter("loc"));
			boolean res = sdao.updateStudent(s);
			if (res) {
				req.setAttribute("success", "Account updated successfully!");
				RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("error", "Failed to update!");
				RequestDispatcher rd = req.getRequestDispatcher("updateAccount.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("error", "Session Expired!");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}
}
