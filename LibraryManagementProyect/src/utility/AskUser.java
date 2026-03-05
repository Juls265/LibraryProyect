package utility;

import java.util.Scanner;

public class AskUser {
	public static void main(String[] args) {
		int num1=askInt("Give me an Int");
		double num2=askDouble("Give me a double");
		float num3=askFloat("Give me a float");
		char character=askChar("Give me a character");
		String string=askString("Give me a String");
	}
	
	public static int askInt(String message) {
		Scanner keyboard=new Scanner(System.in);
		int n;
		System.out.println(message);
		n=keyboard.nextInt();
		return n;
	}//ask integer
	
	public static double askDouble(String message) {
		Scanner keyboard=new Scanner(System.in);
		double d;
		System.out.println(message);
		d=keyboard.nextDouble();
		return d;
	}//ask double
	
	public static float askFloat(String message) {
		Scanner keyboard=new Scanner(System.in);
		float f;
		System.out.println(message);
		f=keyboard.nextFloat();
		return f;
	}//ask float
	
	public static char askChar(String message) {
		Scanner keyboard=new Scanner(System.in);
		char c;
		System.out.println(message);
		c=keyboard.next().charAt(0);
		return c;
	}//ask float
	
	public static String askString(String message) {
		Scanner keyboard=new Scanner(System.in);
		String line;
		System.out.println(message);
		line=keyboard.nextLine();
		return line;
	}
	
	public static boolean repeat() {
		Scanner keyboard=new Scanner(System.in);
		String auxStr;
		System.out.println("Repeat?(y/n)");
		auxStr=keyboard.nextLine();
		if(auxStr.charAt(0)=='y' ||auxStr.charAt(0)=='Y') {
			return true;
		}else {
			return false;
		}
	}
}