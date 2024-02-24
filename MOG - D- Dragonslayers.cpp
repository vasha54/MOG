/*
* MOG - D- Dragonslayers.
* Tematica : Greedy + Pair
* Idea: Se tiene tres dragones y tres caballeros y se quiere saber si puede existir
* una distribucion dragon-caballero tal que exista al menos tuplas donde la fuerza
* del caballero supere al del dragon. Para lograr lo anterior vamos almacenar en deque
* de pares las fuerzas y posiciones de dragones y caballeros los ordenaremos de forma
* creciente por la fuerza en el caso de los caballeros y la defensa de los dragones.
*
* Para encontrar si existe tal distribución vamos siempre a tomar los dos elementos que
* estan en frente en las deques si la fuerza del caballero supera al dragon entonces encontre una tupla
* para la supuesta distribución e incremento en uno la cantidad de dragones que pueden ser eliminado
* y emparejo ese dragon con ese caballero y saco a ambos de sus respectivas colecciones.
* Si la fuerza del caballero no supera la defensa del dragon entonces empareo ese dragon
* con el último caballero disponible ya que el caballero del frente de la colección
* puede que no pueda con el dragon que esta al frente pero si con el siguiente.
*/
#include <iostream>
#include <math.h>
#include <bits/stdc++.h>
#define ENDL '\n'
#define OPTIMIZAR_IO ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define PRESICION(x) cout.setf(ios::fixed,ios::floatfield); cout.precision(x);
#define READ_FILE freopen("Input.txt","r",stdin);
#define WRITE_FILE freopen("Output.txt","w",stdout);
#define MAX_N 100010
#define MOD 1000000007
#define EPS 1e-4
#define INF 1000000000
#define int long long
#define uint unsigned long long
#define pii pair<int,int>
#define ALPHABET_SIZE 26 //['a-z']
#define Point pair<int, int>
#define X first
#define Y second
#define PLUS '+'
#define MINUS '-'
#define SPACE ' '
#define PRINT_LINE cout<<ENDL;
using namespace std;

int force;
deque<Point> dragons,knights,matchs;

signed main(){
    OPTIMIZAR_IO
    //PRESICION(0)
    // READ_FILE
    //WRITE_FILE
    for(int i=1;i<=3;i++){
        cin>>force;
        knights.push_back(make_pair(force,i));
    }
    for(int i=1;i<=3;i++){
        cin>>force;
        dragons.push_back(make_pair(force,i));
    }

    sort(knights.rbegin(),knights.rend());
    sort(dragons.rbegin(),dragons.rend());
    force =0;

    while(!dragons.empty() && !knights.empty()){
        Point d = dragons.front();
        Point k = knights.front();

        if(k.first > d.first){
            force++;
            knights.pop_front();
        }else{
            k = knights.back();
            knights.pop_back();
        }
        dragons.pop_front();
        matchs.push_back(make_pair(k.second,d.second));
    }
    if(force>=2){
        cout<<"POSSIBLE"<<ENDL;
        sort(matchs.begin(),matchs.end());
        for(int i=0;i<3;i++){
            if(i)cout<<SPACE;
            cout<<matchs[i].second;
        }
        PRINT_LINE
    }else{
        cout<<"IMPOSSIBLE"<<ENDL;
    }

    return 0;
}
