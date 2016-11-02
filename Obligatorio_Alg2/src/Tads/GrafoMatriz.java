
package Tads;


public class GrafoMatriz implements IGrafo{
    int size;
    int cantNodos;
    AristaMatriz[][] matrizAdyacencia;
    boolean[] nodosUsados;

    //Crea el grafo vacio (sin nodos ni aristas) con capacidad de almacenamiento de n vértices
    public GrafoMatriz(int cantNodos) {
        this.size = 0;
        this.cantNodos = cantNodos;

        this.matrizAdyacencia = new AristaMatriz[cantNodos+1][cantNodos+1];
        for (int i = 1; i<=cantNodos; i++)
            for (int j = 1; j<=cantNodos; j++)
                this.matrizAdyacencia[i][j]= new AristaMatriz();
        
        this.nodosUsados = new boolean[cantNodos+1];
    }
    
    //Ver que si el grafo no es dirigido hay que 
    //agregar la otra arista
    public void agregarArista(int origen, int destino, int peso) {
        AristaMatriz nuevo = new AristaMatriz(peso);
        this.matrizAdyacencia[origen][destino] = nuevo;
    }

    public void agregarVertice(int v) {
        this.nodosUsados[v]=true;
        this.size ++;
    }

    public void eliminarArista(int origen, int destino) {
        AristaMatriz nuevo = new AristaMatriz();
        this.matrizAdyacencia[origen][destino] = nuevo;		
    }
    
    public void eliminarVertice(int v) {
        this.nodosUsados[v]=false;
        this.size --;

        //Elimino las aristas donde v es miembro
        for(int i=1;i<=this.cantNodos;i++){
            this.matrizAdyacencia[i][v] = new AristaMatriz();
            this.matrizAdyacencia[v][i] = new AristaMatriz();
        }
    }

    public boolean esVacio() {
        return this.size==0;
    }

    public boolean sonAdyacentes(int a, int b) {
        return this.matrizAdyacencia[a][b].existe;
    }
    
    public Lista verticesAdyacentes(int v) {
        Lista l = new Lista();
        for(int i=1; i<=this.cantNodos; i++){
            if(this.sonAdyacentes(v, i)){
                l.agregarInicio(i);
            }
        }
        return l;
    }

    public boolean estaVertice(int v) {
            return this.nodosUsados[v];
    }




}
