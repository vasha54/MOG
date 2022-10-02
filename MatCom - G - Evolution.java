/*
MatCom - G - Evolution
Tematica: Add - Hoc + Fuerza Bruta

Idea Basica: Simular el proceso que se describe en el problema
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
    private final int MAX_N = 1000001;
    private final int MAX_TREE = (MAX_N << 2);
    
    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
    private long [] cards ={1,10,100,1000,10000};
    private long MOD =1000000009;
    
    public void evolution(int [] _currentGeneration , int [] _nextGeneration, int _poblation){
      for (int k=0;k<_poblation ;k++ ) {
         if( k-1 >=0 && k+1<_poblation){
            _nextGeneration[k] = (_currentGeneration[k-1] == _currentGeneration[k+1] ? 0 : 1);
         }
         else if (k==0){
            _nextGeneration[k] = ( 0 == _currentGeneration[k+1] ? 0 : 1);
         }else{
            _nextGeneration[k] = (_currentGeneration[k-1] == 0 ? 0 : 1);
         }
      }
    }
   
    public void solve() throws Exception {

      int poblation = nextInt();
      int  iterations = nextInt();

      int [] currentG = new int [poblation];
      int [] nextG = new int [poblation];

      for (int i=0;i<poblation ;i++ ) {
         currentG[i] = nextInt();
      }

      for(int i=0;i<iterations;i++){
         if (i % 2 == 0 ) evolution(currentG,nextG,poblation) ;
          else evolution(nextG,currentG,poblation);
      }

      for (int i=0;i<poblation ;i++ ) {
         currentG[i] = (iterations % 2 == 0 ? currentG[i] : nextG[i]);
         if(i!=0) out.printf(" ");
         out.printf("%d",currentG[i]);
      }
      out.printf("\n");
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
