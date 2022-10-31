/*
MatComGrader -E - Estrategia con chocolate

Tematica: Teoría de Juego

Idea basica: Siendo m y n las dimensiones de la barra de chocolate inicial se tiene los siguientes
casos
Si n y m son iguales pierde quien juego primero
Si n y m no son iguales y amboas diferentes de 1 pierde quien juegue segundo
Si m o n son 1 y la otra dimensión es diferente de 1 pierde quien juegue segundo
Si m y n son 1 pierde quien comience primero 
*/

using System;

namespace JudgeOnline
{
    public class Program
    {
    	private const int MAX_N = 55;
        private const long MOD = 10000009;

        private int gcd(int _a,int _b){
            while(_b>0){
                _a=_a%_b;
                _a^=_b;
                _b^=_a;
                _a^=_b;
            }
            return _a;
        }

    	
        public Program(){}

        public void solve(){
            int cases = Convert.ToInt32(Console.ReadLine());
            
            for(int i=1;i<=cases;i++){
                String [] valuesStr = Console.ReadLine().Split();
                int m = Convert.ToInt32(valuesStr[0]);
                int n = Convert.ToInt32(valuesStr[1]);
                if(n == m && n!=1){
                    Console.WriteLine(2);
                }else if(n!=m && n!=1 && m!=1){
                    Console.WriteLine(1);
                }else if ( (m!=1 && n==1) || (m==1 && n!=1) ){
                    Console.WriteLine(1);
                }else if(n==1 && m==1){
                   Console.WriteLine(2); 
                }     
            }
        }

        public static void Main(string[] args)
        {
            Program p = new Program(); 
            p.solve();
        }
    }
}

