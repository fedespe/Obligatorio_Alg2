
package Tads;


public class GrafoLista {
    int size;
    int cantNodos;
    Lista[] listaAdyacencia;
    boolean[] nodosUsados;

    //Crea el grafo vacio (sin nodos ni aristas) con capacidad de almacenamiento de n vértices
    public GrafoLista(int n) {
        this.size = 0;
        this.cantNodos = n;
        this.listaAdyacencia = new Lista[this.cantNodos+1];
        for (int i = 1; i<=this.cantNodos; i++)
            this.listaAdyacencia[i]= new Lista();		

        this.nodosUsados = new boolean[this.cantNodos+1];
    }
    
    //var que si no es dirigido hay que hacer la otra arista
    public void agregarArista(int origen, int destino, int peso) {
        AristaLista nueva=new AristaLista(destino, peso);
        this.listaAdyacencia[origen].agregarInicio(nueva);
    }

    public void agregarVertice(int v) {
        this.nodosUsados[v]=true;
        this.size ++;
    }

    public void eliminarArista(int origen, int destino) {
        AristaLista buscada=new AristaLista(destino, 0);
        this.listaAdyacencia[origen].borrar(buscada);	
    }

    public boolean esVacio() {
        return this.size==0;
    }

    public boolean sonAdyacentes(int a, int b) {
        AristaLista buscada=new AristaLista(b, 0);
        return this.listaAdyacencia[a].buscar(buscada)!=null;
    }
    
    public void eliminarVertice(int v) {
        this.nodosUsados[v]=false;
        this.size --;

        //Elimino las aristas donde v es miembro
        this.listaAdyacencia[v] = new Lista();	
        //BUSCAR EN TODOS LOS VERTICES LA ARISTA
        AristaLista aristaV=new AristaLista(v, 0);
        for (int i = 1; i<=cantNodos; i++){
            this.listaAdyacencia[i].borrar(aristaV);
        }
                	
    }

    public Lista verticesAdyacentes(int v) {
        return this.listaAdyacencia[v];
    }

    public boolean estaVertice(int v) {
        return this.nodosUsados[v];
    }



}
