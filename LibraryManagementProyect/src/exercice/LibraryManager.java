package exercice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidUserException;
import exceptions.RepeatedUserException;

public class LibraryManager {
	ArrayList<User> users=new ArrayList<User>();
	ArrayList<Loan> loans=new ArrayList<Loan>();
	
	public void registerUser(User newUser) throws InvalidUserException, RepeatedUserException {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter the name: ");
		String name=keyboard.nextLine();
		System.out.println("Enter the email: ");
		String email=keyboard.nextLine();
		System.out.println("Enter the member number: ");
		String memberNum=keyboard.nextLine();
		System.out.println("Enter the registation date: ");
		String date=keyboard.nextLine();
		LocalDate regDate=LocalDate.parse(date);
		newUser=new User(name, email, memberNum, regDate);
		
		if(users.contains(newUser)) {
			throw new RepeatedUserException("The user already exists");
		}else {
			users.add(newUser);
		}
	}
	
	public void registerLoan(Loan newLoan) {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter the book code: ");
		String bookCode=keyboard.nextLine();
		System.out.println("Enter the title of the book: ");
		String bookTitle=keyboard.nextLine();
		System.out.println("Enter the user: ");
		String user=keyboard.nextLine();
		users.indexOf(user);
		System.out.println("Enter the loan date: ");
		String date=keyboard.nextLine();
		LocalDate loanDate=LocalDate.parse(date);
	}
}