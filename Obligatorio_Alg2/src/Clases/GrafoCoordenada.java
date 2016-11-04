package Clases;

import Tads.GrafoLista;
import Tads.Lista;

public class GrafoCoordenada {
	private GrafoLista grafo;

	public GrafoCoordenada(int cantidadNodos) {
		super();
		this.grafo = new GrafoLista(cantidadNodos);
	}
	
	public boolean agregarArista(Ubicable origen, Ubicable destino, int peso) {
		int verticeOrigen,verticeDestino;
		//Ver si esta bien que la cantidad de iteraciones 
		//del for es grafo.getcantnodos
		for(int i=0;i<=grafo.getCantNodos();i++){
			verticeOrigen=hash(origen.getCoordX(),origen.getCoordY(),i);
			//falta vertice destino, pero para todo esto tengo que tener un metodo que sea 
			//buscar coordenadas en grafo y que me devuelva la posicion en el grafo
			if(grafo.getDatosNodosUsados()[verticeOrigen].equals(origen)){
				for(int j=0;j<=grafo.getCantNodos();i++){
					verticeDestino=hash(destino.getCoordX(),destino.getCoordY(),j);
					if(grafo.getDatosNodosUsados()[verticeDestino].equals(destino)){
						grafo.agregarArista(verticeOrigen, verticeDestino, peso);	
						return true;
					}
				}	
			}
		}
		return false;
	}
	public boolean agregarVertice(Ubicable v) {
		int vertice;
		if(grafo.getSize()!=grafo.getCantNodos()){
			for(int i=0;i<=grafo.getCantNodos();i++){
				vertice=hash(v.getCoordX(),v.getCoordY(),i);
				if(grafo.getDatosNodosUsados()[vertice]==null){
					grafo.agregarVertice(vertice, v);	
					return true;
				}else if(grafo.getDatosNodosUsados()[vertice].equals(v)){
					return false;//Si ya existe se puede manejar con una exception
				}
			}
		}
		return false;
			
	}
	public boolean eliminarArista(Ubicable origen, Ubicable destino) {
		int verticeOrigen,verticeDestino;
		for(int i=0;i<=grafo.getCantNodos();i++){
			verticeOrigen=hash(origen.getCoordX(),origen.getCoordY(),i);
			//falta vertice destino, pero para todo esto tengo que tener un metodo que sea 
			//buscar coordenadas en grafo y que me devuelva la posicion en el grafo
			if(grafo.getDatosNodosUsados()[verticeOrigen].equals(origen)){
				for(int j=0;j<=grafo.getCantNodos();i++){
					verticeDestino=hash(destino.getCoordX(),destino.getCoordY(),j);
					if(grafo.getDatosNodosUsados()[verticeDestino].equals(destino)){
						grafo.eliminarArista(verticeOrigen, verticeDestino);	
						return true;
					}
				}	
			}
		}
		return false;
	}
	public boolean esVacio() {
		return grafo.esVacio();
	}
	public boolean sonAdyacentes(Ubicable a, Ubicable b) {
		//hash
		return true;
	}
	public void eliminarVertice(Ubicable v) {
		//hash
	}
	public Lista verticesAdyacentes(Ubicable v) {
		//hash
		return new Lista();
	}
	public boolean estaVertice(Ubicable v) {
		//hash
		return true;
	}
	
	private int hash(double x, double y, int i){
		int retorno= (int)(x+(2*y))+i;
		return retorno%grafo.getSize();
	}
	
}
