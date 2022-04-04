//MatComGrader - C - Calculadora del tío de Fito
/*

Tematica: String

Idea Básica: Como los números son bien grandes no pueden ser almacenados ni siquiera
un long vamos trabajarlo como cadenas de caracteres o en el caso especifico de Java
trabajar de BigInteger.

*/
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    
    private int gcd(int a,int b){
        while ( b > 0){
            a = a %b ;
            a ^= b ;
            b ^= a ;
            a ^= b ;
        }
        return a ;
    }
    
    private boolean isDouble(int a,int b, int c){
        return ( a+b == c*2 );
    }
    
    public void solve() throws IOException {
		String a = next();
		String operador = next();
		String b = next();
		
		switch(operador){
            case "+":
                String aInverse = "";
                String bInverse = "";
                String sums = "";
                
                for(int i=a.length()-1;i>=0;i--){
                    aInverse =  aInverse + a.charAt(i);
                }
                
                for(int i=b.length()-1;i>=0;i--){
                    bInverse = bInverse + b.charAt(i);
                }
                
                for(int i=0;i<Math.max(aInverse.length(),bInverse.length());i++){
                    int digitA = 0;
                    int digitB = 0;
                    if(i < aInverse.length())
                        digitA = aInverse.charAt(i)-'0';
                    if(i < bInverse.length())
                        digitB = bInverse.charAt(i)-'0';
                    int digit = digitA + digitB;
                    
                    sums = digit + sums;
                }
                
                out.printf("%s",sums);
            break;
            case "*":
                int nzeros = b.length()-1+a.length()-1;
                out.printf("1");
                for(int i=0;i<nzeros;i++){
                    out.printf("0");
                }
            break;
		}
		out.printf("\n");
	}

    Main() throws IOException {
       //in = new BufferedReader(new FileReader("Input.txt"));
       //out = new PrintWriter(new FileWriter("Output.txt"));
       in = new BufferedReader(new InputStreamReader(System.in));
	   out = new PrintWriter(System.out);
       eat("");
       solve();
       in.close();
       out.close();
    }

    private void eat(String str) { st = new StringTokenizer(str);}

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {return Integer.parseInt(next());}

    long nextLong() throws IOException {return Long.parseLong(next());}

    double nextDouble() throws IOException {return Double.parseDouble(next());}

    public static void main(String[] args) throws IOException {new Main();}

}

