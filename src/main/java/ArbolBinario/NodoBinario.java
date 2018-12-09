package ArbolBinario;

public class NodoBinario<E> {

    public E dato;
    public NodoBinario<E> padre;
    public NodoBinario<E> izq;
    public NodoBinario<E> der;

    public NodoBinario(E dato, NodoBinario<E> padre, NodoBinario<E> izq, NodoBinario<E> der) {
        this.dato = dato;
        this.padre = padre;
        this.izq = izq;
        this.der = der;
    }

    /**
     * Añadir hijo izquierdo al nodo binario.
     * @param dato Dato genérico, a guardar en el nodo hijo izquierdo.
     * */
    public NodoBinario<E> anadirHijoIzq(E dato){
        this.izq = new NodoBinario<E>(dato,this,null,null);
        return this.izq;
    }

    /**
     * Añadir hijo derecho al nodo binario.
     * @param dato Dato genérico, a guardar en el nodo hijo derecho.
     * */
    public NodoBinario<E> anadirHijoDer(E dato){
        this.der = new NodoBinario<E>(dato,this,null,null);
        return this.der;
    }

    @Override
    public String toString() throws NullPointerException {
        try{
            return "Dato: " + dato;
        }catch (NullPointerException n){
            return "Dato: Null";
        }
    }
}
