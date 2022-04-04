// MatComGrader - Pascal Library

/*
Tematica:Add-Hoc 

Idea Basica: Es buscar dentro de una matriz si existe al menos una columna con todos
los valores en uno.
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
        int columna = nextInt();
        int fila = nextInt();
     
        
        while(fila!=0 && columna!=0){
            
            int [][]matriz =new int[fila][columna];
            
            for(int i=0;i<fila;i++){
                for(int j=0;j<columna;j++){
                    matriz[i][j]=nextInt();
                }
            }
            boolean flag =false;
            
            for(int i=0;i<columna;i++){
                int c =0;
                for(int j=0;j<fila;j++){
                    if(matriz[j][i]==1)c++;
                }
                if(c==fila)flag=true;
            }
            
            out.printf("%s\n",((flag==true)?"yes":"no"));
            
            columna = nextInt();
            fila = nextInt();
            
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
