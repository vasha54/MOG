//MatComGrader - Hour y minutes

/*
Tematica:Add-Hocc + Simulacion

Idea basica: Conociendo que cada doce minutos se mueve el indicador de la hora en un reloj podemos
simular doce horas del día (las otras doce va ocurrir los mismo) y sabiendo que entre cada indicador hay
6 grados podemos precalcular todas los posibles grados almacenarlos en una colección que los mantenga ordenados
sin reperirlos y que realice la busqueda rapida (Set). Luego para cada valor entrado los buscamos en la colección
de estar la respuesta es Y en caso contrario N.

*/
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
    
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 510;
    
    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
   
    public void solve() throws Exception {
        String line=null;
        Set<Integer> angles =new TreeSet<Integer>();
        
        //Precalculo de los ángulos
        int minutes = 0;
        int hour = 0;
        
        do{
            angles.add(Math.abs(minutes-hour)*6);
            minutes++;
            if(minutes%12==0)
                hour++;
            minutes%=60;
        }while(hour<=59);
        
        //Lectura de datos
        while((line=next())!=null){
            eat(line);
            int angle = nextInt();
            out.printf("%s\n",(angles.contains(angle)==true ? "Y" : "N"));
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


