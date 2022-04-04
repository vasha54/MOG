//MOG - J - Joining Cities
// Tematica :Greedy
// Idea Básica: Ordenar y sumar las diferencias entre valores consecutivos;
#include <iostream>
#include <bits/stdc++.h>

#define ENDL '\n'
#define MAX 100010
#define LL long long
#define ULL unsigned long long

using namespace std;

int nhouse;
ULL houses [MAX], answer;

int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>nhouse;
    for(int i=0;i<nhouse;i++)
      cin>>houses[i];
    sort(houses,houses+nhouse);
    answer =0;
    for(int i=0;i<nhouse-1;i++)
        answer+=(houses[i+1]-houses[i]);
    cout<<answer<<ENDL;
    return 0;
}
