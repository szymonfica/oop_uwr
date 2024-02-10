/*
    Szymon Fica 337307,
    lista 1 zadanie 2 Ulamek
*/

#include <iostream>
#include <numeric>
 
#define st first
#define nd second
#define pb push_back

using namespace std;

typedef struct _Ulamek
{
    int licznik, mianownik;


}Ulamek;

Ulamek nowy_ulamek(int p, int q){
    Ulamek x;
    if(q == 0){
        // sprawdzenie czy mianownik jest rowny 0
        // w takim przypadku ulamek bedzie nieokreslony 0/0
        x.licznik = 0;
        x.mianownik = 0;
        return x;
    }
    x.licznik = p/gcd(p, q);
    x.mianownik = q/gcd(p, q);
    return x;
}

void show(Ulamek *u){
    cout<< (*u).licznik << ",  " << (*u).mianownik << '\n';
}

// wersje funkcji zwracających wskazniki
Ulamek * suma(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).mianownik + (*b).licznik * (*a).mianownik;
    int m = (*a).mianownik * (*b).mianownik;    
    static Ulamek ans =  nowy_ulamek(l, m);
    return &ans;
}

Ulamek * roznica(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).mianownik - (*b).licznik * (*a).mianownik;
    int m = (*a).mianownik * (*b).mianownik;    
    static Ulamek ans =  nowy_ulamek(l, m);
    return &ans;
}

Ulamek * iloczyn(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).licznik;
    int m = (*a).mianownik * (*b).mianownik;    
    static Ulamek ans =  nowy_ulamek(l, m);
    return &ans;
}

Ulamek * iloraz(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).mianownik;
    int m = (*a).mianownik * (*b).licznik;
    static Ulamek ans =  nowy_ulamek(l, m);
    return &ans;
}

// wersje funkcji zmieniajacych wartosc drugiego skladnika
void suma_2(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).mianownik + (*b).licznik * (*a).mianownik;
    int m = (*a).mianownik * (*b).mianownik;    
    (*b) = nowy_ulamek(l, m);
}

void roznica_2(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).mianownik - (*b).licznik * (*a).mianownik;
    int m = (*a).mianownik * (*b).mianownik;    
    (*b) = nowy_ulamek(l, m);
}

void iloczyn_2(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).licznik;
    int m = (*a).mianownik * (*b).mianownik;    
    (*b) = nowy_ulamek(l, m);
}

void iloraz_2(Ulamek *a, Ulamek *b){
    int l = (*a).licznik * (*b).mianownik;
    int m = (*a).mianownik * (*b).licznik;
    (*b) = nowy_ulamek(l, m);
}

int main(){

    /* test
    Ulamek a;
    a.licznik = 2, a.mianownik = 4;
    Ulamek b;
    b.licznik = 2, b.mianownik = 8;
    Ulamek * c = iloraz(&a, &b);
    show(c);*/

    /* test_2
    Ulamek a;
    a.licznik = 1, a.mianownik = 3;
    Ulamek b;
    b.licznik = 1, b.mianownik = 9;
    suma_2(&a, &b);
    show(&b);*/

    

    return 0;
}
