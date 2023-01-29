/**
 * Matcom Online Grader - Lost Key
 * Temática: Add-Hoc + String
 */
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


public class Lost_Key {
    
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;
    private final int MAX_N = 1000001;
    private final int MAX_TREE = (MAX_N << 2);
    private final char SYMBOL = '@';
    
    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
    private long [] cards ={1,10,100,1000,10000};
    private long MOD =1000000009;
    
    
   
    public void solve() throws Exception {
    	String A = next();
    	String B = next();
    	int k = nextInt();
    	
    	char [] keys = new char[k];
    	Arrays.fill(keys, SYMBOL);
    	boolean findKey = true;
    	
    	for(int i=0;i<A.length() && findKey == true;i++) {
    		char key = searchKey(A.charAt(i),B.charAt(i));
    		int posKey = i%k;
    		if(keys[posKey] == SYMBOL)
    			keys[posKey] = key;
    		else if(keys[posKey]!=key)
    			findKey =false;
    	}
    	
    	out.printf("%s\n", (findKey==true)? String.valueOf(keys) :"-1");
        
    }
    
    private char searchKey(char source, char encrypted) {
    	if(encrypted < source)encrypted+=26;
		int x = ((int)encrypted-(int)source)%26;
		return (char) ('a' +x);
	}

	Lost_Key() throws Exception {
       /*Esta entrada  se debe activar cuando se hace una ejercicio de lectura hasta fin de fichero 
       copiar la entrada en un fichero "Input.txt" y comentar el otro in . A la hor de enviar comentar
       este y descomentar el otro
       */
       //in = new BufferedReader(new FileReader("Inpu.txt"));
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

    public static void main(String[] args) throws Exception {new Lost_Key();}

}
