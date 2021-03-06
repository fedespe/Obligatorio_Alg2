
package Tads;

public class NodoArbol {
    
    private Object dato;
    private NodoArbol izq;
    private NodoArbol der;
    private String clave;



    public NodoArbol(String clave,Object dato) {
            this.dato = dato;
            this.izq = null;
            this.der = null;
            this.clave=clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public Object getDato() {
            return dato;
    }

    public void setDato(Object dato) {
            this.dato = dato;
    }

    public NodoArbol getIzq() {
            return izq;
    }

    public void setIzq(NodoArbol izq) {
            this.izq = izq;
    }

    public NodoArbol getDer() {
            return der;
    }

    public void setDer(NodoArbol der) {
            this.der = der;
    }
}
