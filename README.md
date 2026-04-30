# Route Optimization Toolkit (Graph Algorithms)

## Descripción

Este proyecto implementa y visualiza un sistema de optimización de rutas basado en teoría de grafos.  
El objetivo es resolver una aproximación al problema del viajante (TSP) utilizando estructuras y algoritmos clásicos.

Se combina:
- Construcción de grafos completos
- Árbol de expansión mínima (MST)
- Algoritmo de Kruskal
- Recorrido de grafos
- Optimización heurística de rutas
- Visualización dinámica en Java Swing

## Problema que resuelve

Dado un conjunto de puntos (clientes), se busca encontrar una ruta eficiente que minimice la distancia total de recorrido.

Este problema es una versión del: traveling Salesman Problem (TSP)

##  Algoritmos utilizados

###  Kruskal (MST)
Se utiliza para construir un árbol de expansión mínima del grafo completo.
Basado en teoría de grafos y conjuntos disjuntos.

###  BFS / DFS
Se emplean para recorrer el grafo y generar una ruta inicial a partir del MST.

###  Heurística 2-opt
Mejora la solución inicial intercambiando segmentos de la ruta para reducir la distancia total.


##  Modelización matemática

El problema se modela como un grafo completo ponderado:

- Vértices: puntos en el plano
- Aristas: distancia euclídea entre puntos

Función objetivo:

Minimizar la distancia total del recorrido: min Σ d(vᵢ, vᵢ₊₁)


##  Visualización

El proyecto incluye una visualización en Java Swing:

- Fondo negro
-  Nodos del grafo azul
-  Ruta óptima rojo
-  Nodo inicial verde
-  Animación del recorrido

## Estructura del proyecto
app/ → Main del programa 

graph/ → Algoritmos de grafos (Kruskal, Node, etc.)
  
tsp/ → Algoritmos del TSP

utils/ → Funciones auxiliares

visual/ → Visualización

## Cómo ejecutar
1. Compilar el proyecto
2. Ejecutar `Main.java`

Ejemplo:
```bash
javac app/Main.java
java app.Main

