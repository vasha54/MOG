//MatComGrader- Dates

/*
Tematica: String + KMP

Idea basica: Si manejo la secuencias de dias como una cadena de caracteres estaria buscando una subsecuencia de caracteres concecutivos que puede repertirse dentro de otra cadena que es la seguencia de caracteres que representa dos año normal uno bisiesto y otros dos normales y eso se reduce aplicar un KMP
*/
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
    
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 510;
    
    private String [] months = {"","January","February","March","April","May","June","July",
    "August","September","October","November","December" }; 
    
    public void generateSequenceDays(ArrayList <Integer> d, ArrayList<Integer> m){
        for(int i=0;i<5;i++){
            for(int k=1;k<=31;k++){ d.add(k); m.add(1);} //Enero
            for(int k=1;k<=28;k++){ d.add(k);m.add(2);} //Febrero
            if(i==2){d.add(29);m.add(2);}
            for(int k=1;k<=31;k++){ d.add(k);m.add(3);} //Marzo
            for(int k=1;k<=30;k++){ d.add(k);m.add(4);} //Abril
            for(int k=1;k<=31;k++){ d.add(k);m.add(5);} //Mayo
            for(int k=1;k<=30;k++){ d.add(k);m.add(6);} //Junio
            for(int k=1;k<=31;k++){ d.add(k);m.add(7);} //Julio
            for(int k=1;k<=31;k++){ d.add(k);m.add(8);} //Agosto
            for(int k=1;k<=30;k++){ d.add(k);m.add(9);} //Septiembre
            for(int k=1;k<=31;k++){ d.add(k);m.add(10);} //Octubre
            for(int k=1;k<=30;k++){ d.add(k);m.add(11);} //Noviembre
            for(int k=1;k<=31;k++){ d.add(k);m.add(12);} //Diciembre
        }    
    }
    
    public ArrayList<Integer>  KMP(ArrayList<Integer> _text, ArrayList<Integer> _pattern,
    ArrayList<Integer> _months){
        ArrayList<Integer> matches = new ArrayList<Integer>();
        int [] P = new int [Math.max(_text.size(),_pattern.size())];
        
        int n_pattern = _pattern.size();
        int n_text = _text.size();
        
        Arrays.fill(P,0,P.length,-1);
        
        for(int i=0, j=-1; i<n_pattern;){
            while(j>-1 && _pattern.get(i) != _pattern.get(j))
                j = P[j];
            i++;
            j++;
            P[i] = j;
        }
        
        for(int i=0, j=0; i< n_text;){
            while(j>-1 && _text.get(i) != _pattern.get(j))
                j =P[j];
            i++;
            j++;
            if(j == n_pattern){
                matches.add(_months.get(i-1));
                j=P[j];
            }
        }
        
        return matches;
    }
    
    public void solve() throws Exception {
        int ndays=nextInt();
        ArrayList<Integer> days =new ArrayList<Integer>();
        
        ArrayList<Integer> sequecenceDays =new ArrayList<Integer>();
        ArrayList<Integer> sequecenceMonths =new ArrayList<Integer>();
    
        generateSequenceDays(sequecenceDays,sequecenceMonths);
    
        for(int i=0;i<ndays;i++)
           days.add(nextInt());
           
        TreeSet<Integer> kmp = new TreeSet<Integer>(KMP(sequecenceDays,days,sequecenceMonths));
        Iterator<Integer> it = kmp.iterator();
        out.printf("%d\n",kmp.size());
        while(it.hasNext()){
            int p = it.next();
            out.printf("%s\n",months[p]);
        } 
        
        
    }
    
    Main() throws Exception {
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


