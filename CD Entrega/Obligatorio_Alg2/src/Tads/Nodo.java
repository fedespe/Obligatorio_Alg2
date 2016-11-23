
package Tads;

public class Nodo {
    
    private Object dato;
    private Nodo sig;
    private double clave;

    //Constructor
    public Nodo(Object o){
        this.dato=o;
        this.sig=null;
        this.clave=0;
    }

    //Dato
    public void setDato(Object o){
        this.dato=o;
    }
    public Object getDato(){
        return this.dato;
    }

    //Siguiente
    public void setSig(Nodo s){
        this.sig=s;
    }
    public Nodo getSig(){
        return this.sig;
    }

    public double getClave() {
        return clave;
    }

    public void setClave(double Clave) {
        this.clave = Clave;
    }
    
}
