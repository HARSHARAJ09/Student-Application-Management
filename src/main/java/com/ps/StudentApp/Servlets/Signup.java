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

@WebServlet("/Registerform")
public class Signup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Creation of POJO class object
		Student s=new Student();
		StudentDAO sdao=new StudentDAOimplement();
//		PrintWriter out=resp.getWriter();
		
		//Collecting the data from the UI
		//String name=req.getParameter("name");
		//s.setName(name);
		
		s.setName(req.getParameter("name"));
		
		//String phone =req.getParameter("phone");
		//long phone_no=Long.parseLong(phone);//inbuilt method in wrapper class
		//s.setPhone(phone_no);
		
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("email"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("location"));
		if(req.getParameter("password").equals(req.getParameter("confirm_password"))){
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data saved successfully!!</h1>");
				req.setAttribute("success", "Account created successfully");//Packaging
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");//Destination
				rd.forward(req, resp);//Delivery guy
			}
			else {
				//out.println("<h1>Failed to save data</h1>");
				req.setAttribute("error","Failed to create an account!");
				RequestDispatcher rd=req.getRequestDispatcher("Registerform.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Password Mismatch</h1>");
			req.setAttribute("error","Password Mismatch!");
			RequestDispatcher rd=req.getRequestDispatcher("Registerform.jsp");
			rd.forward(req, resp);
		}
	}
}
