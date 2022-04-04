//MatComGrader - A Symmetrical Pizza
/*

Tematica: Aritmetica - Algebra

Idea basica: Buscar el maximo comun entre 360 y el angulo de simetria. El detalle radica que como dicho
angulo es hasta con dos lugares despues de la coma debemos convertilo esta parte decimal en entera por
tanto vamos hallar el gcd entre 36000 y el angulo de simetria miltiplicado por 100

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
    
    public void solve() throws IOException {
		double angleSymetry = nextDouble();
        angleSymetry = angleSymetry * 1000;
        int angle = (int) angleSymetry;
		int gcdT = gcd(360000,angle);
		out.printf("%d\n",360000/gcdT);
		
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
