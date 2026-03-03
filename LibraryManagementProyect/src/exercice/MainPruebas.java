package exercice;

import java.time.LocalDate;

import exceptions.InvalidLoanException;
import exceptions.InvalidUserException;

public class MainPruebas {
	public static void main(String[] args) {
		try {
			User user=new User("anselmo", "anselmo@tia.es", "SOC00001", LocalDate.now());
			Loan loan=new Loan("LIB0001", "Libro", user, LocalDate.of(2026, 2, 3));
			loan.registerReturn(LocalDate.of(2026, 2, 18));
			
			
		}catch (InvalidUserException e) {
			System.out.println("Problem");
		}catch (InvalidLoanException e) {
			System.out.println("Problem");
		}
	}
}