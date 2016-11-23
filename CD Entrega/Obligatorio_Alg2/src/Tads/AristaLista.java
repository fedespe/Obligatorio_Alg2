
package Tads;

public class AristaLista {
    private int verticeAdyacente;
    private int peso;

    public int getVerticeAdyacente() {
        return verticeAdyacente;
    }

    public void setVerticeAdyacente(int verticeAdyacente) {
        this.verticeAdyacente = verticeAdyacente;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public AristaLista(int verticeAdyacente, int peso) {
        this.verticeAdyacente = verticeAdyacente;
        this.peso = peso;
    }

    @Override
    public boolean equals(Object obj) {
        AristaLista o=(AristaLista)obj;
        if(this.verticeAdyacente==o.getVerticeAdyacente())
            return true;
        return false;
    }
    
    
    
}
