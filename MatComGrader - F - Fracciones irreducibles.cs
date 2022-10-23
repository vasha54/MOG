/*
MatComGrader - F - Fracciones irreducibles

Tematica: Aritmetica - Algebra

Idea basica: Buscar el máximo común divisor entre dos números e imprimir el resultado 
de imprimir dichos numeros por su gsd.

*/

using System;

namespace JudgeOnline
{
    public class Program
    {
    	private const int MAX_N = 55;

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
            string [] valuesStr = Console.ReadLine().Split();
            int A = Convert.ToInt32(valuesStr[0]);
            int B = Convert.ToInt32(valuesStr[1]);
            int C = gcd(A,B);
            Console.WriteLine("{0} {1}",A/C,B/C);
    	}

        public static void Main(string[] args)
        {
            Program p = new Program(); 
            p.solve();
        }
    }
}

