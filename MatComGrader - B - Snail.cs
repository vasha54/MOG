/*
MatComGrader - B - Snail

Tematica: Aritmetica - Algebra

Idea basica: El gusano va estar K dias completos dentro del pozo por tanto estos dias
completos va subir S-B siendo S lo que sube durante el horario diurno y B lo que baja
en el horario nocturno al siguiente dia avanzara a los sumo S  metros y saldra del pozo
de V metros de profundidad por tanto la solucion se reduce a lo siguiente:

V <=  S + K(S-B)

V-S <= K(S-B)

(V-S)/(S-B) <= K

Si > K K++
Si == K K

*/

using System;

namespace JudgeOnline
{
    public class Program
    {
    	private const int MAX_N = 55;

    	public Program(){
    		
    	}

    	public void solve(){
            string [] valuesStr = Console.ReadLine().Split();
            long S = Convert.ToInt64(valuesStr[0]);
            long B = Convert.ToInt64(valuesStr[1]);
            long V = Convert.ToInt64(valuesStr[2]);

            long K = (V-S) / (S-B);

            if( K * (S-B) < (V-S))
                K+=2;
            else
                K+=1;

            Console.WriteLine(K);
    	}

        public static void Main(string[] args)
        {
            Program p = new Program(); 
            p.solve();
        }
    }
}

