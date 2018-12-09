package Main;

import ArbolBinario.ArbolBinarioBusqueda;

public class Main {

    public static void main(String[] args) {
        ArbolBinarioBusqueda<String> arbol = new ArbolBinarioBusqueda<String>();
        arbol.agregarNodo("D");
        arbol.agregarNodo("B");
        arbol.agregarNodo("F");
        arbol.agregarNodo("A");
        arbol.agregarNodo("C");
        arbol.agregarNodo("H");
        arbol.agregarNodo("A");
        arbol.agregarNodo("B");
        arbol.agregarNodo("G");
        arbol.agregarNodo("I");

        arbol.levelOrden();
        System.out.println("");
        System.out.println(arbol.eliminarNodo("D"));
        System.out.println("");
        arbol.levelOrden();


        /*
        System.out.println("PreOrden:" +"\n");
        arbolBinario.preOrden(arbolBinario.raiz);
        System.out.println("");
        System.out.println("PostOrden:"+"\n");
        arbolBinario.postOrden(arbolBinario.raiz);
        System.out.println("");
        System.out.println("InOrden:"+"\n");
        arbolBinario.inOrden(arbolBinario.raiz);
        System.out.println("");
        System.out.println("LevelOrden:"+"\n");
        arbolBinario.levelOrden();
        */
    }

}