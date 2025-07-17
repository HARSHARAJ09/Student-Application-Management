package com.ps.StudentApp.Model;

import java.util.Scanner;

import com.ps.StudentApp.DAO.StudentDAO;
import com.ps.StudentApp.DAO.StudentDAOimplement;
import com.ps.StudentApp.DTO.Student;

public class Password {

	public static void forgot() {
		StudentDAO sdao=new StudentDAOimplement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone number:");
		long phone=sc.nextLong();
		System.out.println("Enter the mail ID");
		String mail=sc.next();
		Student s=sdao.getStudent(phone, mail);
		if(s!=null) {
		System.out.println("Set a new Password");
		String password=sc.next();
		System.out.println("Confirm the new password");
		String confirm=sc.next();
		if(password.equals(confirm)) {
		s.setPassword(password);
		boolean res=sdao.updateStudent(s);
		if(res) {
		System.out.println("Password updated!");
		}
		else {
		System.out.println("Failed to update the password!");
		}
		}
		else {
		System.out.println("Password mismatch");
		}
		}else {
		System.out.println("Student not found!");
		}
	}
}
		