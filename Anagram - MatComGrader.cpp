/*
Anagram - MatComGrader
* 
* Tematica: String + Fuerza bruta
* 
* Analisis: Ya que la cadena es pequeña podemos generar todas las posibles
* subcadenas ordenarlas internamente y buscar de las otras posibles cadenas 
* con similar longitud y ver ellas ordenadas internamente son iguales a la
* subcadena seleccionada para contarlas como pares de anagramas 
* 
*/
#include <iostream>
#include <string>
#include <strings.h>
#include <algorithm>

#define ENDL '\n'
#define ULL unsigned long long
#define LL long long
using namespace std;

string input,sub;
int n;
ULL answer;

ULL findNextAnagram(int _index,int _length,string _x){
    ULL c =0;
    string t ;
    for(int k=_index;k+_length<=n;k++){
        t = input.substr(k,_length);
        sort(t.begin(),t.end());
        if (_x == t)
           c++;
    }
    return c;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>input;
    n=input.size();
    answer=0;
    for(int i=0;i<n;i++){
       for(int j=1;j+i<=n;j++){
          sub=input.substr(i,j);
          sort(sub.begin(),sub.end());
          answer+=findNextAnagram(i+1,j,sub);
       }
    }
    cout<<answer<<ENDL;
    return 0;
}
