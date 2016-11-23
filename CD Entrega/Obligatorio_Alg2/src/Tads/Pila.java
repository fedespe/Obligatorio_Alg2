
package Tads;

public class Pila implements IPila{

    private Nodo tope;
    private int cantelementos=0;
    private int maximacantelementos;
     
    //***************************************************
    //MANEJO DE LA PILA
    //***************************************************
    
    public Pila(int maximacantelementos) {
        this.tope = null;
        this.maximacantelementos = maximacantelementos;
    }

    public Nodo getTope() {
        return this.tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }

    public int getCantelementos() {
        return this.cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    public int getMaximacantelementos() {
        return this.maximacantelementos;
    }

    public void setMaximacantelementos(int maximacantelementos) {
        this.maximacantelementos = maximacantelementos;
    }
    
    //***************************************************
    //METODOS BASICOS
    //***************************************************
    
    //Pre.: 
    //Post.: Inserta el elemento pasado como argumento en el stack.
    @Override
    public void push(Object dato) {
        Nodo nuevo= new Nodo(dato);
        if (!this.isFull()){
            nuevo.setSig(tope);
            this.tope=nuevo;  
            this.cantelementos ++;
        }
    }

    //Pre.: 
    //Post.: Elimina el elemento ubicado en el tope del stack. 
    //El ultimo elemento ingresado
    @Override
    public void pop() {
        if(!this.isEmpty()){
            Nodo aux=this.tope;
            tope=tope.getSig();
            aux.setSig(null);
            this.cantelementos --;
        }        
    }
    
    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        if(!isEmpty()){
            while(!isEmpty()){
                this.pop();
            }
        }
    }

    //Post.: Retorna true si y solo si el stack es vacío.
    @Override
    public boolean isEmpty() {
        return (this.tope==null); 
    }

    //Post.: Retorna true si y solo si el stack esta lleno.
    @Override
    public boolean isFull() {
        return ((this.cantelementos==this.maximacantelementos));
    }
    //Post.: Retorna la cantidad de elementos que tienen el stack.
    @Override
    public int tamanio() {
        return this.getCantelementos();
    }

    //Pre.: El stack no es vacío.
    //Post.: Retorna el elemento ubicado en el tope del stack
    @Override
    public Object tope() {
        return tope.getDato();
    }
    
    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        if (this.isEmpty())
            System.out.println("Pila es vacia");
        else  {
            Nodo aux=this.tope;
            while (aux!=null)  {
                //ver si esta bien usar el toString() 
                //del objeto para mostrar.
                System.out.println(aux.getDato().toString());
                aux=aux.getSig();
            }
        }
    }
    
}
