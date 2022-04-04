//MatComGrader - N - Arithmetic Mean
/*

Tematica: Add-Hoc

Idea basica: Buscar entre las posibles tripletas que se puede formar con los cuatros valores que cumplan 
las condiciones. Para reducir las posibles tripletas ordenamos los valores de forma ascendentemente solo
debemos comprobar las siguientes tripletas

1ro + 3ro = 2do
1ro + 4to = 2do
1ro + 4to = 3do
2do + 4to = 3ro

Donde:

1ro es el menor valor de los elementos
2do es el segundo menor valor de los elementos
3ro es el segundo mayor valor de los elementos
4to es el mayor valor de los elementos

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
		int [] values = new int [4];
		for(int i=0;i<4;i++)
		   values[i] = nextInt();
		   
        Arrays.sort(values);
        
        if( isDouble(values[0],values[2],values[1]) == true || 
            isDouble(values[0],values[3],values[1]) == true ||
            isDouble(values[0],values[3],values[2]) == true ||
            isDouble(values[1],values[3],values[2]) == true){
            out.printf("YES\n");
        }else{
            out.printf("NO\n");
        }
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

