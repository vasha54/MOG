//MatComGrader-G-Generando cadena homogenea
/*

Tematica: String + Dinamica 

Idea basica: Buscar la cantidad de de grupos de a y de b de forma concecutivas 
que existen y quedarme con el que tenga menor cantidad
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
        String input = next();
        
        ArrayList<Integer> as =new ArrayList<Integer>();
        ArrayList<Integer> bs =new ArrayList<Integer>();
        
        int countA=0;
        int countB=0;
        
        char lastChar = 'c';
        
        for(int i=0;i<input.length();i++){
            char currentChar = input.charAt(i);
            switch(currentChar){
                case 'a':
                    countA++; 
                    if(currentChar!=lastChar && countB!=0){
                      bs.add(countB);
                    }
                    countB=0;
                break;
                case 'b':
                    countB++;
                    if(currentChar!=lastChar && countA!=0){
                      as.add(countA);
                    }
                    countA=0;
                break;
            }
            lastChar=currentChar;
        }
        
        if(countB!=0) bs.add(countB);
        if(countA!=0) as.add(countA);
        
        out.printf("%d\n",Math.min(bs.size(),as.size()));
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
