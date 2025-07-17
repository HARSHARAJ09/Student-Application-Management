package com.ps.StudentApp.Model;

import java.util.ArrayList;
import java.util.Scanner;

import com.ps.StudentApp.DAO.StudentDAO;
import com.ps.StudentApp.DAO.StudentDAOimplement;
import com.ps.StudentApp.DTO.Student;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOimplement();
		int choice=0;
		System.out.println("Enter the mail ID");
		String mail=sc.next();
		System.out.println("Enter the password");
		String pass=sc.next();
		Student s=sdao.getStudent(mail, pass);
		if(s!=null) {
		System.out.println("Logged in successfully, Welcome "+s.getName());
		do {
		System.out.println("1. View your account");
		System.out.println("2. Update the Account");
		System.out.println("3. Reset Password");
		System.out.println("4. Search user");
		System.out.println("5. Back to main menu");
		if(s.getId()==1) {
		System.out.println("6. View All users");
		System.out.println("7. Delete User");
		}
		choice=sc.nextInt();
		switch(choice) {
		case 1: System.out.println(s);
		break;
		case 2: Update.update(s);
		break;
		case 3: Password.forgot();
		break;
		case 4: System.out.println("Enter the user name:");
		ArrayList<Student> studentsList=sdao.getStudent(sc.next());
		for(Student s2:studentsList) {
		System.out.println("==========================");
		System.out.println("Id:"+s2.getId());
		System.out.println("Name:"+s2.getName());
		System.out.println("Branch"+s2.getBranch());
		System.out.println("==========================");
		}
		break;
		case 5: System.out.println("Going back to main menu...");
		break;
		case 6:
		ArrayList<Student> students=sdao.getStudent();
		for(Student s1:students) {
		System.out.println(s1);
		}
		break;
		case 7: System.out.println("Enter the Student ID to be deleted:");
		boolean res=sdao.deleteStudent(sc.nextInt());
		if(res) {
		System.out.println("Data deleted successfully");
		}
		else {
		System.out.println("Failed to delete the data");
		}
		default: System.out.println("Invalid choice!");
		break;
		}
	}
	while(choice!=5);
		}
		else {
			System.out.println("Failed to login!");
		}
	}
}
		
	
		
			