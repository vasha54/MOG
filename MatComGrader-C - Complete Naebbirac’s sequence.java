//MatComGrader-C - Complete Naebbirac’s sequence
/*
Tematica: Add-Hoc  

Idea basica: 
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
        int K = nextInt();
        int N = nextInt();
        int x;
        int [] counting =new int [K+1];
        
        Arrays.fill(counting,0,counting.length,0);
        
        for(int i=0;i<N;i++){
           x =nextInt();
           counting[x]++;
        }
        
        ArrayList<Integer> valuesMin =new ArrayList<Integer>(); 
        int cMin=Integer.MAX_VALUE;
        
        int cMax=Integer.MIN_VALUE;
        ArrayList<Integer> valuesMax =new ArrayList<Integer>();
        
        for(int i=1;i<=K;i++){
            
            if(counting[i] < cMin){
                valuesMin.clear();
                valuesMin.add(i);
                cMin = counting[i];
            }else if(counting[i] == cMin){
                valuesMin.add(i);
            }
            
            if(counting[i] > cMax){
                valuesMax.clear();
                valuesMax.add(i);
                cMax = counting[i];
            }else if(counting[i] == cMax){
                valuesMax.add(i);
            }
        }
        
        if( valuesMin.size()==1 && valuesMax.size()==1 && cMax-cMin==2 ){
           out.printf("-%d +%d\n",valuesMax.get(0),valuesMin.get(0));
        }else if( valuesMin.size()==1 && valuesMax.size()==K-1 && cMax-cMin==1 ){
           out.printf("+%d\n",valuesMin.get(0));
        }else if( valuesMin.size()==K-1 && valuesMax.size()==1 && cMax-cMin==1){
           out.printf("-%d\n",valuesMax.get(0));
        }else{
            out.printf("*\n");
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


