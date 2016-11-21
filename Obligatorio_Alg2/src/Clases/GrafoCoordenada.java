package Clases;

import Tads.AristaLista;
import Tads.GrafoLista;
import Tads.Lista;
import Tads.Nodo;

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
			if(grafo.getDatosNodosUsados()[verticeOrigen] != null && grafo.getDatosNodosUsados()[verticeOrigen].equals(origen)){
				for(int j=0;j<grafo.getSize();j++){
					verticeDestino=hash(destino.getCoordX(),destino.getCoordY(),j);
					if(grafo.getDatosNodosUsados()[verticeDestino] != null && grafo.getDatosNodosUsados()[verticeDestino].equals(destino)){
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
			if(grafo.getDatosNodosUsados()[verticeOrigen]!= null && grafo.getDatosNodosUsados()[verticeOrigen].equals(origen)){
				for(int j=0;j<grafo.getSize();j++){
					verticeDestino=hash(destino.getCoordX(),destino.getCoordY(),j);
					if(grafo.getDatosNodosUsados()[verticeDestino] != null && grafo.getDatosNodosUsados()[verticeDestino].equals(destino)){
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
	
	public boolean estaVertice(Ubicable v) {
		//hash
		return false;
	}
	
	public boolean hayLugar() {
		return grafo.hayLugar();
	}
	
	private int hash(double x, double y, int i){
		int retorno= (int)(Math.abs(x)+(2*Math.abs(y)))+i;
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
	
	public String procesarInformacion(Ubicable v, int esfuerzoRequerido) throws ObligatorioException{
		String retorno = "";
		DataCenter dc = null;
		Empresa e = null;
		int t = grafo.getSize();
		boolean[] visitado = new boolean[t]; //Todos en false por defecto
		int [] costo = new int[t];
		int [] costoTotal = new int[t];
		
		t--;
		for(;t>=0;t--){
			costo[t] = costoTotal[t] = Integer.MAX_VALUE;
		}
		t = grafo.getSize()-1;

		int vertice;
		for(int i=0;i<grafo.getSize();i++){
			vertice=hash(v.getCoordX(),v.getCoordY(),i);
			
			if(grafo.getDatosNodosUsados()[vertice] != null && grafo.getDatosNodosUsados()[vertice].equals(v)){
				dc = (DataCenter)grafo.getDatosNodosUsados()[vertice];
				if(esfuerzoRequerido <= dc.getCapacidadCPUenHoras()){
					dc.setCapacidadCPUenHoras(dc.getCapacidadCPUenHoras()-esfuerzoRequerido);
					return dc.getNombre()+"|"+0;
				}
				else{
					visitado[vertice] = true;
					costo[vertice] = 0;
					e = dc.getEmpresa();
					
					Nodo aux = grafo.getListaAdyacencia()[vertice].getInicio();
					while(aux != null){
						AristaLista a = (AristaLista)aux.getDato();
						
						costo[a.getVerticeAdyacente()] = a.getPeso();
						
						Ubicable ubi = (Ubicable)grafo.getDatosNodosUsados()[a.getVerticeAdyacente()];
						if(ubi instanceof DataCenter){
							DataCenter dc2 = (DataCenter)ubi;
							if(dc2.getCapacidadCPUenHoras() >= esfuerzoRequerido){
								if(e.equals(dc2.getEmpresa()))
									costoTotal[a.getVerticeAdyacente()] = a.getPeso();
								else
									costoTotal[a.getVerticeAdyacente()] = a.getPeso() + dc2.getCostoCPUporHora() * esfuerzoRequerido;
							}
						}
						aux = aux.getSig();
					}
					
					while(!todosVisitados(visitado)){
						int minimo = minimoSinVisitar(visitado,costo);
						visitado[minimo] = true;
						
						Nodo aux2 = grafo.getListaAdyacencia()[minimo].getInicio();
						
						while(aux2 != null){
							AristaLista a = (AristaLista)aux2.getDato();
							
							if(!visitado[a.getVerticeAdyacente()]){
								
								if(costo[a.getVerticeAdyacente()] > costo[minimo] + a.getPeso())
									costo[a.getVerticeAdyacente()] = costo[minimo] + a.getPeso();
								
								Ubicable ubi = (Ubicable)grafo.getDatosNodosUsados()[a.getVerticeAdyacente()];
								if(ubi instanceof DataCenter){
									DataCenter dc2 = (DataCenter)ubi;
									if(dc2.getCapacidadCPUenHoras() >= esfuerzoRequerido){
										if(e.equals(dc2.getEmpresa())){
											costoTotal[a.getVerticeAdyacente()] = costo[a.getVerticeAdyacente()];
										}
										else{
											costoTotal[a.getVerticeAdyacente()] = costo[a.getVerticeAdyacente()] + dc2.getCostoCPUporHora() * esfuerzoRequerido;
										}
									}
								}
							}
							aux2 = aux2.getSig();
						}
					}
					int posicionMinimo = posicionMinimo(costoTotal);
					
					if(costoTotal[posicionMinimo] == Integer.MAX_VALUE)
						throw new ObligatorioException("No existe un DataCenter que pueda procesar la información.");
					
					DataCenter ret = (DataCenter)grafo.getDatosNodosUsados()[posicionMinimo];
					
					ret.setCapacidadCPUenHoras(ret.getCapacidadCPUenHoras()-esfuerzoRequerido);
					
					retorno = ret.getNombre() + " | " + costoTotal[posicionMinimo];
					
					return retorno;
				}
			}
		}
		throw new ObligatorioException("No existe un DataCenter con esas Coordenadas.");
	}

	private int posicionMinimo(int[] costoTotal) {
		int pos = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<costoTotal.length;i++){
				if(costoTotal[i] <= min){
					min = costoTotal[i];
					pos = i;
				}
		}
		return pos;
	}

	private boolean todosVisitados(boolean[] v){
		for(int i = 0;i<v.length;i++){
			if(v[i] == false)
				return false;
		}
		return true;
	}
	
	private int minimoSinVisitar(boolean[] v, int[] costo){
		int pos = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<v.length;i++){
			if(!v[i]){
				if(costo[i] <= min){
					min = costo[i];
					pos = i;
				}
			}
		}
		return pos;
	}

	public String obtenerURL() {
		String ama = "0xF7FE2E";
		String ver = "0x04B431";
		String azu = "0x2E2EFE";
		String lil = "0xD0A9F5";
		
		String marcador = "&markers=color:";
		//String label = "|label:";
		String coordx="|";
		String coordy=",%20";
		
		String ruta = "&path=color:0xff0000ff|weight:3";
		
		String retorno = "http://maps.googleapis.com/maps/api/staticmap?size=1200x800&maptype=roadmap&sensor=false";
		
		if(!grafo.estaVacio()){
			String[] vectAdy = new String[grafo.getSize()*(grafo.getSize()-1)/2];
			
			for(int i=0;i<grafo.getSize();i++){
				if(grafo.getNodosUsados()[i]){
					String s = marcador;
					Ubicable u = (Ubicable)grafo.getDatosNodosUsados()[i];
					if(u instanceof Ciudad){
						s += ama;
					}
					else{
						DataCenter dc = (DataCenter)u;
						String c = dc.getEmpresa().getColor();
						if(c.equalsIgnoreCase("VERDE")){
							s += ver;
						}
						else if(c.equalsIgnoreCase("AZUL")){
							s += azu;
						}
						else if(c.equalsIgnoreCase("LILA")){
							s += lil;
						}
						else{
							s += c;
						}
					}
					//s += label + i;
					s+= coordx + u.getCoordX() + coordy + u.getCoordY();
					retorno += s;
					
					Nodo n = ((Lista)grafo.getListaAdyacencia()[i]).getInicio();
					while(n != null){
						int adyacente = ((AristaLista)n.getDato()).getVerticeAdyacente();
						Ubicable ady = (Ubicable)grafo.getDatosNodosUsados()[adyacente];
						
						vectAdy = agregarTramo(vectAdy,u.getCoordX(),u.getCoordY(),ady.getCoordX(),ady.getCoordY());
						
						n = n.getSig();
					}
				}
			}
			for(int i=0;i<vectAdy.length;i++){
				if(vectAdy[i] != null && !vectAdy[i].equals("")){
					String[] coordenadas = vectAdy[i].split("%");
					String x = coordenadas[0];
					String y = coordenadas[1];
					String x2 = coordenadas[2];
					String y2 = coordenadas[3];
					
					retorno += ruta + coordx + x + coordy + y + coordx + x2 + coordy + y2;
				}
			}
		}
		else{
			retorno += "&center=Uruguay&zoom=7";
		}
		
		return retorno;
	}

	private String[] agregarTramo(String[] vectAdy, double coordX, double coordY, double coordX2, double coordY2) {
		String tramo = coordX + "%" + coordY + "%" + coordX2 + "%" + coordY2;
		for(int i = 0;i<vectAdy.length;i++){
			if(noEstaTramo(vectAdy,coordX,coordY,coordX2,coordY2) && (vectAdy[i]== null || vectAdy[i].equals(""))){
				vectAdy[i] = tramo;
				return vectAdy;
			}
		}
		return vectAdy;
	}

	private boolean noEstaTramo(String[] vectAdy, double coordX, double coordY, double coordX2, double coordY2) {
		String ida = coordX + "%" + coordY + "%" + coordX2 + "%" + coordY2;
		String vuelta = coordX2 + "%" + coordY2 + "%" + coordX + "%" + coordY;
		
		for(int i = 0;i<vectAdy.length;i++){
			if(vectAdy[i] != null && (vectAdy[i].equals(ida) || vectAdy[i].equals(vuelta)))
				return false;
		}
		
		return true;
	}
}
