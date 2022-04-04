//MatComGrader-C - Cuban pesos
/*
Tematica: Add-Hoc + Simulacion 

Idea basica: Elaborar una simulacion que le otorgue a n valores n valores diferentes 
entre si y que sumados entre si
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
        int pesos = nextInt();
        int nprojects = nextInt();
        
        int [] projects = new int [nprojects];
        Arrays.fill(projects,0,projects.length,0);
        
        for(int i=0; i < projects.length &&  pesos > 0;i++){
            for(int j=i; j < projects.length && pesos > 0;j++){
                projects[j]++;
                pesos--;
            }
        }
        
        if(pesos>0)
          projects[projects.length-1]+=pesos;
        
        for(int i=0; i < projects.length;i++){
            out.printf("%d\n",projects[i]);
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


