package de.hfu;
import java.util.Scanner;
/**
 * Aufgabe 5 von Open Source basierte Softwareentwicklung.
 * Übungsaufgabe mit Maven.
 * 
 * Diese Klasse liest Text ein und wandlet den Text in Großbuchstaben um.
 * 
 * @author dominik
 * @version 1.0
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Gib deinen Text ein: " );

		/**
		 * Die Scanner Klasse liest Text von der Konsole ein.
		 *
		 */
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		scan.close();

		System.out.println("Dein Text lautet: " + text.toUpperCase());
	}
}
