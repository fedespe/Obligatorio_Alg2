
package Tads;

public class Cola implements ICola{
    private Nodo inicio;
    private Nodo fin;
    private int cantelementos=0;

    
    
    //***************************************************
    //MANEJO DE LA LISTA
    //***************************************************
    
    //Constructor
    public void Cola(){
        this.inicio=null;
        this.fin=null;
    }
    
    //Inicio
    public void setInicio(Nodo i){
        inicio=i;
    }
    public Nodo getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(Nodo f){
        fin=f;
    }
    public Nodo getFin(){
        return fin;
    }
    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    public int getCantelementos() {
        return cantelementos;
    }
    //***************************************************
    //METODOS BASICOS
    //***************************************************
    
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        return this.inicio==null;      
    }
    
    //PRE:
    //POS: Borra el primer nodo
    @Override
    public void pop() {
        if (!this.esVacia()){
                this.inicio=this.inicio.getSig();
                this.cantelementos--;
            }
    }
    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    private void agregarInicio(Object o) {
        Nodo nuevo= new Nodo(o);
        nuevo.setSig(this.inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void push(Object o) {
        if (this.esVacia())
        {
            this.agregarInicio(o);
            this.cantelementos++;
        }
        else
        {
            Nodo aux=this.inicio;
            while (aux.getSig() != null)
                aux=aux.getSig();
            Nodo nuevo= new Nodo(o);
            aux.setSig(nuevo);
            this.fin=nuevo;
            this.cantelementos++;
        }
    }
    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        if (this.esVacia())
            System.out.println("Cola es vacia");
        else  {
            Nodo aux=this.inicio;
            int i=1;
            while (aux!=null)  {
                //ver si esta bien usar el toString() 
                //del objeto para mostrar.
                System.out.println(i+" - "+aux.getDato().toString());
                i++;
                aux=aux.getSig();
            }
        }
    }
    //Post.: Retorna la cantidad de elementos que tienen el stack.
    @Override
    public int tamanio() {
        return this.getCantelementos();
    }
    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        //en java alcanza con apuntar inicio y fin a null
        this.inicio=this.fin=null;
    }
    
    //PRE: //POS:
    @Override
    public Nodo buscar(Object o){
        Nodo aux=this.inicio;
        while (aux!=null && !aux.getDato().equals(o))//ver tema equals
            aux=aux.getSig();
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }
    //PRE: //POS:
    @Override
    public void borrar(Object o){
        Nodo aux=this.inicio;
        if(aux.getDato().equals(o)){
            this.pop();
        }
        while (aux!=null && !aux.getDato().equals(o)){
            if(aux.getSig()!=null && aux.getSig().getDato().equals(o)){
                if(aux.getSig().getSig()!=null){
                    aux.setSig(aux.getSig().getSig());
                    aux.getSig().setSig(null);
                }else
                    aux.setSig(null);
            }
            aux=aux.getSig();           
        }
    }
}
