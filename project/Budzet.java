/* Szymon Fica
 * 
 * Klasa Budżet to główna klasa w projekcie,
 * przechowuje wszystkie dane o budżecie i udostępnia metody
 * pomagające analizę planowanego budżetu
 * 
 */

public class Budzet {

    public String nazwa;
    public Przychody_lub_wydatki W;
    public Przychody_lub_wydatki P;

    // Konstruktor w argumentach przyjmuje nazwę budżetu oraz nazwy plików ze wszystkimi danymi
    public Budzet(String nazwa, String plan_wyd, String rzecz_wyd, String plan_przy, String rzecz_przy){
        this.nazwa = nazwa;
        W = new Przychody_lub_wydatki(plan_wyd, rzecz_wyd);
        P = new Przychody_lub_wydatki(plan_przy, rzecz_przy);
    }

    // Metoda plan_bilans_dnia() zwraca planowany bilans przychodów i wydatków danego dnia
    public int plan_bilans_dnia(String data){
        return P.planowane.get_sum_by_date(data) - W.planowane.get_sum_by_date(data);
    }
    
    // Metoda rzecz_bilans_dnia() zwraca rzeczywisty bilans przychodów i wydatków danego dnia
    public int rzecz_bilans_dnia(String data){
        return P.rzeczywiste.get_sum_by_date(data) - W.rzeczywiste.get_sum_by_date(data);
    }

    // // Metoda analiza_planu() zwraca true/false w zależności czy pewnego dnia wydatki przekraczają przychody
    public boolean analiza_planu(Listofevents wyd, Listofevents przy, int prio) {
        wyd.mul(-1);
        Listofevents sum = new Listofevents(wyd.list, przy.list);
        if(sum.min_pref(prio) < 0) {
            wyd.mul(-1);
            return false;
        }
        wyd.mul(-1);
        return true;
    }

    // Metoda analiza_planu_dzien() zwraca datę pierwszego dnia w którym planowany bilans budżetu jest ujemny
    public String analiza_planu_dzien(Listofevents wyd, Listofevents przy, int prio) {
        wyd.mul(-1);
        Listofevents sum = new Listofevents(wyd.list, przy.list);
        String ans = sum.min_pref_day(prio);
        wyd.mul(-1);
        return ans;
    }
    
    // Metoda pelna_analiza() wypisuje pełną analizę z podziałem na priorytety od 1 do 10
    public String pelna_analiza() {
        String ans = "";
        for(int i=10; i>=1; i--) {
            if(analiza_planu(W.planowane, P.planowane, i)) {
                ans = ans + "Bilans przychodów i wydatków o priorytecie " + i + " jest dodatni.\n";
            }
            else {
                ans = ans + "Wydatki o priorytecie " + i +
                " przekraczają przychody od dnia " +  analiza_planu_dzien(W.planowane, P.planowane, i) + ".\n";
            }
        }
        return ans;
    }

    // Metoda roznica_wydatkow() zwraca różnice pomiędzy planowanymi a rzeczywistymi wydatkami
    public String roznica_wydatkow() {
        String ans = "Różnica pomiędzy planowanymi a rzeczywistymi wydatkami wynosi: " + W.roznica();
        return ans;
    }

    // Metoda roznica_przychodow() zwraca różnice pomiędzy planowanymi a rzeczywistymi przychodami
    public String roznica_przychodow() {
        String ans = "Różnica pomiędzy planowanymi a rzeczywistymi przychodami wynosi: " + P.roznica();
        return ans;
    }



}
