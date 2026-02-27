package exercice;

import java.time.LocalDate;
import java.util.Scanner;

import exceptions.InvalidLoanException;

public class Loan {
	/*
	 * Attributes: 
	 * bookCode (String): 3 uppercase letters + 4 digits (e.g., LIB0001), bookTitle (String), member (User object): The user making the loan
	 * loanDate (LocalDate), dueDate (LocalDate), actualReturnDate (LocalDate): null if the book hasn't been returned yet.
	 * 
	 * Methods: 
	 * Constructor: Receives bookCode, user, title, and loanDate. If the code is invalid, the title is empty, or the date is null/in the future,
	 * throw an InvalidLoanException. The dueDate is calculated by adding 14 days to the loanDate. 
	 * registerReturn(LocalDate date): Sets the return date. Throws InvalidLoanException if the date is null or prior to the loan date.
	 * calculateDelayDays(): Returns the integer difference between dueDate and actualReturnDate. If not yet returned, use the current date.
	 * Returns zero if there is no delay.
	 * isOverdue(): Boolean. Compares dueDate with the current date. 
	 * toString(): Returns loan details. 
	 */
	private String bookCode;
	private String bookTitle;
	private User member;
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate actualReturnDate;
	
	public Loan(String bookCode, String bookTitle, User member, LocalDate loanDate) throws InvalidLoanException {
		setBookCode(bookCode);
		this.bookTitle = bookTitle;
		this.member = member;
		this.loanDate = loanDate;
	}
	
	/**
	 * Sets the return date.
	 * Throws InvalidLoanException if the date is null or prior to the loan date.
	 * @param date
	 * @throws InvalidLoanException 
	 */
	public void registerReturn(LocalDate date) throws InvalidLoanException {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter the date the book has been return: ");
		String returnDate=keyboard.nextLine();
		date=LocalDate.parse(returnDate);
		if(date==null) {
			throw new InvalidLoanException("Error: date not entered.");
		}else if (date.isBefore(loanDate)) {
			throw new InvalidLoanException("Error: date not correct.");
		}else {
			setActualReturnDate(date);
		}
	}
	
	/**
	 * Returns the integer difference between dueDate and actualReturnDate. If not yet returned, use the current date.
	 * Returns zero if there is no delay.
	 * @return
	 */
	public int calculateDelayDays() {
		int dateDiff;
		if(actualReturnDate==null) {
			dateDiff=dueDate.compareTo(LocalDate.now());
		}else {
			dateDiff=dueDate.compareTo(actualReturnDate);
		}
		return dateDiff;
	}
	
	/**
	 * Return a boolean. Compares dueDate with the current date.
	 * @return
	 */
	public boolean isOverdue() {
		return dueDate.equals(actualReturnDate);
	}
	
	@Override
	public String toString() {
		return "Loan [Book code: "+bookCode+", Book title: "+bookTitle+", User: "+member+", Loan date: "+loanDate+", Due date: "+dueDate+", Actual return date: "+actualReturnDate+"]";
	}

	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) throws InvalidLoanException {
		String reg="[A-Z]{3}[0-9]{4}";
		if(bookCode.matches(reg)) {
			this.bookCode = bookCode;
		}else {
			throw new InvalidLoanException("Book code not valid.");
		}
	}

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public User getMember() {
		return member;
	}
	public void setMember(User member) {
		this.member = member;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		dueDate=loanDate.plusDays(14);
		this.dueDate = dueDate;
	}
	
	public LocalDate getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(LocalDate actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
}