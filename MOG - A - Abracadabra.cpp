/**
 * MOG - A - Abracadabra
 * Temáticas: Programacion Dinámica.
 *
 * Idea: Encontrar dentro de una cadena la cantidad de ocurrencias de un
 * determinado patrón como una subsecuencia de caracteres de no necesariamente
 * consecutivos cuyo valor debe ser modulado.
 **/
#include <bits/stdc++.h>
#include <math.h>
#define ENDL '\n'
#define OPTIMIZAR_IO ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define PRESICION(x) cout.setf(ios::fixed,ios::floatfield); cout.precision(x);
#define MAX_N 1005
#define MOD 1000000007
#define EPS 1e-9
#define INF 1000000000
#define LL long long
#define ULL unsigned long long
#define pii pair<int,int>
#define ALPHABET_SIZE 26 //['a-z']
using namespace std;

char a[100010], b[110];

int main() {
	OPTIMIZAR_IO
	cin >> a >> b;
	int m = strlen(a);
	int n = strlen(b);
	long long look[m + 1][n + 1];
	for (int i = 0; i <= n; i++)
		look[0][i] = 0;

	for (int i = 0; i <= m; i++)
		look[i][0] = 1;

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (a[i - 1] == b[j - 1])
				look[i][j] = (look[i - 1][j - 1] + look[i - 1][j]) % MOD;
			else
				look[i][j] = look[i - 1][j];
		}
	}
	cout << look[m][n]<< ENDL;
	return 0;
}

