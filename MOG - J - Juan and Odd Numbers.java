
/*
* MOG - J - Juan and Odd Numbers
* Tematica: Aritmetica y Algebra
* 
* Idea Basica: Dado un número N hallar la suma de los últimos digitos de los primeros N
* números impares. Si analizamos un poco vemos que los digitos a sumar siempre van hacer
* 1,3,5,7,9 y que el ciclo se repite cada 5 y la suma del ciclo completo es 29. Por tanto la 
* solución viene dada por la ecuación:
*  A = K*29+f(R) Donde:
*  K es la cantidad de ciclos completos que tiene N. (N/5)
*  R es la cantidad de números que sobran y no completan el último ciclo (N%5)
*  f(x) Función que retorna la suma de los últimos digitos de los primeros x numeros impares
*/
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;
import java.util.List;


public class Main {
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 1000001;
    private final int MAX_TREE = (MAX_N << 2);
    
    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
    private long [] cards ={1,10,100,1000,10000};
    private long MOD =1000000009;
    private double EPS = 1e-9;
    private int INF = Integer.MAX_VALUE;
    
    private void solve() throws Exception{
    	long N = nextLong();
    	long K = N / 5L;
    	long R = N % 5L;
    	long [] sumsOdds = {0,1,4,9,16,25};
    	long answer = K*25L+sumsOdds[(int) R];
    	out.printf("%d\n", answer);
    }
    
    
    
    Main() throws Exception {
       /*Esta entrada  se debe activar cuando se hace una ejercicio de lectura hasta fin de fichero 
       copiar la entrada en un fichero "Input.txt" y comentar el otro in . A la hor de enviar comentar
       este y descomentar el otro
       */
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


    String next() throws Exception {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {return Integer.parseInt(next());}

    long nextLong() throws Exception {return Long.parseLong(next());}

    double nextDouble() throws Exception {return Double.parseDouble(next());}

    public static void main(String[] args) throws Exception {new Main();}

    public int MEX_ONLOGN(List<Integer> A) {
        TreeSet<Integer> B = new TreeSet(A);
        int result = 0;
        while (B.contains(result))
            ++result;
        return result;
    }

    public int MEX_ON(List<Integer> A) {
       boolean [] used = new boolean [MAX_N+1];
       Arrays.fill(used,false);
       
       for (Integer x : A) {
            if (x <= MAX_N)
                used[x] = true;
        }

        int result = 0;
        while (used[result])
            ++result;

    for (Integer x : A) {
        if (x <= MAX_N)
            used[x] = false;
    }

    return result;
}




}
