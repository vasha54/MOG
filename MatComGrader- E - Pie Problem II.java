//MatComGrader- E - Pie Problem II
/*
Tematica: Teoría de Numero+ Factorización con numeros primos 

Idea basica: 
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
    
    private static class Factor {
        public int value;
        public int exponente;
        
        public Factor(int _value, int _exponente){
            this.value = _value;
            this.exponente =  _exponente;
        }
    }
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 110;
    private ArrayList<Integer> primes;
    
    private int gcd(int a,int b){
        while ( b > 0){
            a = a %b ;
            a ^= b ;
            b ^= a ;
            a ^= b ;
        }
        return a ;
    }
    
    public void cribePrimes(){
        boolean [] isPrime =new boolean[MAX_N];
        primes =new ArrayList<Integer>();
        Arrays.fill(isPrime,0,isPrime.length,true);
        int root =(int)Math.sqrt(MAX_N)+1;
        for(int i=2;i<=root;i++){
            if(isPrime[i]){
                primes.add(i);
                for( int j=i*i;j<isPrime.length;j+=i)
                    isPrime[j]=false;
            }
        }
        for(int k=root+1;k<isPrime.length;k++){
            if(isPrime[k]){
                primes.add(k);
            }
        }
    }
    
    private ArrayList<Factor> factorizarFactorial( int n ) {
        int l = primes.size() ;
        ArrayList<Factor>FP =new ArrayList<Factor>();
        for( int i =0; i <l && primes.get(i)<=n ; i++){
            int exp = 0 ;
            int pot = primes.get(i);
            while ( pot<=n ) {
                exp+=n/pot ;
                pot*=primes.get(i);

            }
            FP.add( new Factor(primes.get(i),exp) ) ;
        }
        return FP ;
    }
    
    public void solve() throws IOException {
        cribePrimes();
        int N =nextInt();
        ArrayList<Factor> factores = factorizarFactorial(N);
        int cOuntPrimes =0;
        for(int i=0;i<factores.size();i++){
            cOuntPrimes+=factores.get(i).exponente;
        }
        out.printf("%d\n",cOuntPrimes);
        
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


