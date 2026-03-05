package exercice;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		String menu[]= {"1.Register User", "2.Issue Book Loan", "3.Return Book", "4.Check User Status", "5.Show Active Loans", "6.Show Sanction Users", "7.Update Sanctions", "8.Exit"};
		int action=0;
		
		do {
			printMenu(menu);
			System.out.println("What do you want to do?");
			action=keyboard.nextInt();
			switch (action) {
			case 1:
				
				break;
				
			case 2:
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