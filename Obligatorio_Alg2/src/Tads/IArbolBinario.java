/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tads;

/**
 *
 * @author alumnoFI
 */
public interface IArbolBinario {
    public void add(int clave, Object dato);
    public boolean isEmpty();
    public boolean isHoja();
    public boolean isEquilibrado();
    public boolean existe(int clave);
    public NodoArbol buscar(int clave);
    public int nivel(int clave);
    public int altura();
    public int peso();
    public int cantidadNodos();
    public void inOrden();
    public void eliminar(int a);
    public void vaciar();
}
