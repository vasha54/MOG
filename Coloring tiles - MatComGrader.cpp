/*
Coloring tiles - MatComGrader
Tematica: Add-Hoc

Idea basica: Cuando se pinta tenenmos dos posibles opciones o secuencias :
La primera que empienza pintando en blanco luego negro y luego blanco y asi sucecivamente
La segunda que empienza pintando en negro luego blanco y luego negro y asi sucecivamente

Dada una secuencia tenemos que que calcular para cual de las dos secuencias posibles la secuencia
original sufre menos cambios y esa cantidad de de cambios será la respuesta.
*/
#include <iostream>

#define ENDL '\n'

using namespace std;

string tiles;
bool white, black;
int ntiles,differWhite,differBlack;

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>tiles;
    ntiles=tiles.size();
    white =true;
    black = true;
    differBlack = 0 ;
    differWhite = 0;

    for(int i=0;i<ntiles;i++){
        if(tiles[i]=='1'){
            if (white == false){
                differWhite++;
            }
            if (black == true){
                differBlack++;
            }
        }

        if(tiles[i]=='0'){
            if (white == true){
                differWhite++;
            }
            if (black == false){
                differBlack++;
            }
        }

        white=!white;
        black=!black;
    }

    cout<<min(differBlack,differWhite)<<ENDL;
    return 0;
}
