#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: vasha
MOG - Elementos consecutivos. (https://matcomgrader.com/problem/9789/elementos-consecutivos/)
Tematica: Ordenamiento (CountingSort) + Búsqueda
Idea: Se tiene un grupo de valores que pueden existir valores repetidos y se 
quiere conformar un subcojunto con la mayor cardinalidad posible (la mayor 
cantidad de de elementos posibles) pero con la condición que cuando se ordene los
elementos el elmento que ocupa la posición i su diferencia con el ocupante de 
la posición i+1 (si existe la posición) sea de una una unidad y de igual forma 
la diferencia con el valor ocupante en la posición i-1(si existe la posición)
sea de 1. En otras palabras los valores deben ser consecutivos unos de otros y
cada elemento debe tener a su derecha su sucesor y a su izquierda su antecesor.

Aqui hay un detalle importante todos los valores son enteros positivos (naturales)
y menores 50000 y dicho dato es lo que da pie a la siguiente solución vamos a crear
un arreglo o vector de booleano con dicha capacidad con todas las posiciones en
False. La idea es aplicar un counting sort con la modificación que no me interesa
saber la cantidad de veces que se repite un valor sino solo conocer si esta o no.
De esta forma en counting[i] será True si el valor i esta en los valores iniciales
al menos una vez y False en caso contrario. Si procesamos todos los valores y
ponemos en True la posiciones de los valores el problema se reduce a encontrar
la secuencia de valores True consecutivos mas larga en counting. Para esto basta
con tener dos contadores uno (consecutive) que se incremente en uno cuando se 
encuentre una posición en True o cambie a 0 cuando no sea asi y otro (answer)
que almacene sieempre el maximo valor tomado en algún momento por consecutive.

Compleidad: O(n)

Analiznado el ejemplo
5
1 4 6 12 5

            0  1  2  3  4  5  6  7  8  9  10  11  12
counting = [F ,F ,F ,F ,F ,F ,F, F ,F ,F ,F  ,F  ,F ] 

Despues de procesar los valores

            0  1  2  3  4  5  6  7  8  9  10  11  12
counting = [F ,T ,F ,F ,T ,T ,T, F ,F ,F ,F  ,F  ,T ] 

consecutive toma los valores de 0, 1, 0, 3, 0, 1 siendo 3 el maximo por
tanto respuesta

"""
import math
from collections import deque
from itertools import chain

if __name__ == '__main__':
    n = int(input())
    MAX_VALUE = 50010
    values_str = input().split()
    values = [int(x) for x in values_str ]
    counting = [False for _ in range(0,MAX_VALUE) ]
    for x in values:
       counting[x] = True
    answer = 0
    consecutive = 0
    for i in range(0,MAX_VALUE):
       if counting[i] == True:
          consecutive = consecutive + 1
       else:
          consecutive = 0
       answer = max(answer,consecutive)
    print(answer)