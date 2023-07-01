/*
Three numbers - MatComGrader
Tematica: Fuerza Bruta

Idea basica: Buscar los tres primeros numeros del 1 al 9  que sean diferentes entre si y diferente al los valores
de A, B y C.
*/
#include <iostream>

#define ENDL '\n'

using namespace std;

int A,B,C,cont;

int main()
{
    ios_base::sync_with_stdio(0);
    std::cin.tie(0);

    cin>>A>>B>>C;
    cont=0;

    for(int i=1;i<=9 && cont<3;i++){
       if(i!=A && i!=B && i!=C){
            if(cont!=0){
                cout<<" ";
            }
            cout<<i;
            cont++;
       }
    }

    cout<<ENDL;
    return 0;
}
