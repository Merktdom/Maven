package de.hfu;
import java.util.Scanner;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Gib deinen Text ein: " );

		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		scan.close();

		System.out.println("Dein Text lautet: " + text.toUpperCase());
	}
}
