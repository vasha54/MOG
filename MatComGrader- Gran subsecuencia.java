//MatComGrader- Gran subsecuencia
/*
Tematica: Greedy  

Idea basica: 
*/
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
    private static class Letter implements Comparable<Letter>{
        public char letter;
        public int index;
        
        public Letter(char _letter, int _index){
            this.letter = _letter;
            this.index =  _index;
        }
        
        public int compareTo(Letter o){
            if( this.letter > o.letter ) return -1;
            if( this.letter < o.letter ) return 1;
            if( this.letter == o.letter && this.index < o.index  ) return -1;
            if( this.letter == o.letter && this.index > o.index  ) return 1;
            return 0;
        }
    }
    
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
        Letter [] letters =new Letter [input.length()];
        for(int i=0;i<input.length();i++){
            letters[i] = new Letter(input.charAt(i),i);
        }
        
        Arrays.sort(letters);
        
        int lastTake =-1;
        
        
        
        for(int i=0;i<letters.length;i++){
            if(letters[i].index > lastTake){
                out.printf("%c",letters[i].letter);
                lastTake = letters[i].index;
            }
        }
        
        out.printf("\n");
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


