//MatComGrader- Cocktails
/*
Tematica: Greedy  

Idea basica: 
*/
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
    private static class Coctel implements Comparable<Coctel>{
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
        boolean isPosible =true;
        
        int countCoctels = nextInt();
        
        Coctel [] cocteles =new Coctel[countCoctels];
        
        for(int i=0;i<cocteles.length;i++ ){
            String color=next();
            int density = nextInt();
            cocteles[i] = new Coctel(color,density);
        }
        
        Arrays.sort(cocteles);
        
        int nrequest = nextInt();
        
        String [] request = new String [nrequest];
        
        for(int i=0;i<nrequest;i++){
            request[i] = next();
        }
        
        int indexRequest=0,indexCoctel=0;
        int lastTake =-1;
        
        while( indexCoctel < cocteles.length && indexRequest < request.length ){
            if( request[indexRequest].compareTo( cocteles[indexCoctel].color) == 0 ){
               if(lastTake==-1){
                  lastTake=indexCoctel;
                  indexRequest++;
               }else if(lastTake!=-1 && cocteles[lastTake].density < cocteles[indexCoctel].density){
                  lastTake=indexCoctel;
                  indexRequest++;
               }
               
            }
            indexCoctel++;
        }
        
        if(indexRequest != nrequest){
            isPosible = false;
        }
        
        if(isPosible) out.printf("Yes\n");
        else out.printf("No\n");
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


