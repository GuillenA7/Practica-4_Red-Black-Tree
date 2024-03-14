class Nodo {
    int dato;
    Color color;
    Nodo izquierda, derecha, padre;

    Nodo(int dato) {
        this.dato = dato;
        color = Color.ROJO;
        izquierda = derecha = padre = null;
    }
}