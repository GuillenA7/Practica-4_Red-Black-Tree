# Practica 4 - Árbol Rojo-Negro - Estructuras de Datos y Algoritmia

Este Repositorio implementa un árbol rojo-negro en Java, una estructura de datos balanceada que garantiza operaciones eficientes de inserción, búsqueda y eliminación en tiempo logarítmico. A continuación, se presenta una guía general sobre su funcionamiento y estructura.

## Estructura del Árbol Rojo-Negro

### Clase `ArbolRojoNegro`:

- `Nodo raiz`: Representa el nodo raíz del árbol.
- `insertar(int dato)`: Método público para insertar un nuevo dato en el árbol.
- `insertarBST(Nodo raiz, Nodo nuevoNodo)`: Método privado recursivo para insertar un nuevo nodo en el árbol binario de búsqueda (BST).
- `corregirViolacion(Nodo z)`: Método privado que corrige las violaciones de las propiedades del árbol rojo-negro después de la inserción.
- `rotarIzquierda(Nodo x)` y `rotarDerecha(Nodo x)`: Métodos privados para realizar rotaciones izquierda y derecha respectivamente, necesarios para mantener el balance del árbol.

### Clase `Nodo`:

- Contiene campos para almacenar el dato, color del nodo (ROJO o NEGRO), y referencias a los nodos izquierda, derecha y padre.

### Clase `Recorrido`:

- Métodos estáticos para realizar recorridos en el árbol: `enOrden`, `preOrden` y `postOrden`.
- `RecorridoHorizontal`: Método estático para imprimir el árbol horizontalmente, útil para visualizar la estructura del árbol.

## Funcionamiento General

### Inserción:

Cuando se inserta un nuevo nodo (`insertar`), primero se inserta como en un árbol de búsqueda binaria estándar (`insertarBST`). Luego, se corrigen las violaciones de las propiedades del árbol rojo-negro (`corregirViolacion`), utilizando rotaciones y ajustes de colores según sea necesario.

### Recorridos:

Los métodos `enOrden`, `preOrden` y `postOrden` permiten recorrer el árbol en diferentes órdenes, mostrando los valores de los nodos.

### Visualización Horizontal:

`RecorridoHorizontal` imprime el árbol con nodos dispuestos horizontalmente, lo cual es útil para verificar visualmente la estructura del árbol.

## Uso en `main` y Salida

En el método `main`, se crea un objeto `ArbolRojoNegro`, se insertan varios números y luego se imprimen los recorridos (`enOrden`, `preOrden`, `postOrden`) y una visualización horizontal del árbol.

## Propósito del Código

Este código está diseñado para demostrar la implementación básica de un árbol rojo-negro y cómo se pueden realizar operaciones sobre él. Es importante entender los conceptos de árbol rojo-negro para comprender cómo se mantienen sus propiedades de balance después de cada operación de inserción.
