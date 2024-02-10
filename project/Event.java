/* Szymon Fica
 * 
 * Klasa Event reprezentuje pojedyńczy wydatek lub przychód,
 * każdy obiekt zawiera cztery wartości podawane w konstruktorze:
 * kwota, data, nazwa i piorytet
 * 
 * Metoda get_date() zwraca datę obiektu przeliczoną w odowiedni sposób ze stringa na inta,
 * metoda jest używana do porównywania dwóch obiektów przy sortowaniu
 */

public class Event {
    
    public int kwota;
    public String data;
    public String name;
    public int priority;

    public Event(int kwota, String data, String name, int priority){
        this.kwota = kwota;
        this.data = data;
        this.name = name;
        this.priority = priority;
    }

    public Integer get_date() {
        int dd = Integer.parseInt(this.data.substring(0, 2));
        int mm = Integer.parseInt(this.data.substring(3, 5));
        int rr = Integer.parseInt(this.data.substring(6, 10));
        int ans =  (rr * 10000 + mm * 100 + dd);
        return ans;
    }
}
