package Clases;

import Tads.GrafoLista;
import Tads.Lista;

public class GrafoCoordenada {
	private GrafoLista grafo;

	public GrafoCoordenada(int cantidadNodos) {
		super();
		this.grafo = new GrafoLista(cantidadNodos);
	}

	public void agregarArista(Ubicable origen, Ubicable destino, int peso) throws ObligatorioException {
		int verticeOrigen,verticeDestino;
		//Ver si esta bien que la cantidad de iteraciones 
		//del for es grafo.getSize
		for(int i=0;i<grafo.getSize();i++){
			verticeOrigen=hash(origen.getCoordX(),origen.getCoordY(),i);
			//falta vertice destino, pero para todo esto tengo que tener un metodo que sea 
			//buscar coordenadas en grafo y que me devuelva la posicion en el grafo
			if(grafo.getDatosNodosUsados()[verticeOrigen].equals(origen)){
				for(int j=0;j<grafo.getSize();j++){
					verticeDestino=hash(destino.getCoordX(),destino.getCoordY(),j);
					if(grafo.getDatosNodosUsados()[verticeDestino].equals(destino)){
						grafo.agregarArista(verticeOrigen, verticeDestino, peso);//Tira una exception si ya existe la arista
						return;
					}
				}	
			}
		}
		throw new ObligatorioException("No existe coordenada inicial o final");
	}
	
	public boolean agregarVertice(Ubicable v) {
		int vertice;
		if(grafo.getSize()!=grafo.getCantNodosUtilizados()){//Si queda lugar
			for(int i=0;i<grafo.getSize();i++){
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
	
	public void eliminarArista(Ubicable origen, Ubicable destino) throws ObligatorioException {
		int verticeOrigen,verticeDestino;
		//Ver si esta bien que la cantidad de iteraciones 
		//del for es grafo.getSize
		for(int i=0;i<grafo.getSize();i++){
			verticeOrigen=hash(origen.getCoordX(),origen.getCoordY(),i);
			//falta vertice destino, pero para todo esto tengo que tener un metodo que sea 
			//buscar coordenadas en grafo y que me devuelva la posicion en el grafo
			if(grafo.getDatosNodosUsados()[verticeOrigen].equals(origen)){
				for(int j=0;j<grafo.getSize();j++){
					verticeDestino=hash(destino.getCoordX(),destino.getCoordY(),j);
					if(grafo.getDatosNodosUsados()[verticeDestino].equals(destino)){
						grafo.eliminarArista(verticeOrigen, verticeDestino);//Tira una exception si ya existe la arista
						return;
					}
				}	
			}
		}
		throw new ObligatorioException("No existe coordenada inicial o final");
	}
	
	public boolean esVacio() {
		return grafo.estaVacio();
	}
	
	public boolean sonAdyacentes(Ubicable a, Ubicable b) {
		//hash
		return true;
	}
	
	public void eliminarVertice(Ubicable v) throws ObligatorioException {
		int vertice;
		for(int i=0;i<grafo.getSize();i++){
			vertice=hash(v.getCoordX(),v.getCoordY(),i);
			if(grafo.getDatosNodosUsados()[vertice]!=null && grafo.getDatosNodosUsados()[vertice].equals(v)){
				grafo.eliminarVertice(vertice);
				return;
			}
		}
		throw new ObligatorioException("No existe coordenada");
	}
	
	public Lista verticesAdyacentes(Ubicable v) {
		//hash
		return new Lista();
	}
	
	public boolean estaVertice(Ubicable v) { //Debe retorar true si hay un vértice con esas coordenadas
		//hash
		return false;
	}
	
	public boolean hayLugar() {
		return grafo.hayLugar();
	}
	
	private int hash(double x, double y, int i){
		int retorno= (int)(x+(2*y))+i;
		return retorno%grafo.getSize();
	}

	public boolean coordenadasOcupadas(Double coordX, Double coordY) {
		int vertice;
		for(int i=0;i<grafo.getSize();i++){
			vertice = hash(coordX,coordY,i);
			if(grafo.getDatosNodosUsados()[vertice]!=null){
				Ubicable u = (Ubicable)grafo.getDatosNodosUsados()[vertice];
				if(u.getCoordX() == coordX && u.getCoordY() == coordY)
					return true;
			}
		}
		return false;
	}	
}
