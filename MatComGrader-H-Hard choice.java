//MatComGrader-H-Hard choice
/*
Tematica: Add-Hoc 

Idea basica: Acumular la cantidad de pedidos que superan a lo disponible en cada plato
*/
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 1010;
    
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
        int chikenAirPlane = nextInt();
        int beefAirPlane = nextInt();
        int pastaAirPlane = nextInt();
        
        int chikenRequest = nextInt();
        int beefRequest = nextInt();
        int pastaRequest = nextInt();
        
        int passengers =0;
        
        if( chikenRequest > chikenAirPlane ) passengers+=(chikenRequest - chikenAirPlane);
        if( beefRequest > beefAirPlane ) passengers+=(beefRequest - beefAirPlane);
        if( pastaRequest > pastaAirPlane ) passengers+=(pastaRequest - pastaAirPlane);
        
        out.printf("%d\n",passengers);
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
