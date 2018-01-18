package ex2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		String senha = scn.next();
		String pattern = "^(?=.{8,15}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).*$";
		System.out.println(senha.matches(pattern));
		
		scn.close();
	}

}
