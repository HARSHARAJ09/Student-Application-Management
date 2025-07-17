package com.ps.StudentApp.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.ps.StudentApp.DAO.StudentDAO;
import com.ps.StudentApp.DAO.StudentDAOimplement;
import com.ps.StudentApp.DTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchuser")
public class SearchUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao = new StudentDAOimplement();
		ArrayList<Student> users = sdao.getStudent(req.getParameter("search"));

		req.setAttribute("users", users);
		RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
		rd.forward(req, resp);
		
	}
}
