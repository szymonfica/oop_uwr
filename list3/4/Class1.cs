using System;

namespace Biblioteka;

 public class Wektor
  {
    public int rozmiar = 0;
    public float[] tab;

    public Wektor(int n, float[] T)
    {
      this.rozmiar = n;
      this.tab = T;
    }
    
    public Wektor(int n)
    {
      this.rozmiar = n;
      this.tab = new float[n];
      Array.Clear(tab, 0, n);
    }

    public static Wektor dodawanie(Wektor a, Wektor b)
    {
      if(a.rozmiar != b.rozmiar)
        return null;
      Wektor c =  new Wektor(a.rozmiar);
      for(int i=0; i<b.rozmiar; i++)
      {
        c.tab[i] = a.tab[i] + b.tab[i];
      }
      return c;

    }

    public static float iloczyn_skalarny(Wektor a, Wektor b)
    {
      if(a.rozmiar != b.rozmiar)
        return 0;
      float x = 0;
      for(int i=0; i<b.rozmiar; i++)
      {
        x += a.tab[i] * b.tab[i];
      }
      return x;
    }

    public static Wektor mnozenie_przez_skalar(Wektor a, float x)
    {
     Wektor c =  new Wektor(a.rozmiar);
      for(int i=0; i<c.rozmiar; i++)
      {
        c.tab[i] = a.tab[i] * x;
      }
      return c;
    }

    public static float norma(Wektor a)
    {
      float ans = iloczyn_skalarny(a, a);
      ans = MathF.Sqrt(ans);
      return ans;
    }

    public static void wypisz(Wektor a)
    {
      Console.Write("{");
      for(int i=0; i<a.rozmiar; i++)
      {
        Console.Write(a.tab[i]);
        if(i != a.rozmiar-1)
        {
          Console.Write(", ");
        }
      }
      Console.Write("}\n");
    }
  }
