package exercice;

import java.time.LocalDate;

public class MainPruebas {
	public static void main(String[] args) {
		try {
			User user=new User("anselmo", "anselmo@tia.es", "SOC00001", LocalDate.now());
			Loan loan=new Loan("LIB0001", "Libro", user, LocalDate.of(2026, 2, 20));
			
			System.out.println(loan.toString());
			System.out.println(loan.isOverdue());
			System.out.println("delay -->"+loan.calculateDelayDays());
			
		}catch (Exception e) {
			System.out.println("A");
		}
	}
}