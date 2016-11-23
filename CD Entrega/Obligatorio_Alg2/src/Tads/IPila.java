
package Tads;


public interface IPila {
   public void push(Object dato);  // agregar 
   public void pop() ;  // sacar
   public boolean isEmpty();
   public boolean isFull();
   public int tamanio() ;  // cantidad de elementos
   public Object tope();   //Mostrar el tope
   public void mostrar();
   public void vaciar();
}
