/*
 * Szymon Fica
 * lista 6, zadanie 1
 * 
 * zadanie implementuje listę z listy 3 zadania pierwszego w javie
 * 
 * vsc
 * 
 * javac Main.java
 * java Main
 * 
 * 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// klasa pojedynczego elementu z listy
class Elem<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    public Elem<T> prev, next;
    public T value;

    public Elem(T value)
    {
        this.value = value;
    }
}

// klasa implementująca listę obiektów klasy 'Elem'
class ListofElem<T> implements Serializable
{
    Elem<T> beg, end;

    public ListofElem()
    {
        beg = null;
        end = null;
    }

    // metoda dodająca element na koniec listy
    public void push_back(T value)
    {
        Elem<T> x = new Elem<T>(value);
        if(end != null)
        {
            end.next = x;
            x.prev = this.end;
        }
        else
        {
            this.beg = x;
        }
        this.end = x;
    }

    // metoda dodająca element na początek listy
    public void push_front(T value)
    {
        Elem<T> x = new Elem<T>(value);
        if(beg != null)
        {
            beg.prev = x;
            x.next = this.beg;
        }
        else
        {
            this.end = x;
        }
        this.beg = x;
    }

    // metoda usuwająca element z początku listy
    public T pop_front() throws Exception
    {
        if(this.is_empty()) throw new Exception("Pusta lista!");
        T x = this.beg.value;
        if(this.beg != this.end) // not last elem
        {
            this.beg = this.beg.next;
            this.beg.prev = null;
        }
        else
        {
            this.beg = null;
            this.end = null;
        }
        return x;
    }

    // metoda usuwająca element z końca listy
    public T pop_back() throws Exception
    {
        if(this.is_empty()) throw new Exception("Pusta lista!");
        T x = this.end.value;
        if(this.beg != this.end) // not last elem
        {
            this.end = this.end.prev;
            this.end.next = null;
        }
        else
        {
            this.beg = null;
            this.end = null;
        }
        return x;
    }

    // metoda zwracająca czy lista jest pusta
    public boolean is_empty()
    {
        return this.beg == null;
    }
}


public class Main
{
    public static void main(String[] args)
    throws IOException, ClassNotFoundException, Exception 
    {   
        ListofElem<String> list = new ListofElem<String>();

        System.out.println("Stworzyłem listę 'list' = ListofElem<String>\n");

        System.out.println("Wrzucam do listy elementy:\n");

        System.out.println("push_front: 'pies'");
        System.out.println("push_front: 'rybka'");
        System.out.println("push_front: 'tygrys'");
        System.out.println("push_front: 'bonifacy'");
        System.out.println("push_back: 'lew'");
        System.out.println("push_back: 'kot'");
        System.out.println("");

        list.push_back("pies");
        list.push_back("rybka");
        list.push_back("tygrys");
        list.push_back("bonifacy");
        list.push_front("lew");
        list.push_front("kot");

        try{
            FileOutputStream fileOutput = new FileOutputStream("plik1");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            objOutput.writeObject(list);
            objOutput.close();
            fileOutput.close();
            System.out.println("Udane zapisanie danych!");
        } catch (IOException e){
            System.out.println("Error podczas zapisywania danych!");
        }

        try{
            FileInputStream fileInput = new FileInputStream("plik1");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            ListofElem<?> inputList = (ListofElem<?>) objInput.readObject();

            objInput.close();
            fileInput.close();
            System.out.println("Udane odczytywanie danych!");

            System.out.println("");
            System.out.println("Zawartość listy: ");
            
            while(!inputList.is_empty()){
                System.out.println(inputList.pop_back());
            }
        } catch (IOException e){
            System.out.println("Error podczas odczytywania danych!");
        } catch (ClassNotFoundException e){
            System.out.println("Nie znaleziono listy");
        }

        System.out.println("");

        System.out.println("Usuwam z listy elementy:\n");

        System.out.println("pop_front");
        System.out.println("pop_back");

        list.pop_back();
        list.pop_front();
 
        System.out.println("");

        try{
            FileOutputStream fileOutput = new FileOutputStream("plik2");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
            objOutput.writeObject(list);
            objOutput.close();
            fileOutput.close();
            System.out.println("Udane zapisanie danych!");
        } catch (IOException e){
            System.out.println("Error podczas zapisywania danych!");
        }


        try{
            FileInputStream fileInput = new FileInputStream("plik2");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            
            ListofElem<?> inputList = (ListofElem<?>) objInput.readObject();

            objInput.close();
            fileInput.close();
            System.out.println("Udane odczytywanie danych!");

            System.out.println("");
            System.out.println("Zawartość listy: ");

            while(!inputList.is_empty()){
                System.out.println(inputList.pop_back());
            }
        } catch (IOException e){
            System.out.println("Error podczas odczytywania danych!");
        } catch (ClassNotFoundException e){
            System.out.println("Nie znaleziono listy");
        }

    }
 }
 