/*
    Szymon Fica
    lista 3, zadanie 4, klasa Wektor

    w pliku Class1.cs zaprogramowałem klasę Wektor z podstawowymi operatorami, 
    metodą wypisującą wektor oraz dwoma konstruktorami 

    plik Program.cs ilustruje działanie klasy Wektor

    przy kompilacji kożystałem ze środowiska Visual Studio Code,
    tworząc klasę w środowisku i konfigurowaniu rozwiązania posłużyłem się poradnikiem ze strony:
    https://learn.microsoft.com/en-us/dotnet/core/tutorials/library-with-visual-studio-code?pivots=dotnet-7-0
    załączyłem rówież pliki z konfiguracją

    komendy użyte do skompilowania projektu:
    
    dotnet new sln
    dotnet new classlib -o StringLibrary
    dotnet sln add StringLibrary/StringLibrary.csproj
    dotnet new console -o ShowCase
    dotnet sln add ShowCase/ShowCase.csproj
    dotnet add ShowCase/ShowCase.csproj reference StringLibrary/StringLibrary.csproj
    dotnet run --project ShowCase/ShowCase.csproj

    


*/

using System;
using Biblioteka;

  class Program
  {
    static void Main(string[] args)
    {


      float[] tab1 = {(float)(2.2), (float)(3.3), (float)(5.5), (float)(7.7)};
      float[] tab2 = {(float)(1.2), (float)(3.4), (float)(4.5), (float)(6.7)};

      Wektor A = new Wektor(4, tab1);
      Wektor B = new Wektor(4, tab2);
      Console.Write("Wektor A: ");
      Wektor.wypisz(A);
      Console.Write("Wektor A: ");
      Wektor.wypisz(B);

      Wektor C = Wektor.dodawanie(A, B);
      Console.Write("Wektor C = A + B: ");
      Wektor.wypisz(C);
      Console.WriteLine("Dlugosc wektora C: " + Wektor.norma(C));

      C = Wektor.mnozenie_przez_skalar(C, 2);
      Console.Write("Wektor C * 2: ");
      Wektor.wypisz(C);

    }
  }
