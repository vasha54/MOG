/*
Elevator - MatComGrader
Tematica : Algebra-Aritmética

Idea Basica: En cada viaje vamos a llenar a tope el elevador sin importar el piso hasta donde tengamos
que ir porque lo que buscamos es la menor cantidad de de viajes. Esto signfica que en cada viaje exceptuando
el ultimo el elevador a ir a tope por tanto si la cantidad de paquetes es multiplo de la capacidad del
elevador la cantidad de de viajes es el resultado de la división de cantidad de paquetes entre capacidad de elevador
en caso de no ser multiplo el resultado sería la parte entera de la division incrementado en uno.
*/
#include <iostream>

#define ENDL '\n'

using namespace std;

int nfloors,npackage,limitPackage,floor;

int main()
{
    ios_base::sync_with_stdio(0);
    std::cin.tie(0);
    cin>>nfloors>>npackage>>limitPackage;

    for(int i=0;i<npackage;i++){
        cin>>floor;
    }

    cout<<( npackage%limitPackage == 0 ? npackage/limitPackage : npackage/limitPackage+1 )<<ENDL;
    return 0;
}
