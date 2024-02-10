/*
    Szymon Fica 337307,
    lista 1 zadanie 1 kwadrat
*/

#include <iostream>

#define st first
#define nd second
#define pb push_back
 
using namespace std;

typedef struct _kwadrat
{
    // wsp lewego dolnego wierzcholka
    float x, y;
    float bok;


}kwadrat;

kwadrat * nowy_kwadrat(float x, float y, float a){
    static kwadrat k;
    k.x = x;
    k.y = y;
    k.bok = a;
    return &k;
}

float pole(kwadrat *k){
    return (*k).bok * (*k).bok;
}

void przesun(kwadrat *k, float a, float b){
    (*k).x += a;
    (*k).y += b;
}

float suma_pol(kwadrat* f[], int n){
    float sum = 0;
    for(int i=0; i<n; i++){
        sum += pole(f[i]);
    }
    return sum;
}


int main(){

    
    return 0;
}
