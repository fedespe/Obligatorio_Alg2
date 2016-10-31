
package Tads;

public interface ICola {
   public void push(Object dato);  // agregar 
   public void pop() ;  // sacar
   public boolean esVacia();
   public int tamanio() ;  // cantidad de elementos
   public void mostrar();
   public void vaciar();
   public Nodo buscar(Object o);
   public void borrar(Object o);
}
