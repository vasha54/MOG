/**
 * MatCom Grader - E - Lucky Numbers on MOG
 * Temáticas: Teoría de numeros+ Base númerica +AddHoc
 *
 * Idea: Hacer una reinterpretación de la representación de los
 * números en binarios con los digitos 4 y 7 y ver regla de formación
 * que tienen los numeros que solamente lo integran estos digitos
 * .
 */
#include <iostream>
#include <bits/stdc++.h>
#define ENDL '\n'
#define MAX 110
using namespace std;

int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cout.setf(ios::fixed, ios::floatfield);
	cout.precision(0);

	long long pow = 2;
	int nbits = 1;
	long K;
	cin >> K;
	while (pow - 1 <= K) {
		pow *= 2;
		nbits++;
	}

	pow /= 2L;
	pow -= 1L;
	nbits--;
	K -= pow;

	string answer = "";
	while (K / 2 != 0) {
		answer = (K % 2 == 0 ? "4" : "7") + answer;
		K /= 2;
	}

	answer = (K % 2 == 0 ? "4" : "7") + answer;

	while(answer.size() < nbits)
		answer = "4" + answer;

	cout<<answer<<ENDL;

	return 0;
}
