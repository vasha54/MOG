// MatComGrader - B - Bolsa de Caramelos

/*
Tematica: Combinatoria + Máscara de bits

Idea Basica: Con la mascara de bits generar todos los posibles subcojuntos de k elementos que sumen s. Optimizado
con poda.
*/
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


public class Main {



    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 510;

    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
    private long [] cards = {1,10,100,1000,10000};


    public void solve() throws Exception {
        int n,k,s;

        n = nextInt();
        k = nextInt();
        s = nextInt();
        
        int answer;

        while(n!=0 || k!=0 || s!=0) {

            answer =0;
            
            for(int i=0;i<(1<<n);i++){
                int tmpK=0;
                int tmpS=0;
                for(int j=0;j<n;j++){
                    if( (i & (1<<j)) == (1<<j)){
                    //    out.printf("%d ",j+1);
                        tmpK++;
                        tmpS+=(j+1);
                    }
                    if(tmpK>k || tmpS>s)
                      break;
                }
                if(k==tmpK && s==tmpS)
                    answer++;
               // out.printf(" :%d\n",tmpS);
            }
            
            out.printf("%d\n",answer);
            //out.printf("***************************\n");   
             n = nextInt();
             k = nextInt();
             s = nextInt();
        }

    }

    Main() throws Exception {
        /*Esta entrada  se debe activar cuando se hace una ejercicio de lectura hasta fin de fichero
        copiar la entrada en un fichero "Input.txt" y comentar el otro in . A la hor de enviar comentar
        este y descomentar el otro
        */
        //in = new BufferedReader(new FileReader("Input.txt"));
        //out = new PrintWriter(new FileWriter("Output.txt"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        in.close();
        out.close();
    }

    private void eat(String str) {
        st = new StringTokenizer(str);
    }

    String next() throws Exception {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
