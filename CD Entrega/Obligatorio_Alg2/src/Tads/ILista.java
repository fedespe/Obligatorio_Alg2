/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tads;

/**
 *
 * @author user
 */
public interface ILista {
   //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Object o);
    public void borrarInicio();
    public void agregarFinal(Object o);
    public void borrarFin();
    public void vaciar();
    public void mostrar(); 
    public Nodo buscar(Object o);
    public void borrar(Object o);
    public void agregarOrd(Object o, double n);
    public void mostrarDescendente(Nodo aux);
}
