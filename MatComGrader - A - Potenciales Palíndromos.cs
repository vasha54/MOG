/*
MatComGrader - A - Potenciales Palíndromos

Tematica: String

Idea basica: Lo primero es ver si la cadena puede ser palindrome asumiendo que los simbolos
? son las letras correctas de no serlo la respuesta es 0. De cumplirse lo anterior ya tenemos
un posible palindrome. Luego recorremos la cadena como si fuera comprobando si es palindrome
y cada vez que me encuentro dos posiciones que son simetricas en el palindrome con respecto
al centro de este y ambas son simbolos '?' veo la cantidad de soluciones hasta el momento
y mutiplico por 26. 

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

    	private bool isPossiblePalindrome(string _text){
            bool isPalindrome = true;
            int begin = 0;
            int end = _text.Length-1; 

            while(begin <= end && isPalindrome==true){
                
                if(_text[begin]!=_text[end] && _text[begin]!='?'  && _text[end]!='?')
                   isPalindrome=false;

                begin++;
                end--;
            }
            return isPalindrome;
        }

        private long calculateQuantivyPalindromes(string _text){
            long cant = 1;
            int begin = 0;
            int end = _text.Length-1;
            while(begin <= end ){
                
                if(_text[begin]==_text[end] && _text[begin]=='?')
                   cant = (cant*26)%MOD;

                begin++;
                end--;
            }
            return cant;
        }

        public Program(){}

        public void solve(){
            int cases = Convert.ToInt32(Console.ReadLine());
            while( cases > 0){
                string input = Console.ReadLine();
                if( isPossiblePalindrome(input) == true){
                   long answer = calculateQuantivyPalindromes(input);
                   Console.WriteLine(answer);
                }
                else
                    Console.WriteLine(0);
                cases --;
            }
        }

        public static void Main(string[] args)
        {
            Program p = new Program(); 
            p.solve();
        }
    }
}

