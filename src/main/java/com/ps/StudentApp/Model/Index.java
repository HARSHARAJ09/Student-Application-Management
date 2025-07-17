package com.ps.StudentApp.Model;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int choice=0;
		System.out.println("Welcom to Student App");
		do {
			System.out.println("1. Sing Up");
			System.out.println("2. Login");
			System.out.println("3. Forgot Password");
			System.out.println("4. Exit");
			choice =sc.nextInt();
			switch(choice) {
			case 1:Singup.signup();
				break;
			case 2:Login.login();
				break;
			case 3:Password.forgot();
				break;
			case 4://Exit
				System.out.println("THANK YOU");
				break;
			default:
				System.err.println("Invalid choice, Try Again!");
				break;
			}
		}while(choice!=4) ;
					
		}	
	

}
