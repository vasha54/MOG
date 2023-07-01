/*
Mountain Ranges - MatComGrader
Tematica: Programación dinamica

Idea basica: Buscar la mayor secuencia de miradores que la distancias entre dos consecutivos
no supera la distancia que puede caminar en un dia la pareja. Para hacerlo mas eficiente
no buscar donde comienza el mejor trayecto sino por donde termina el mejor trayecto.

*/
#include <iostream>

#define ENDL '\n'
#define MAX_N 1010
using namespace std;

int nviewpoints,willing,answer;
int viewpoints[MAX_N],visit[MAX_N];

int main()
{
    ios_base::sync_with_stdio(0);
    std::cin.tie(0);
    cin>>nviewpoints>>willing;
    answer = 1;

    for(int i=0;i<nviewpoints;i++){
        cin>>viewpoints[i];
        visit[i]=1;
    }

    for(int i=nviewpoints-2;i>=0;i--){
        if(viewpoints[i+1]-viewpoints[i]<=willing){
           visit[i]=visit[i+1]+1;
        }

        answer=(answer < visit[i] ? visit[i] : answer );
    }

    cout<< answer<<ENDL;
    return 0;
}
