// MatComGrader - B - Pie Problem IV

/*
Tematica: Miscelaneas: Cuadrado magico

Idea: Generar un cuadrado magico para cualquier orden con N >=3 que cumple para las restricciones
de problema en el caso de 1 y 2 imprimir literalemente la solución
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
    private final int MAX_N = 1000000;

    private int [] movX = { 0, 0, 1, -1};
    private int [] movY = {-1, 1, 0,  0};
    
    
    public void generateSquareMagicOdd(int [][] _square, int _n){
        int p,q,number,tQ,tP;
        number =1;
        p= 0;
        q=_n/2;
        
        while(number<=_n*_n){
          _square[p][q]=number;
          tP=p; tQ=q; p--; q++;
          
          if(p<0) p=_n-1;
          if(q>=_n ) q=0;
          
          if(_square[p][q]!=0){
            q=tQ;
            p=tP+1;
          }
          
          number++;
        }
    }
    
    public void generateSquareMagic4K(int [][] _square, int _n){
        int number=1;
        for(int i=0;i<_n;i++){
            for(int j=0;j<_n;j++)
                _square[i][j]=number++;
        }
        
        for(int i=_n/4;i<_n/4+_n/2;i++){
            for(int j=0;j<_n/4;j++)
                _square[i][j]=number-_square[i][j];
        }
        
        for(int i=_n/4;i<_n/4+_n/2;i++){
            for(int j=_n-_n/4;j<_n;j++)
                _square[i][j]=number-_square[i][j];
        }
        
        for(int i=0;i<_n/4;i++){
            for(int j=_n/4;j<_n/2+_n/4;j++)
                _square[i][j]=number-_square[i][j];
        }
        
        for(int i=_n-_n/4;i<_n;i++){
            for(int j=_n/4;j<_n/2+_n/4;j++)
                _square[i][j]=number-_square[i][j];
        }
    }
    
    public void generateSquareMagic4KPlus2(int [][] _square, int _n){
        int size = _n * _n;
        int halfN = _n / 2;
        int subSquareSize = size / 4;
 
        int[][] subSquare =new int [halfN][halfN] ;
        generateSquareMagicOdd(subSquare,halfN);
        int[] quadrantFactors = {0, 2, 3, 1};
        
        for (int r = 0; r < _n; r++) {
            for (int c = 0; c < _n; c++) {
                int quadrant = (r / halfN) * 2 + (c / halfN);
                _square[r][c] = subSquare[r % halfN][c % halfN];
                _square[r][c] += quadrantFactors[quadrant] * subSquareSize;
            }
        }
 
        int nColsLeft = halfN / 2;
        int nColsRight = nColsLeft - 1;
 
        for (int r = 0; r < halfN; r++)
            for (int c = 0; c < _n; c++) {
                if (c < nColsLeft || c >= _n - nColsRight
                        || (c == nColsLeft && r == nColsLeft)) {
 
                    if (c == 0 && r == nColsLeft)
                        continue;
 
                    int tmp = _square[r][c];
                    _square[r][c] = _square[r + halfN][c];
                    _square[r + halfN][c] = tmp;
                }
            }
    }
    
    public int [][] generateSquareMagic(int _n){
        int [][] square=new int [_n][_n];
        if(_n%2==1) generateSquareMagicOdd(square,_n);
        else if(_n%4==2) generateSquareMagic4KPlus2(square,_n);
        else generateSquareMagic4K(square,_n);    
        return square;
    }

    public void solve() throws Exception {
        int N = nextInt();
        switch(N){
            case 1:
                out.printf("%d\n",1);
                break;
            case 2:
                out.printf("%d %d\n",2,3);
                out.printf("%d %d\n",4,1);
                break;
            default:
                int [][] squareMagic=generateSquareMagic(N);
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(j!=0)out.printf(" ");
                        out.printf("%d",squareMagic[i][j]);
                    }
                    out.printf("\n");
                }
                break;
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
