//MatComGrader -  Arithmetic Mean
/*

Tematica: Add-Hoc 

Idea basica: Ver entre las triadas que se pueden formar con los cuatros valores alguno cumple la condicion 
solicitada. Otra idea que mejora la anterior ordenamos los valores de forma creciente luego solo tenemos comprobar
las siguientes triadas solamente:

1er + 3ro = 2do*2
1er + 4to = 2do*2
1er + 4to = 3ro*2
2do + 4to = 3ro*2

Donde el 1er es el menor elemento de los cuatro
Donde el 2do es el segundo menor elemento de los cuatro
Donde el 3ro es el segudo mayor elemento de los cuatro
Donde el 4to es el mayor elemento de los cuatro
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
    
    private boolean isDouble(int x,int y, int z){
        return (x+y==2*z);
    }
    
    public void solve() throws IOException {
		int [] values = new int [4];
		
		boolean exist= false;
		
		for(int i=0;i<4;i++){
            values[i]=nextInt();
		}
		Arrays.sort(values);
		
		if( isDouble(values[0],values[2],values[1]) == true || isDouble(values[0],values[3],values[1]) == true ||
		    isDouble(values[0],values[3],values[2]) == true || isDouble(values[1],values[3],values[2]) == true)
		    exist =true;
		
		
		out.printf("%s\n",(exist == true ? "YES": "NO"));
		
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
