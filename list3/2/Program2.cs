/*
    Szymon Fica
    lista 3, zadanie 2, klasa MyDictionary

    w pliku Class2.cs zaprogramowałem klasę MyDictionary z metodami:
    dodaj(klucz, wartosc), usun(klucz), wyszukaj(klucz), wypisz();

    plik Program2.cs ilustruje działanie klasy MyDictionary

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
using Dictionary;

  class Program
  {
    static void Main(string[] args)
    {

      MyDictionary A = new MyDictionary();
      
      A.dodaj("bialy", 3);
      A.dodaj("czerwony", 2);
      A.dodaj("fioletowy", 7);
      A.dodaj("czarny", 9);
      A.wypisz();
      Console.WriteLine();
      A.usun("czerwony");
      A.wypisz();
      Console.WriteLine("\nA[fioletowy] =  " + A.wyszukaj("fioletowy"));

      

    }
  }
