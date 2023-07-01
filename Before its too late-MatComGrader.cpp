//Before it’s too late - MatComGrader
/*
Tematica: Ordenamiento
Idea basica: Ordenar las posiciones donde fueron plantados los arboles
y calcular la diferencias entre la mayor posicion y la menor posición.


Tematica: Busqueda
Idea basica: Podemos buscar el menor y mayor de todas posiciones hallar su diferencia
*/
#include <iostream>

#define ENDL '\n'
#define ULL unsigned long long
#define pOO 1000000100

using namespace std;

int ntree;
ULL posTree,minPos,maxPos;

int main()
{
    ios_base::sync_with_stdio(0);
    std::cin.tie(0);

    cin>>ntree;
    minPos= pOO;
    maxPos= 0;

    for(int i=0;i<ntree;i++){

        cin>>posTree;
        if (posTree > maxPos)
           maxPos = posTree;

        if (posTree< minPos)
            minPos = posTree;

    }

    cout<<maxPos-minPos<<ENDL;
    return 0;
}
