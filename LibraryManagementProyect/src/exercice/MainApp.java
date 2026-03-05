package exercice;

import java.time.LocalDate;
import java.util.Scanner;

import exceptions.BooknotAvailableException;
import exceptions.InvalidLoanException;
import exceptions.InvalidUserException;
import exceptions.RepeatedUserException;
import utility.AskUser;

public class MainApp {
	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		String menu[]= {"1.Register User", "2.Issue Book Loan", "3.Return Book", "4.Check User Status", "5.Show Active Loans", "6.Show Sanction Users", "7.Update Sanctions", "8.Exit"};
		int action=0;
		User xUser;
		
		
		do {
			printMenu(menu);
			System.out.println("What do you want to do?");
			action=keyboard.nextInt();
			switch (action) {
			case 1:
				String name=AskUser.askString("Enter the name: ");
				String email=AskUser.askString("Enter the email: ");
				String memberNum=AskUser.askString("Enter the member number: ");
				String date=AskUser.askString("Enter the registation date (aaaa-mm-dd): ");
				LocalDate regDate=LocalDate.parse(date);
				try {
					xUser=new User(name, email, memberNum, regDate);
//					xUser=new User("Nombre", "persona@gmail.com", "SOC01225", LocalDate.of(2020, 03, 14));
					LibraryManager newUser= new LibraryManager();
					newUser.registerUser(xUser);
				} catch (InvalidUserException excIUE) {
					excIUE.printStackTrace();
				} catch (RepeatedUserException excRUE) {
					excRUE.printStackTrace();
				}
				break;
			case 2:
				String bookCode=AskUser.askString("Enter the book code: ");
				String bookTitle=AskUser.askString("Enter the title of the book: ");
				String member=AskUser.askString("Enter the library member: ");
				int index=LibraryManager.users.indexOf(member);
				User libraryMember= LibraryManager.users.get(index);
				String xDate=AskUser.askString("Enter the loan date: ");
				LocalDate loanDate=LocalDate.parse(xDate);
				try {
					Loan xLoan=new Loan(bookCode, bookTitle, libraryMember, loanDate);
//					Loan xLoan=new Loan("LIB0427", "Nombre", xUser, LocalDate.of(2026, 01, 31));
					LibraryManager newLoan= new LibraryManager();
					newLoan.registerLoan(xLoan);
				} catch (InvalidLoanException e) {
					e.printStackTrace();
				} catch (BooknotAvailableException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				System.out.println("End of program.");
				break;
				
			default:
				System.out.println("Wrong number, try again.");
				break;
			}
			
		}while (action!=8);
		
	}
	
	public static void printMenu(String menu[]) {
		for(int i=0;i<menu.length;i++) {
			System.out.println(menu[i]);
		}
	}
}