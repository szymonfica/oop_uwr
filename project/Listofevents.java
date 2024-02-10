/* Szymon Fica
 * 
 * Klasa Listofevents służy do przechowywania listy obiektów klasy Event,
 * będzie to lista wydatków lub przychodów.
 *  
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Listofevents {

    ArrayList<Event> list = new ArrayList<Event>();

    // Pierwszy konstruktor przyjmuje nazwę pliku w którym zapisane są dane o wydatkach/przychodach
    // i po wczytaniu ich tworzy odpowiednie obiekty
    public Listofevents(String file_name) {
        try {
			List<String> allLines = Files.readAllLines(Paths.get(file_name));
            for (String line : allLines) {
				int kwota = 0;
				String nazwa = "";
				String data = "";
				int it = 0;
				while(it < line.length()){
					if(line.charAt(it) == ' '){
						String str = line.substring(0, it);
						kwota = Integer.parseInt(str);
                        it++;
						break;
					}
					it++;
				}
				data = line.substring(it, it+10);
				it += 11;
                int it_beg = it;
                while(it < line.length()){
					if(line.charAt(it) == ' '){
						break;
					}
					it++;
				}
				nazwa = line.substring(it_beg, it);
                it++;
                int priority = Integer.parseInt(line.substring(it, line.length()));
				//System.out.println(kwota + " ~ " + nazwa + " ~ " + data);
                list.add(new Event(kwota, data, nazwa, priority));
			}
            sort();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    // Drugi konstruktor przyjmuje dwie listy Event i łączy je w jedną
    public Listofevents(ArrayList<Event> e1, ArrayList<Event> e2) {
        for (Event e : e1) {
            add_event(e.kwota, e.data, e.name, e.priority);
        }
        for (Event e : e2) {
            add_event(e.kwota, e.data, e.name, e.priority);
        }
        sort();
    }

    // Metoda add_event() dodania nowego obiektu Event do listy
    public void add_event(int k, String d, String n, int p) {
        Event e = new Event(k, d, n, p);
        list.add(e);
    }

    // Metoda get_by_name() zwraca Event z listy o nazwie podanej w argumencie 'key'
    public Event get_by_name(String key) throws Exception {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).name == key) {
                return list.get(i);
            }
        }
        throw new Exception("Brak szukanego elementu!");
    }

    // Metoda get_sum_by_date zwraca sumę wszystkich obiektów z podanego dnia w argumencie 'd'
    public int get_sum_by_date(String d) {
        int ans = 0;
        for (Event e : this.list) {
            String a = e.data, b = d;
            boolean w  = true;
            for(int i=0; i<=9; i++){
                if(a.charAt(i) != b.charAt(i)) {
                    w = false;
                }
            }
            if(w) ans += e.kwota;
        }
        return ans;
    }
    
    // Metoda get_sum() zwraca sumę wszystkich obiektów
    public int get_sum() {
        int sum = 0;
        for (Event e : this.list) {
            sum += e.kwota;
        }
        return sum;
    }

    // Metoda max_pref() zwraca maksymalną sumę na pewnym prefiksie posortowanym po dacie 
    public int max_pref(String date, int priority) {
        sort();
        int ans = 0, sum = 0;
        for (Event e : this.list) {
            if(e.data == date) {
                sum += e.kwota;
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

    // Metoda min_pref() zwraca minimalną sumę na pewnym prefiksie posortowanym po dacie 
    public int min_pref(int priority) {
        sort();
        int ans = 1000000000, sum = 0;
        for (Event e : this.list) {
            if(e.priority >= priority) {
                sum += e.kwota;
                ans = Math.min(sum, ans);
            }
        }
        return ans;
    }

    // Metoda min_pref_day() zwraca dzień w której stan konta jest najmniejszy
    public String min_pref_day(int priority) {
        sort();
        int sum = 0;
        String d = "";
        for (Event e : this.list) {
            if(e.priority >= priority) {
                sum += e.kwota;
                
                if(sum < 0){
                    d = e.data;
                    break;
                }
            }
        }
        return d;
    }

    // Metoda sort() sortuje listę przechowywanych obiektów
    public void sort() {
        this.list.sort((o1, o2) -> o1.get_date().compareTo(o2.get_date()));
    }

    @Override
    public String toString() {
        String ans = "";
        for (Event e : this.list) {
            ans += e.name + " " + e.kwota + " " + e.data + " " + e.priority + "\n";
        }
        return ans;
    }

    // Metoda mul() przemnaża kwotę każdego obiektu w liście przez argument
    public void mul(int x) {
        for (Event e : this.list) {
            e.kwota *= x;
        }
    }


}
