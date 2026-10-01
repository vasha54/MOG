/**
 * MOG - A - Again? Solving Queries?
 * Temática: Segment Tree con Lazy Propagation, Aritmética modular
 *
 * Idea: El arreglo inicial es todo ceros. Se piden tres operaciones:
 *   1 i j v : sumar v al rango [i,j].
 *   2 i j   : asignar al rango [i,j] la secuencia 1,2,3,...,j-i+1.
 *   3 i j   : contar cuántos números en [i,j] son divisibles por 5.
 *
 * Como solo importa la divisibilidad por 5, reducimos todos los valores
 * módulo 5. Cada nodo del segment tree almacena un arreglo cnt[5] con la
 * cantidad de elementos de cada residuo (0..4) en su segmento.
 *
 * - Para la operación 1 (sumar v): los residuos se desplazan cíclicamente
 *   en v mod 5. Se actualiza cnt rotando y se acumula lazy_add.
 *
 * - Para la operación 2 (asignar secuencia creciente desde 1): dentro de un
 *   segmento, la secuencia es una progresión aritmética de paso 1. Dado el
 *   valor inicial en la posición izquierda del segmento, los residuos siguen
 *   un ciclo de período 5. Se calculan las frecuencias de cada residuo en
 *   O(1) usando división entera. Se marca lazy_set con el valor inicial en
 *   la posición izquierda (mód 5) y se limpia lazy_add.
 *
 * - Lazy propagation: al bajar, primero se aplica set (si existe) a los
 *   hijos (calculando su valor inicial a partir del padre y la longitud del
 *   hijo izquierdo), y luego se aplica add (si existe). El orden importa:
 *   set resetea cualquier add previo.
 *
 * Complejidad: O((n + q) log n) con constante pequeña (5 residuos). n ≤ 1e5,
 * q ≤ 5e4, perfectamente eficiente.
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

struct Node {
    int cnt[5];
    bool lazy_set;
    int lazy_set_start; 
    int lazy_add;       
    Node() {
        memset(cnt, 0, sizeof(cnt));
        lazy_set = false;
        lazy_set_start = 0;
        lazy_add = 0;
    }
};

vector<Node> tree;
int n;

void get_counts(int len, int s, int cnt[5]) {
    int q = len / 5;
    int rem = len % 5;
    for (int r = 0; r < 5; ++r) {
        cnt[r] = q;
        int offset = (r - s + 5) % 5;
        if (offset < rem) cnt[r]++;
    }
}

void apply_set(int node, int l, int r, int s) {
    get_counts(r - l + 1, s, tree[node].cnt);
    tree[node].lazy_set = true;
    tree[node].lazy_set_start = s;
    tree[node].lazy_add = 0;
}

void apply_add(int node, int v) {
    if (v == 0) return;
    int new_cnt[5] = {0};
    for (int r = 0; r < 5; ++r) {
        new_cnt[(r + v) % 5] = tree[node].cnt[r];
    }
    for (int r = 0; r < 5; ++r) tree[node].cnt[r] = new_cnt[r];
    if (tree[node].lazy_set) {
        tree[node].lazy_set_start = (tree[node].lazy_set_start + v) % 5;
    } else {
        tree[node].lazy_add = (tree[node].lazy_add + v) % 5;
    }
}

void push(int node, int l, int r) {
    if (l == r) {
        tree[node].lazy_set = false;
        tree[node].lazy_add = 0;
        return;
    }
    int mid = (l + r) / 2;
    int left_len = mid - l + 1;
    if (tree[node].lazy_set) {
        apply_set(node * 2, l, mid, tree[node].lazy_set_start);
        int right_start = (tree[node].lazy_set_start + left_len) % 5;
        apply_set(node * 2 + 1, mid + 1, r, right_start);
        tree[node].lazy_set = false;
    }
    if (tree[node].lazy_add) {
        apply_add(node * 2, tree[node].lazy_add);
        apply_add(node * 2 + 1, tree[node].lazy_add);
        tree[node].lazy_add = 0;
    }
}

void build(int node, int l, int r) {
    if (l == r) {
        tree[node].cnt[0] = 1;
        for (int i = 1; i < 5; ++i) tree[node].cnt[i] = 0;
        return;
    }
    int mid = (l + r) / 2;
    build(node * 2, l, mid);
    build(node * 2 + 1, mid + 1, r);
    for (int i = 0; i < 5; ++i) {
        tree[node].cnt[i] = tree[node * 2].cnt[i] + tree[node * 2 + 1].cnt[i];
    }
}

void update_add(int node, int l, int r, int ql, int qr, int v) {
    if (ql <= l && r <= qr) {
        apply_add(node, v);
        return;
    }
    push(node, l, r);
    int mid = (l + r) / 2;
    if (ql <= mid) update_add(node * 2, l, mid, ql, qr, v);
    if (qr > mid) update_add(node * 2 + 1, mid + 1, r, ql, qr, v);
    for (int i = 0; i < 5; ++i) {
        tree[node].cnt[i] = tree[node * 2].cnt[i] + tree[node * 2 + 1].cnt[i];
    }
}

void update_set(int node, int l, int r, int ql, int qr, int i) {
    if (ql <= l && r <= qr) {
        int s = ((l - i + 1) % 5 + 5) % 5;
        apply_set(node, l, r, s);
        return;
    }
    push(node, l, r);
    int mid = (l + r) / 2;
    if (ql <= mid) update_set(node * 2, l, mid, ql, qr, i);
    if (qr > mid) update_set(node * 2 + 1, mid + 1, r, ql, qr, i);
    for (int i = 0; i < 5; ++i) {
        tree[node].cnt[i] = tree[node * 2].cnt[i] + tree[node * 2 + 1].cnt[i];
    }
}

int query(int node, int l, int r, int ql, int qr) {
    if (ql <= l && r <= qr) {
        return tree[node].cnt[0];
    }
    push(node, l, r);
    int mid = (l + r) / 2;
    int res = 0;
    if (ql <= mid) res += query(node * 2, l, mid, ql, qr);
    if (qr > mid) res += query(node * 2 + 1, mid + 1, r, ql, qr);
    return res;
}

signed main() {
    OPTIMIZAR_IO
    //PRESICION(0)
    READ_FILE
    //WRITE_FILE
    int q;
    cin >> n >> q;

    tree.resize(4 * n + 5);
    build(1, 1, n);

    while (q--) {
        int type;
        cin >> type;
        if (type == 1) {
            int i, j, v;
            cin >> i >> j >> v;
            update_add(1, 1, n, i, j, v % 5);
        } else if (type == 2) {
            int i, j;
            cin >> i >> j;
            update_set(1, 1, n, i, j, i);
        } else {
            int i, j;
            cin >> i >> j;
            cout << query(1, 1, n, i, j) << ENDL;
        }
    }
    return 0;
}