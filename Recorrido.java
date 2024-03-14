class Recorrido {
    public static void enOrden(Nodo nodo) {
        if (nodo != null) {
            enOrden(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            enOrden(nodo.derecha);
        }
    }

    public static void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }

    public static void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierda);
            postOrden(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }

    public static void RecorridoHorizontal(Nodo nodo, int espacios){
        if(nodo == null)
            return;

        espacios += 10;

        RecorridoHorizontal(nodo.derecha, espacios);

        System.out.print("\n");
        for (int i = 10; i < espacios; i++)
            System.out.print(" ");
        System.out.print(nodo.dato);

        RecorridoHorizontal(nodo.izquierda, espacios);
    }
}