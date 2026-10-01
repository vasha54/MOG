/**
 * MOG - G - Keyboard Patterns
 * Temática: DFS, Bitmask, Geometría en grid 3x3
 *
 * Idea: Se tiene un teclado 3x3 donde algunas teclas están dañadas ('X') y
 * otras funcionan ('.'). Se deben contar todos los patrones válidos que se
 * pueden formar usando únicamente las teclas funcionales, siguiendo las
 * reglas del desbloqueo de Android:
 *   - Se puede empezar en cualquier tecla funcional.
 *   - Desde la tecla actual se puede saltar a cualquier otra tecla funcional
 *     no visitada, siempre que en la línea recta entre ambas no haya ninguna
 *     tecla funcional sin visitar.
 *   - Las teclas dañadas se ignoran por completo (ni bloquean ni se añaden).
 *   - Un patrón puede terminar en cualquier momento (cuando se levanta el dedo).
 *
 * Como el tablero es 3x3, el número máximo de teclas funcionales es 9.
 * Podemos usar DFS con memoización sobre el estado (máscara de teclas
 * visitadas, tecla actual). Para cada par de teclas funcionales (i, j)
 * precalculamos la máscara de teclas funcionales que están estrictamente
 * entre ellas en la línea recta. Una transición i -> j es válida si todas
 * las teclas de esa máscara ya están visitadas (es decir, (interm[i][j] & ~mask) == 0).
 *
 * La función f(mask, cur) devuelve el número de patrones que se pueden formar
 * partiendo del estado actual, incluyendo la opción de terminar aquí (sumando 1).
 * La respuesta total es la suma de f(1<<i, i) para cada tecla funcional i.
 *
 * Complejidad: O(T * 2^K * K^2) con K ≤ 9, T ≤ 1000. Muy rápido.
 */
#include <bits/stdc++.h>

#define ENDL '\n'
#define OPTIMIZAR_IO ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define PRESICION(x) cout.setf(ios::fixed,ios::floatfield); cout.precision(x);

#ifdef LOCAL
    #define READ_FILE freopen("Input.txt","r",stdin);
    #define WRITE_FILE freopen("Output.txt","w",stdout);
#else
    #define READ_FILE
    #define WRITE_FILE
#endif
#define int long long
#define REP(x) for(int i=0;i<x;i++)
#define uint unsigned long long
#define PRINT_LINE cout<<ENDL;
#define pii pair<int,int>
#define tiii tuple<int,int,int>
#define MAX_N 10005
#define MAX_PRIMES 2000010
#define MAX_TREE MAX_N << 2
#define MOD  1000000007
#define MID (right+left)/2
#define OO 4000000000000000000

using namespace std;

int K;
int coord[9][2];          
int interm[9][9];         
int dp[1<<9][9];   

bool isBetween(int i, int j, int k) {
    int r1 = coord[i][0], c1 = coord[i][1];
    int r2 = coord[j][0], c2 = coord[j][1];
    int r3 = coord[k][0], c3 = coord[k][1];
    if ((c2 - c1) * (r3 - r1) != (r2 - r1) * (c3 - c1)) return false;
    if (r3 < min(r1, r2) || r3 > max(r1, r2)) return false;
    if (c3 < min(c1, c2) || c3 > max(c1, c2)) return false;
    if ((r3 == r1 && c3 == c1) || (r3 == r2 && c3 == c2)) return false;
    return true;
}

int f(int mask, int cur) {
    if (dp[mask][cur] != -1) return dp[mask][cur];
    int res = 1; 
    for (int j = 0; j < K; ++j) {
        if (!(mask & (1<<j))) {
            if ((interm[cur][j] & ~mask) == 0) {
                res += f(mask | (1<<j), j);
            }
        }
    }
    return dp[mask][cur] = res;
}

signed main() {
    OPTIMIZAR_IO
    //PRESICION(0)
    READ_FILE
    //WRITE_FILE
    int T;
    cin >> T;
    while (T--) {
        vector<string> grid(3);
        for (int i = 0; i < 3; ++i) cin >> grid[i];

        K = 0;
        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 3; ++c) {
                if (grid[r][c] == '.') {
                    coord[K][0] = r;
                    coord[K][1] = c;
                    ++K;
                }
            }
        }

        if (K == 0) {
            cout << 0 << ENDL;
            continue;
        }

        for (int i = 0; i < K; ++i) {
            for (int j = 0; j < K; ++j) {
                interm[i][j] = 0;
                if (i == j) continue;
                for (int k = 0; k < K; ++k) {
                    if (k == i || k == j) continue;
                    if (isBetween(i, j, k)) {
                        interm[i][j] |= (1 << k);
                    }
                }
            }
        }

        memset(dp, -1, sizeof(dp));
        int total = 0;
        for (int i = 0; i < K; ++i) {
            total += f(1 << i, i);
        }
        cout << total << ENDL;
    }
    return 0;
}