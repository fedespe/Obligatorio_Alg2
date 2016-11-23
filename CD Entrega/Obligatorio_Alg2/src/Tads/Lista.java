
package Tads;

public class Lista implements ILista{
    
    private Nodo inicio;
    private Nodo fin;
    private int cantidadNodos;

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }
    
    //***************************************************
    //MANEJO DE LA LISTA
    //***************************************************
    
    //Constructor
    public void Lista(){
        this.inicio=null;
        this.fin=null;
        this.cantidadNodos=0;
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
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public void agregarInicio(Object o) {
        Nodo nuevo= new Nodo(o);
        nuevo.setSig(this.inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        this.cantidadNodos++;
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
                this.inicio=this.inicio.getSig();
                this.cantidadNodos--;
            }
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(Object o) {
        if (this.esVacia())
            this.agregarInicio(o);
        else
        {
            Nodo aux=this.inicio;
            while (aux.getSig() != null)
                aux=aux.getSig();
            Nodo nuevo= new Nodo(o);
            aux.setSig(nuevo);
            this.fin=nuevo;
        }
        this.cantidadNodos++;
    }

    //PRE:
    //POS: Borra el último nodo
    @Override
    public void borrarFin() {
        if (!this.esVacia()){
            if (this.inicio==this.fin)
                this.borrarInicio();
            else{
                Nodo aux = this.inicio;
                while (aux.getSig().getSig() != null)
                    aux=aux.getSig();
                this.fin=aux;
                this.fin.setSig(null);
            }
            this.cantidadNodos--;
        }
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        //en java alcanza con apuntar inicio y fin a null
        this.inicio=this.fin=null;
        this.cantidadNodos=0;
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        if (this.esVacia())
            System.out.println("Lista es vacia");
        else  {
            Nodo aux=this.inicio;
            while (aux!=null)  {
                //ver si esta bien usar el toString() 
                //del objeto para mostrar.
                System.out.println(aux.getDato().toString());
                aux=aux.getSig();
            }
        }
    }
    //PRE:
    //POS: Muestra de forma recursiva
    @Override
    public void mostrarDescendente(Nodo aux) {
        if(!this.esVacia()){
            if(aux.getSig()==null)
                System.out.println(aux.getDato().toString());
            else{
                mostrarDescendente(aux.getSig());
                System.out.println(aux.getDato().toString());
            }
        }else
            System.out.println("Lista es vacia");
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
            this.borrarInicio();
            this.cantidadNodos--;
        }
        while (aux!=null && !aux.getDato().equals(o)){
            if(aux.getSig()!=null && aux.getSig().getDato().equals(o)){
                if(aux.getSig().getSig()!=null){
                    aux.setSig(aux.getSig().getSig());
                }else{
                    aux.setSig(null);
                    this.fin=aux;
                }
                    
                this.cantidadNodos--;
            }
            aux=aux.getSig();           
        }
    }
    
    //PRE: lista ordenada => mantiene orden
    //POS: inserta nuevo elemento en orden ascendente
    //se le agrega una clave como referencia para el orden
    @Override
    public void agregarOrd(Object o, double n){
        //lista vacìa o primer elemento es mayor o igual => agrego al ppio
        if (this.esVacia() || this.inicio.getClave()>=n){
            this.agregarInicio(o);
            this.inicio.setClave(n);
            this.cantidadNodos++;
            return;
        }
        if (this.fin.getClave()<=n){   //ùltimo elemento es menor o igual => agrego al final
            this.agregarFinal(o);
            this.fin.setClave(n);
            this.cantidadNodos++;
            return;
        }
        Nodo aux=this.inicio;
        while (aux.getSig()!=null && aux.getSig().getClave() < n)
            aux=aux.getSig();
        Nodo nuevo=new Nodo(o);
        nuevo.setClave(n);
        nuevo.setSig(aux.getSig());
        aux.setSig(nuevo);
        this.cantidadNodos++;
    }

}
