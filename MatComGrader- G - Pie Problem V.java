//MatComGrader- G - Pie Problem V
/*
Tematica: Geometria +Fuerza bruta  

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
    
    private double distanceCenter(double _x, double _y){
        return Math.sqrt(_x*_x+_y*_y);
    }
    
    public void solve() throws IOException {
        int nDisparos,totalpuntos=0,x,y,puntosDiana,puntoDisparo;
        double d;
        double [] dianas =new double[10];
        
        dianas[0]=nextDouble();
        nDisparos=nextInt();
        
        for(int i=1;i<dianas.length;i++){
            dianas[i]=dianas[i-1]*2;
        }
        
        for(int i=0;i<nDisparos;i++){
            x= nextInt();
            y=nextInt();
            puntosDiana=10;
            d =distanceCenter(x,y);
            puntoDisparo =0;
            for(int j=0;j<dianas.length && puntoDisparo == 0;j++,puntosDiana-- ){
                if(dianas[j]>=d){
                    puntoDisparo=puntosDiana;
                }
            }
            totalpuntos+=puntoDisparo;
        }
        
        out.printf("%d\n",totalpuntos);
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


