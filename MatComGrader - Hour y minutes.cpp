/*
MatComGrader - Minutes Hour


Tematica:Add-Hocc + Simulacion

Idea basica: Conociendo que cada doce minutos se mueve el indicador de la hora en un reloj podemos
simular doce horas del día (las otras doce va ocurrir los mismo) y sabiendo que entre cada indicador hay
6 grados podemos precalcular todas los posibles grados almacenarlos en una colección que los mantenga ordenados
sin reperirlos y que realice la busqueda rapida (Set). Luego para cada valor entrado los buscamos en la colección
de estar la respuesta es Y en caso contrario N.

*/
#include <iostream>
#include <string>
#include <strings.h>
#include <map>
#include <set>
#include <algorithm>
#include <math.h>

#define ENDL '\n'
#define ULL unsigned long long
#define LL long long
using namespace std;





int main()
{
    //freopen("Input.txt","r",stdin);

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int angle;
    set<int> angles;

    //Precalculo de los ángulos
        int minutes = 0;
        int hour = 0;

        do{
            angles.insert(abs(minutes-hour)*6);
            minutes++;
            if(minutes%12==0)
                hour++;
            minutes%=60;
        }while(hour<=59);

        /*Lectura de fin de fichero en caso que sean varios datos por linea leen el primero dentro
        de la condición del while y los siguientes dentro while como primra operacion*/
        while(cin>>angle){
           cout<< (angles.find(angle)!=angles.end() ? "Y" : "N")<<ENDL;
        }

    return 0;
}
