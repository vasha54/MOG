/**
 * MOG - C - Counting Products
 * Temática: Programación Dinámica, Mochila (unbounded) con suma y producto
 *
 * Idea: Se deben contar los enteros x en [1, n] que se pueden obtener como
 * producto de una lista de enteros positivos cuya suma sea exactamente k.
 * Los unos no afectan al producto, por lo que podemos considerar solo factores
 * mayores o iguales a 2. Si un multiconjunto de factores >=2 suma s ≤ k,
 * entonces podemos añadir (k - s) unos para completar la suma k sin alterar
 * el producto. Así, basta con encontrar todos los productos p ≤ n que se
 * puedan formar con factores >=2 cuya suma sea ≤ k.
 *
 * DP: dp[s][p] = ¿es posible formar el producto p con una suma s usando
 * factores >=2? Inicialmente dp[0][1] = true.
 * Para cada factor f = 2..k, se actualiza como mochila no acotada:
 *   para s = f..k:
 *     para p = 1..n/f:
 *       si dp[s-f][p] entonces dp[s][p*f] = true.
 *
 * Al final, un producto p es alcanzable si existe algún s ≤ k con
 * dp[s][p] = true. Contamos cuántos p en [1, n] cumplen esto.
 *
 * Complejidad: O(k * n * log k) ≈ 7·10^6 operaciones para n, k ≤ 1000.
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
#define MAX_N 2005
#define MAX_PRIMES 2000010
#define MAX_TREE MAX_N << 2
#define MOD  1000000007
#define MID (right+left)/2

using namespace std;



signed main() {
    OPTIMIZAR_IO
    //PRESICION(2)
    READ_FILE
    //WRITE_FILE
    int n, k;
    cin >> n >> k;

    vector<vector<bool>> dp(k + 1, vector<bool>(n + 1, false));
    dp[0][1] = true;

    for (int f = 2; f <= k; ++f) {
        for (int s = f; s <= k; ++s) {
            for (int p = 1; p * f <= n; ++p) {
                if (dp[s - f][p]) {
                    dp[s][p * f] = true;
                }
            }
        }
    }

    int ans = 0;
    for (int p = 1; p <= n; ++p) {
        bool ok = false;
        for (int s = 0; s <= k; ++s) {
            if (dp[s][p]) {
                ok = true;
                break;
            }
        }
        if (ok) ++ans;
    }

    cout << ans << ENDL;

    return 0;
}