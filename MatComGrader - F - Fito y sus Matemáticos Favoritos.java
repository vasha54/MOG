// MatComGrader - F - Fito y sus Matemáticos Favoritos

/*
Tematica: Add-Hoc 

Idea Basica: Para buscar la minima cantidad de años vivido seria aplicar la formula
min(c,d)-max(a,b) mientras para calcular la cantidad  maxima la formula es
max(c,d)-min(a,b)
*/
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


public class Main {
    
   
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 510;
    
    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
    private long [] cards ={1,10,100,1000,10000};
   
   
    public void solve() throws Exception {
       int a,b,c,d;
       
       a = nextInt();
       b = nextInt();
       c = nextInt();
       d = nextInt();
       
       while(a!=0 || b!=0 || c!=0 || d!=0){
           
           out.printf("%d %d\n",Math.min(c,d)-Math.max(a,b),Math.max(c,d)-Math.min(a,b));
           
           a = nextInt();
           b = nextInt();
           c = nextInt();
           d = nextInt();
       }
       
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

}
