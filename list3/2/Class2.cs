using System;

namespace Dictionary;

 public class MyDictionary
{
    public string[] klucze = {};
    public int[] wartosci = {};
    public int rozmiar = 0;

    public void dodaj(string klucz, int wartosc)
    {
        this.rozmiar++;
        Array.Resize(ref this.klucze, this.rozmiar);
        this.klucze[this.rozmiar - 1] = klucz;

        Array.Resize(ref this.wartosci, this.rozmiar);
        this.wartosci[this.rozmiar - 1] = wartosc;
    }
    public int wyszukaj(string klucz)
    {
        if(this.rozmiar == 0) return 0;
        for(int i=0; i<this.rozmiar; i++)
        {
            if(this.klucze[i] == klucz)
            {
                return this.wartosci[i];
            }
        }
        return 0;
    }

    public void usun(string klucz)
    {
        if(this.rozmiar == 0) return;
        for(int i=0; i<this.rozmiar; i++)
        {
            if(this.klucze[i] == klucz)
            {
                this.klucze[i] = this.klucze[this.rozmiar-1];
                this.wartosci[i] = this.wartosci[this.rozmiar-1];
                this.klucze[this.rozmiar-1] = "";
                this.wartosci[this.rozmiar-1] = 0;
                this.rozmiar--;
                break;
            }
        }
    }

    public void wypisz()
    {   
        for(int i=0; i<this.rozmiar; i++)
        {
            Console.WriteLine(this.klucze[i] + " - " + this.wartosci[i]);
        }
    }

}
