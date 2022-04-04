//MatComGrader - Coloring tiles
/*

Tematica: Add-Hoc

Idea basica: Cuando se pinta tenenmos dos posibles opciones o secuencias :
La primera que empienza pintando en blanco luego negro y luego blanco y asi sucecivamente
La segunda que empienza pintando en negro luego blanco y luego negro y asi sucecivamente

Dada una secuencia tenemos que que calcular para cual de las dos secuencias posibles la secuencia
original sufre menos cambios y esa cantidad de de cambios será la respuesta.

*/
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    
    
    public void solve() throws IOException {
		String tiles;
        boolean white, black;
        int ntiles,differWhite,differBlack;
        
        tiles=next();
        ntiles=tiles.length();
        white =true;
        black = true;
        differBlack = 0 ;
        differWhite = 0;

        for(int i=0;i<ntiles;i++){
            if(tiles.charAt(i)=='1'){
                if (white == false){
                    differWhite++;
                }
                if (black == true){
                    differBlack++;
                }
            }

            if(tiles.charAt(i)=='0'){
                if (white == true){
                    differWhite++;
                }
                if (black == false){
                    differBlack++;
                }
            }

            white=!white;
            black=!black;
        }

        out.printf("%d\n",Math.min(differBlack,differWhite));
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
