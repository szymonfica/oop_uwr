/* Szymon Fica
 * 
 * Program prezentuje działanie klasy Budżet
 * 
 * dane do klasy są wczytywane z plików: 
 * - planowane_wydatki.txt
 * - planowane_przychody.txt
 * - rzeczywiste_wydatki.txt
 * - rzeczywiste_przychody.txt
 * 
 * Wynik analizy Budżetu jest zapisywany w pliku : wynik.txt
 * 
 */

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
		
		Budzet B = new Budzet("Domowy", "planowane_wydatki.txt",
		"rzeczywiste_wydatki.txt", "planowane_przychody.txt",
		"rzeczywiste_przychody.txt");

		try {
			FileWriter myWriter = new FileWriter("wynik.txt");
			myWriter.write("Nazwa budżetu: " + B.nazwa + ".\n\n");
			myWriter.write("Bilans planowanego budżetu z podziałem na kategorie o priorytetach od 1 do 10:\n\n");
			myWriter.write(B.pelna_analiza() + "\n\n");
			myWriter.write("Planowany bilans dnia: 13.02.2022: " + B.plan_bilans_dnia("13.02.2022") + "\n");
			myWriter.write("Planowany bilans dnia: 27.07.2023: " + B.plan_bilans_dnia("27.07.2023") + "\n\n");
			myWriter.write(B.roznica_przychodow() + "\n");
			myWriter.write(B.roznica_wydatkow() + "\n\n");
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	
		
	
	}
}
