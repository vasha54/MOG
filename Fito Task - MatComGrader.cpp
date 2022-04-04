/*
Fito Task - MatComGrader
Tematica: Add-Hoc

Idea basica: A partir de los numeros originales A y B generar cuatro numero A1 , A2 , B1 y B2 en
A1 y B1 seria el mismo numero de A y B pero cambiando los digitos 6 por 5 para obtener los menores
posibles valores de A y B. En A2 y B2 la idea seria la misma pero cambiando los digitos 5 por 6 para
obtener los maximo valores posibles luego las repuestas sería A1+B1 y A2+B2
*/
#include <iostream>

#define ENDL '\n'
#define ULL unsigned long long
using namespace std;

string strA, strB;

ULL maxA,maxB,minB,minA;

ULL change(string _x,char _y, int _z){
    ULL v=0;
    int n = _x.size();
    for(int i=0;i<n;i++){
        v = v*10+ (_x[i]==_y ? _z : _x[i]-'0');
    }
    return v;
}


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>strA>>strB;

    maxA=change(strA,'5',6);
    minA=change(strA,'6',5);

    maxB=change(strB,'5',6);
    minB=change(strB,'6',5);

    cout<<minA+minB<<" "<<maxA+maxB<<ENDL;

    return 0;
}
