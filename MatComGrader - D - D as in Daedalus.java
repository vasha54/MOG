// MatComGrader - D - D as in Daedalus

/*
Tematica:Add-Hoc 

Idea Basica: Simular la partida tal y como la dan y llevar en cada rronda cual hubiera sido la mejor carta y llevar
la puntuación para ese modo y luego el maximo entre 0 y la diferencia modo de juego optimo y modo juego normal
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
    private long [] cards ={1,10,100,1000,10000};
   
    public void solve() throws Exception {
        int rounds,player;
        long sumOtherPlayer, bank,extraPoints,points,point;
     
        player = nextInt();
        rounds =nextInt();
        
        extraPoints=0;
        points = 0;
        
        for(int i=0;i<rounds;i++){
            bank = nextLong();
            point= nextLong();
            sumOtherPlayer =0;
            for(int j=1;j<player;j++){
                sumOtherPlayer+=nextLong();
            }
            
            long best =0;
            
            for(int k=cards.length-1;k>=0 && best==0;k--){
                if(cards[k]+sumOtherPlayer<=bank)
                    best = cards[k];
            }
            
            if(best == 0)
                best = point;
            
            if(best+sumOtherPlayer<=bank)
                extraPoints +=best;
            if(point+sumOtherPlayer<=bank)    
                points+=point;
        }
        
        out.println(Math.max(0,extraPoints-points));
    }
    
    Main() throws Exception {
       /*Esta entrada  se debe activar cuando se hace una ejercicio de lectura hasta fin de fichero 
       copiar la entrada en un fichero "Input.txt" y comentar el otro in . A la hor de enviar comentar
       este y descomentar el otro
       */
       in = new BufferedReader(new FileReader("Input.txt"));
       //out = new PrintWriter(new FileWriter("Output.txt"));
       //in = new BufferedReader(new InputStreamReader(System.in));
	   out = new PrintWriter(System.out);
       eat("");
       solve();
       in.close();
       out.close();
    }

    private void eat(String str) { st = new StringTokenizer(str);}

    String next() throws Exception {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {return Integer.parseInt(next());}

    long nextLong() throws Exception {return Long.parseLong(next());}

    double nextDouble() throws Exception {return Double.parseDouble(next());}

    public static void main(String[] args) throws Exception {new Main();}

}
