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
    public void add(String clave, Object dato);
    public boolean isEmpty();
    public boolean isHoja();
    public boolean isEquilibrado();
    public boolean existe(String clave);
    public NodoArbol buscar(String clave);
    public int nivel(String clave);
    public int altura();
    public int peso();
    public int cantidadNodos();
    public void inOrden();
    public void eliminar(String a);
    public void vaciar();
}
