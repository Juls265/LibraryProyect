package exercice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.BooknotAvailableException;
import exceptions.InvalidLoanException;
import exceptions.InvalidUserException;
import exceptions.RepeatedUserException;

public class LibraryManager {
	ArrayList<User> users=new ArrayList<User>();
	ArrayList<Loan> loans=new ArrayList<Loan>();
	
	/**
	 * Registers a new User into the users ArrayList
	 * @param newUser
	 * @throws InvalidUserException
	 * @throws RepeatedUserException
	 */
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
			throw new RepeatedUserException("ERROR: The user already exists");
		}else {
			users.add(newUser);
		}
	}
	
	/**
	 * Registers a new Loan into the loans ArrayList
	 * @param newLoan
	 * @throws InvalidLoanException
	 * @throws BooknotAvailableException 
	 */
	public void registerLoan(Loan newLoan) throws InvalidLoanException, BooknotAvailableException {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter the book code: ");
		String bookCode=keyboard.nextLine();
		
		if(loans.contains(bookCode)) {
			throw new BooknotAvailableException("ERROR: The book is not available.");
		}
		
		System.out.println("Enter the title of the book: ");
		String bookTitle=keyboard.nextLine();
		System.out.println("Enter the library member: ");
		String member=keyboard.nextLine();
		int index=users.indexOf(member);
		User libraryMember= users.get(index);
		System.out.println("Enter the loan date: ");
		String date=keyboard.nextLine();
		LocalDate loanDate=LocalDate.parse(date);
		
		loans.add(newLoan=new Loan(bookCode, bookTitle, libraryMember, loanDate));
	}
	
//	public boolean returnBook(String bookCode, LocalDate returnDate) {
//		
//	}
}