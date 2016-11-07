
package Tads;


public class GrafoLista {
    int size;
    int cantNodosUtilizados;
    Lista[] listaAdyacencia;
    boolean[] nodosUsados;
    //agregado para guardar la informacion de los nodos
    Object[] datosNodosUsados;

    public Object[] getDatosNodosUsados() {
		return datosNodosUsados;
	}

	public void setDatosNodosUsados(Object[] datosNodosUsados) {
		this.datosNodosUsados = datosNodosUsados;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCantNodosUtilizados() {
		return cantNodosUtilizados;
	}

	public void setCantNodosUtilizados(int cantNodosUtilizados) {
		this.cantNodosUtilizados = cantNodosUtilizados;
	}

	public Lista[] getListaAdyacencia() {
		return listaAdyacencia;
	}

	public void setListaAdyacencia(Lista[] listaAdyacencia) {
		this.listaAdyacencia = listaAdyacencia;
	}

	public boolean[] getNodosUsados() {
		return nodosUsados;
	}

	public void setNodosUsados(boolean[] nodosUsados) {
		this.nodosUsados = nodosUsados;
	}

	//Crea el grafo vacio (sin nodos ni aristas) con capacidad de almacenamiento de n v�rtices
    public GrafoLista(int n) {
        this.size = n;
        this.cantNodosUtilizados = 0;
        this.listaAdyacencia = new Lista[this.size+1];
        for (int i = 0; i<this.size; i++)
            this.listaAdyacencia[i]= new Lista();		

        this.nodosUsados = new boolean[this.size+1];
        this.datosNodosUsados = new Object[this.size+1];
    }
    
    public void agregarVertice(int v, Object o) {
        this.nodosUsados[v]=true;
        this.datosNodosUsados[v]=o;
        this.cantNodosUtilizados ++;
    }
    
    //ver que si no es dirigido hay que hacer la otra arista
    public void agregarArista(int origen, int destino, int peso) {
        AristaLista nueva=new AristaLista(destino, peso);
        this.listaAdyacencia[origen].agregarInicio(nueva);
        
        AristaLista nueva2=new AristaLista(origen, peso);
        this.listaAdyacencia[destino].agregarInicio(nueva2);
    }

    public void eliminarArista(int origen, int destino) {
        AristaLista buscada=new AristaLista(destino, 0);
        this.listaAdyacencia[origen].borrar(buscada);
        
        AristaLista buscada2=new AristaLista(origen, 0);
        this.listaAdyacencia[destino].borrar(buscada2);
    }

    public boolean estaVacio() {
        return this.cantNodosUtilizados==0;
    }

    public boolean sonAdyacentes(int a, int b) {
        AristaLista buscada=new AristaLista(b, 0);
        return this.listaAdyacencia[a].buscar(buscada)!=null;
    }
    
    public void eliminarVertice(int v) {
        this.nodosUsados[v]=false;
        this.cantNodosUtilizados --;

        //Elimino las aristas donde v es miembro
        this.listaAdyacencia[v] = new Lista();	
        //BUSCAR EN TODOS LOS VERTICES LA ARISTA
        AristaLista aristaV=new AristaLista(v, 0);
        for (int i = 0; i<size; i++){
            this.listaAdyacencia[i].borrar(aristaV);
        }
                	
    }

    public Lista verticesAdyacentes(int v) {
        return this.listaAdyacencia[v];
    }

    public boolean estaVertice(int v) {
        return this.nodosUsados[v];
    }

	public boolean hayLugar() {
		return cantNodosUtilizados < size;
	}



}
