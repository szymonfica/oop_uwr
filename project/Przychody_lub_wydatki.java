/* Szymon Fica
 * 
 * Klasa przechowuje planowane i rzeczywiste przychody/wydatki.
 * 
 * 
 */

public class Przychody_lub_wydatki {
    
    public Listofevents planowane;
    public Listofevents rzeczywiste;

    // Konstruktor przyjmuje tylko dwa stringi, są to nazwy plików z danymi o
    // planowanych i rzeczywistych przychodach/wydatkach

    public Przychody_lub_wydatki(String p, String r){
        planowane = new Listofevents(p);
        rzeczywiste = new Listofevents(r);
    }
    
    // Metoda roznica() zwraca różnice pomiędzdy planowanymi i rzeczywistymi przychodami/wydatkami
    public int roznica() {
        return planowane.get_sum() - rzeczywiste.get_sum();
    }
    
}
