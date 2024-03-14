enum Color {
    ROJO, NEGRO
}

public class ArbolRojoNegro {
    private Nodo raiz;

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        raiz = insertarBST(raiz, nuevoNodo);
        corregirViolacion(nuevoNodo);
    }

    private Nodo insertarBST(Nodo raiz, Nodo nuevoNodo) {
        if (raiz == null)
            return nuevoNodo;
        if (nuevoNodo.dato < raiz.dato) {
            raiz.izquierda = insertarBST(raiz.izquierda, nuevoNodo);
            raiz.izquierda.padre = raiz;
        } else if (nuevoNodo.dato > raiz.dato) {
            raiz.derecha = insertarBST(raiz.derecha, nuevoNodo);
            raiz.derecha.padre = raiz;
        }
        return raiz;
    }

    private void corregirViolacion(Nodo z) {
        Nodo padreZ = null;
        Nodo abueloZ = null;
        while (z != raiz && z.color == Color.ROJO && z.padre.color == Color.ROJO) {
            padreZ = z.padre;
            abueloZ = z.padre.padre;
            if (padreZ == abueloZ.izquierda) {
                Nodo tioZ = abueloZ.derecha;
                if (tioZ != null && tioZ.color == Color.ROJO) {
                    abueloZ.color = Color.ROJO;
                    padreZ.color = Color.NEGRO;
                    tioZ.color = Color.NEGRO;
                    z = abueloZ;
                } else {
                    if (z == padreZ.derecha) {
                        rotarIzquierda(padreZ);
                        z = padreZ;
                        padreZ = z.padre;
                    }
                    rotarDerecha(abueloZ);
                    Color temp = padreZ.color;
                    padreZ.color = abueloZ.color;
                    abueloZ.color = temp;
                    z = padreZ;
                }
            } else {
                Nodo tioZ = abueloZ.izquierda;
                if (tioZ != null && tioZ.color == Color.ROJO) {
                    abueloZ.color = Color.ROJO;
                    padreZ.color = Color.NEGRO;
                    tioZ.color = Color.NEGRO;
                    z = abueloZ;
                } else {
                    if (z == padreZ.izquierda) {
                        rotarDerecha(padreZ);
                        z = padreZ;
                        padreZ = z.padre;
                    }
                    rotarIzquierda(abueloZ);
                    Color temp = padreZ.color;
                    padreZ.color = abueloZ.color;
                    abueloZ.color = temp;
                    z = padreZ;
                }
            }
        }
        raiz.color = Color.NEGRO;
    }

    private void rotarIzquierda(Nodo x) {
        Nodo y = x.derecha;
        x.derecha = y.izquierda;
        if (y.izquierda != null)
            y.izquierda.padre = x;
        y.padre = x.padre;
        if (x.padre == null)
            raiz = y;
        else if (x == x.padre.izquierda)
            x.padre.izquierda = y;
        else
            x.padre.derecha = y;
        y.izquierda = x;
        x.padre = y;
    }

    private void rotarDerecha(Nodo x) {
        Nodo y = x.izquierda;
        x.izquierda = y.derecha;
        if (y.derecha != null)
            y.derecha.padre = x;
        y.padre = x.padre;
        if (x.padre == null)
            raiz = y;
        else if (x == x.padre.derecha)
            x.padre.derecha = y;
        else
            x.padre.izquierda = y;
        y.derecha = x;
        x.padre = y;
    }

    public static void main(String[] args) {
        ArbolRojoNegro arbolRN = new ArbolRojoNegro();
        arbolRN.insertar(3);
        arbolRN.insertar(89);
        arbolRN.insertar(5);
        arbolRN.insertar(1);
        arbolRN.insertar(8);
        arbolRN.insertar(7);
        arbolRN.insertar(12);
        arbolRN.insertar(51);
        arbolRN.insertar(2);
        arbolRN.insertar(9);

        System.out.println("Recorrido en orden:");
        Recorrido.enOrden(arbolRN.raiz);
        System.out.println();

        System.out.println("Recorrido preorden:");
        Recorrido.preOrden(arbolRN.raiz);
        System.out.println();

        System.out.println("Recorrido postorden:");
        Recorrido.postOrden(arbolRN.raiz);
        System.out.println();

		System.out.print("\n\nArbol balanceado (horizontal):");
		Recorrido.RecorridoHorizontal(arbolRN.raiz, 0);
        System.out.println();
    }
}
