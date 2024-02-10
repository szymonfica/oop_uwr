/*
Szymon Fica
lista 4, zadanie 2
*/

using System;
using System.Collections;

class Program{
    static void Main(string[] args){
        SlowaFibonacciego sf = new SlowaFibonacciego(6);
        foreach(string s in sf)
            Console.WriteLine(s);
    }
}

public class SlowaFibonacciego : IEnumerable<string>
{
    private class FibEnumerator : IEnumerator<string>
    {
        private int liczba_slow, index;
        private string aktualne,  poprzednie;
        public FibEnumerator(int liczba_slow){
            this.liczba_slow = liczba_slow;
            aktualne = poprzednie = "";
            index = 0;
        }

        public string Current => aktualne;

        object IEnumerator.Current => Current;

        
        public bool MoveNext(){
            if(index+1 > liczba_slow)
                return false;
            index++;
            if(index == 1)
            {
                aktualne = "b";
            }
            else if(index == 2)
            {
                aktualne = "a";
                poprzednie = "b";
            }
            else
            {
                string pomocniczy = aktualne;
                aktualne += poprzednie;
                poprzednie = pomocniczy;
            }
            return true;
        }

        public void Reset(){
            aktualne = "";
            poprzednie = "";
            index = 0;
        }

        public void Dispose(){

        }
    }
    
    private int liczba_slow;
    public SlowaFibonacciego(int liczba_slow) {
        this.liczba_slow = liczba_slow;
    }

    IEnumerator IEnumerable.GetEnumerator() {
        return new FibEnumerator(liczba_slow);
    }

    public IEnumerator<string> GetEnumerator() {
        return new FibEnumerator(liczba_slow);
    }
}

