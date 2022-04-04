//MatComGrader- C - Pie Problem I

/*
Tematica: Teoría de Numero+ Fuerza bruta + busqueda lineal

Idea basica: Calculo la cantidad de de divisores para cada numero de 1 a 500 
Luego busco en el rango que me especifican aquel que tiene  la mayor cantidad de divisores
y su valore sea menor
*/
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
    /*private static class Coctel implements Comparable<Coctel>{
        public String color;
        public int density;
        
        public Coctel(String _color, int _density){
            this.color = _color;
            this.density =  _density;
        }
        
        public int compareTo(Coctel o){
            if( this.density < o.density ) return -1;
            if( this.density >o.density ) return 1;
            return 0;
        }
    }*/
    
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 510;
    
    
    
    public void solve() throws IOException {
        int [] cDivisores = new int [MAX_N];
        Arrays.fill(cDivisores,0,cDivisores.length,0);
        
        for(int i=1;i<MAX_N;i++){
            for(int j=i;j<MAX_N;j+=i){
                cDivisores[j]++;
            }
        }
        
        int L=nextInt();
        int R=nextInt();
        
        int mayor = cDivisores[R];
        int answer = R;
        
        for(int i=R;i>=L;i--){
            if(cDivisores[i]>=mayor){
                mayor=cDivisores[i];
                answer = i;
            }
        }
        
        out.printf("%d\n",answer);
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


