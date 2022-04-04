// MatComGrader -  Automated Checking Machine

/*
Tematica:Add-Hoc + operador XOR

Idea Basica: Sumar el resultado de XOR entre cada bits y ver si da 5 al final.
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
        int [] bitsA =new int [5];
        int [] bitsB =new int [5];    
        for(int i=0;i<5;i++)
           bitsA[i] = nextInt();
           
        for(int i=0;i<5;i++)
           bitsB[i] = nextInt();
           
        int xor=0;
        
        for(int i=0;i<5;i++){
            xor+=(bitsA[i]^bitsB[i]);
        }
        
        out.printf("%s\n",( (xor ==5) ? "Y": "N"));
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
