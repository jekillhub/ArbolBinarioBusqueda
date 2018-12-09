package ArbolBinario;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinarioBusqueda<E extends Comparable<? super E>> {

    public NodoBinario<E> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    /**
     * Agrega un nuevo nodo al arbol binario de busqueda.
     *
     * @param dato Dato genérico a guardar dentro de un nodo.
     * @return boolean que indica si se pudo añadir el nodo.
     */
    public boolean agregarNodo(E dato) {

        NodoBinario<E> nodo = new NodoBinario<E>(dato, null, null, null);

        if (this.raiz == null) {
            this.raiz = nodo;
            return true;
        } else {
            NodoBinario<E> auxiliar = this.raiz;
            NodoBinario<E> padre = new NodoBinario<E>(null, null, null, null);
            NaturalComparator comparadorNodo = new NaturalComparator();

            while (true) {
                padre = auxiliar;

                if (comparadorNodo.compare(nodo.dato, auxiliar.dato) > 0) {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nodo;
                        return true;
                    }
                } else {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nodo;
                        return true;
                    }
                }
            }
        }
    }

    /**
     * Busca un dato dentro del árbol de busqueda binaria.
     *
     * @param dato Dato génerico a buscar.
     * @return boolean que indica si se encontró o no el nodo.
     */
    public boolean buscarNodo(E dato) throws NullPointerException {

        if (this.raiz == null) {
            return false;
        } else {
            NodoBinario<E> auxiliar = this.raiz;
            NodoBinario<E> padre = new NodoBinario<E>(null, null, null, null);
            NaturalComparator comparadorNodo = new NaturalComparator();

            while (auxiliar != null) {
                padre = auxiliar;
                try {
                    if (comparadorNodo.compare(dato, auxiliar.dato) > 0) {
                        auxiliar = auxiliar.der;
                        if (auxiliar.dato == dato) {
                            return true;
                        }
                    } else {
                        auxiliar = auxiliar.izq;
                        if (auxiliar.dato == dato) {
                            return true;
                        }
                    }
                } catch (NullPointerException n) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Elimina un dato del árbol binario de busqueda y reestructura el árbol.
     *
     * @param dato Dato génerico que se desea eliminar.
     * @return boolean que indica si fue o no eliminado el dato.
     * */
    public boolean eliminarNodo(E dato) {

        NodoBinario<E> auxiliar = this.raiz;
        NodoBinario<E> padre = this.raiz;
        boolean esHijoIzq = true;
        NaturalComparator comparadorNodo = new NaturalComparator();

        while (auxiliar.dato != dato) {
            padre = auxiliar;

            if (comparadorNodo.compare(dato, auxiliar.dato) < 0) {
                esHijoIzq = true;
                auxiliar = auxiliar.izq;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.der;
            }

            if (auxiliar == null) {
                return false;
            }
        }

        if (auxiliar.izq == null && auxiliar.der == null) {

            if (auxiliar == this.raiz) {
                this.raiz = null;
            } else if (esHijoIzq) {
                padre.izq = null;
            } else {
                padre.der = null;
            }
        } else if (auxiliar.der == null) {

            if (auxiliar == this.raiz) {
                this.raiz = auxiliar.izq;
            } else if (esHijoIzq) {
                padre.izq = auxiliar.izq;
            } else {
                padre.der = auxiliar.izq;
            }
        } else if (auxiliar.izq == null) {

            if (auxiliar == this.raiz) {
                this.raiz = auxiliar.der;
            } else if (esHijoIzq) {
                padre.izq = auxiliar.der;
            } else {
                padre.der = auxiliar.izq;
            }
        } else {

            NodoBinario<E> reemplazo = obtenerNodoReemplazo(auxiliar);

            if (auxiliar == this.raiz) {
                this.raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }

            reemplazo.izq = auxiliar.izq;
        }
        return true;
    }

    /**
     * Busca en el árbol binario de busqueda al nodo que reemplazará al nodo eliminado.
     *
     * @param nodoAReemplazar nodo a reemplazar.
     * @return NodoBinario<E> que será el reemplazo al nodo eliminado.
     * */
    public NodoBinario<E> obtenerNodoReemplazo(NodoBinario<E> nodoAReemplazar) {

        NodoBinario<E> reemplazarPadre = nodoAReemplazar;
        NodoBinario<E> reemplazo = nodoAReemplazar;
        NodoBinario<E> auxiliar = nodoAReemplazar.der;

        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.izq;
        }

        if (reemplazo != nodoAReemplazar.der) {
            reemplazarPadre.izq = reemplazo.der;
            reemplazo.der = nodoAReemplazar.der;
        }

        //System.out.println("El nodo reemplazo es: " + reemplazo);

        return reemplazo;
    }


    /**
     * Recorre el arbol binario de la sgte. manera:
     * 1. Hijo Izquierdo de Nodo
     * 2. Nodo
     * 3. Hijo Derecho de Nodo
     *
     * @param nodoBinario NodoBinario genérico.
     */
    public void inOrden(NodoBinario<E> nodoBinario) {
        if (nodoBinario != null) {
            inOrden(nodoBinario.izq);
            System.out.println(nodoBinario.dato);
            inOrden(nodoBinario.der);
        }
    }

    /**
     * Recorre el arbol binario de la sgte. manera:
     * 1. Nodo
     * 2. Hijo Izquierdo de Nodo
     * 3. Hijo Derecho de Nodo
     *
     * @param nodoBinario NodoBinario genérico.
     */
    public void preOrden(NodoBinario<E> nodoBinario) {
        if (nodoBinario != null) {
            System.out.println(nodoBinario.dato);
            preOrden(nodoBinario.izq);
            preOrden(nodoBinario.der);
        }
    }

    /**
     * Recorre el arbol binario de la sgte. manera:
     * 1. Hijo Izquierdo de Nodo
     * 2. Hijo Derecho de Nodo
     * 3. Nodo
     *
     * @param nodoBinario NodoBinario genérico.
     */
    public void postOrden(NodoBinario<E> nodoBinario) {
        if (nodoBinario != null) {
            postOrden(nodoBinario.izq);
            postOrden(nodoBinario.der);
            System.out.println(nodoBinario.dato);
        }
    }

    /**
     * Recorre el arbol binario por nivel, de izquierda a derecha.
     */
    public void levelOrden() {
        Queue<NodoBinario<E>> queue = new LinkedList<NodoBinario<E>>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            NodoBinario<E> actual = queue.remove();

            if (actual != null) {
                System.out.println(actual.dato);
                queue.add(actual.izq);
                queue.add(actual.der);
            }
        }
    }
}

class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}