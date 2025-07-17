package com.ps.StudentApp.DAO;

import java.util.ArrayList;

import com.ps.StudentApp.DTO.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);//create
	public boolean updateStudent(Student s);//update
	public boolean deleteStudent(int id);//delete
	public Student getStudent(String mail, String password);//retrieve
	public Student getStudent(long phone,String mail);//retrieve
	public ArrayList<Student> getStudent();//retrieve
	public ArrayList<Student> getStudent(String name);//retrieve
	boolean deleteStudent(Student s);
}
