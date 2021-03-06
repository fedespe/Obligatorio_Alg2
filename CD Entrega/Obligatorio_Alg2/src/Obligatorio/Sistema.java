package Obligatorio;

import Clases.Ciudad;
import Clases.DataCenter;
import Clases.Empresa;
import Clases.GrafoCoordenada;
import Clases.ObligatorioException;
import Clases.Ubicable;
import Obligatorio.Retorno.Resultado;
import Tads.ArbolBinario;
import Tads.NodoArbol;
import Utilidades.Utilidades;


public class Sistema implements ISistema {
	public enum TipoPunto {CIUDAD,DATACENTER}; //Uso Opcional
        
	private ArbolBinario arbolEmpresas;
	private GrafoCoordenada mapa;

	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		
		if(cantPuntos <= 0)
			return new Retorno(Resultado.ERROR_1);
		
		arbolEmpresas = new ArbolBinario();
		mapa = new GrafoCoordenada(cantPuntos);
		return new Retorno(Resultado.OK);
	}
	
	@Override
	public Retorno destruirSistema() {
		arbolEmpresas=null;
		mapa=null;
		return new Retorno(Resultado.OK);
	}
	
	@Override
	public Retorno registrarEmpresa(String nombre, String direccion,
			String pais, String email_contacto, String color) {
		
		if(!Utilidades.verificarEmail(email_contacto))
			return new Retorno(Resultado.ERROR_1);
		
		String clave=nombre;
		NodoArbol buscado = arbolEmpresas.buscar(clave);
		Empresa nueva = new Empresa(nombre, direccion, pais, email_contacto, color);
		
		if(buscado!=null && buscado.getDato().equals(nueva))
			return new Retorno(Resultado.ERROR_2);
		
		arbolEmpresas.add(clave, nueva);
		return new Retorno(Resultado.OK);
	}
	
	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		
		if(!mapa.hayLugar())
			return new Retorno(Resultado.ERROR_1);
		
		Ciudad nueva = new Ciudad(nombre, coordX, coordY);
		if(mapa.coordenadasOcupadas(coordX, coordY))
			return new Retorno(Resultado.ERROR_2);
		
		if(mapa.agregarVertice(nueva))
			return new Retorno(Resultado.OK);
		else
			return new Retorno(Resultado.ERROR_3);
		//Al haber controlado antes que hay lugar en el grafo y que no existe un punto con esas coordenadas,
		//siempre deber�a dar true el m�todo agregarVertice... Por las dudas que de false,
		//para que nos salte la diferencia, le agregu� el error3 que no est� solicitado por letra
	}
	
	@Override
	public Retorno registrarDC(String nombre, Double coordX, Double coordY,
			String empresa, int capacidadCPUenHoras, int costoCPUporHora) {

		if(!mapa.hayLugar())
			return new Retorno(Resultado.ERROR_1);
		
		if(capacidadCPUenHoras <= 0)
			return new Retorno(Resultado.ERROR_2);
		
		if(mapa.coordenadasOcupadas(coordX, coordY))
			return new Retorno(Resultado.ERROR_3);
		
		String clave=empresa;
		NodoArbol buscado = arbolEmpresas.buscar(clave);
		if(buscado == null)
			return new Retorno(Resultado.ERROR_4);
		
		Empresa emp = (Empresa)buscado.getDato();
		DataCenter nuevo = new DataCenter(nombre, coordX, coordY, emp, capacidadCPUenHoras, costoCPUporHora);
				
		if(mapa.agregarVertice(nuevo))
			return new Retorno(Resultado.OK);
		else{
			return new Retorno(Resultado.ERROR_5);
		}
		//Al haber controlado antes que hay lugar en el grafo y que no existe un punto con esas coordenadas,
		//siempre deber�a dar true el m�todo agregarVertice... Por las dudas que de false,
		//para que nos salte la diferencia, le agregu� el error5 que no est� solicitado por letra
	}
	
	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf, int peso) {
		try {
			if(peso <= 0)
				return new Retorno(Resultado.ERROR_1);
			if(coordXf.equals(coordXi) && coordYi.equals(coordYf))
				return new Retorno(Resultado.ERROR_5);
			Ubicable uOrigen= new Ubicable("", coordXi, coordYi);
			Ubicable uDestino= new Ubicable("", coordXf, coordYf);
		
			mapa.agregarArista(uOrigen, uDestino, peso);
			return new Retorno(Resultado.OK);
		} catch (ObligatorioException e) {
			if(e.getMessage()=="No existe coordenada inicial o final"){
				return new Retorno(Resultado.ERROR_2);
			}else if(e.getMessage()=="Ya existe arista"){
				return new Retorno(Resultado.ERROR_3);
			}else{
				return new Retorno(Resultado.ERROR_4);//No tendria que entrar nunca, en caso que tire otra exception
			}
		}
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf) {
		Ubicable uOrigen= new Ubicable("", coordXi, coordYi);
		Ubicable uDestino= new Ubicable("", coordXf, coordYf);
		
		try {
			mapa.eliminarArista(uOrigen, uDestino);
			return new Retorno(Resultado.OK);
		} catch (ObligatorioException e) {
			if(e.getMessage().equals("No existe coordenada inicial o final")){
				return new Retorno(Resultado.ERROR_1);				
			}
			else if(e.getMessage().equals("No existe arista")){
				return new Retorno(Resultado.ERROR_2);				
			}else{
				return new Retorno(Resultado.ERROR_4);//No tendria que entrar nunca, en caso que tire otra exception
			}
		}
		
		
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		Ubicable puntoMapa= new Ubicable("", coordX, coordY);
		try {
			mapa.eliminarVertice(puntoMapa);
			return new Retorno(Resultado.OK);
		} catch (ObligatorioException e) {
			if(e.getMessage().equals("No existe coordenada")){
				return new Retorno(Resultado.ERROR_1);				
			}else{
				return new Retorno(Resultado.ERROR_4);//No tendria que entrar nunca, en caso que tire otra exception
			}
		}
		
	}
	
	@Override
	public Retorno mapaEstado() {
		String direccion = mapa.obtenerURL();
		try{
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
		}
		catch(Exception err){
			return new Retorno(Resultado.ERROR_1);//No tendria que entrar nunca, pero por si lanza alguna excepcion, agregamos este error
		}
		return new Retorno(Resultado.OK);
	}
	
	@Override
	public Retorno procesarInformacion(Double coordX, Double coordY,
			int esfuerzoCPUrequeridoEnHoras) {
		
		Ubicable v = new Ubicable("",coordX, coordY);
		
		try {
			String[] ret = mapa.procesarInformacion(v, esfuerzoCPUrequeridoEnHoras);
			int costo = Integer.parseInt(ret[1]);
			Retorno retornar = new Retorno(Resultado.OK, ret[0], costo);
			
			return retornar;
		} catch (ObligatorioException e) {
			if(e.getMessage().equals("No existe un DataCenter que pueda procesar la informaci�n."))
					return new Retorno(Resultado.ERROR_2);
			if(e.getMessage().equals("No existe un DataCenter con esas Coordenadas."))
					return new Retorno(Resultado.ERROR_1);
			
			//No deber�a entrar en este error, pero por si salta una excepci�n que no est� contemplada, se crea este retorno.
			return new Retorno(Resultado.ERROR_3);
		}
	}

	@Override
	public Retorno listadoRedMinima() {
		String[] redMinima = mapa.obtenerRedMinima();
		
		int costoTotal = Integer.parseInt(redMinima[1]);
		String red = redMinima[0];//.substring(0,redMinima[0].length()-1);
		Retorno retornar = new Retorno(Resultado.OK, red, costoTotal);
		
		return retornar;
	}

	@Override
	public Retorno listadoEmpresas() {
		
		String ret = arbolEmpresas.retornarDatosInOrden("");
		ret = ret.substring(0,ret.length()-1);
		
		Retorno retornar = new Retorno(Resultado.OK, ret, 0);
		
		return retornar;
	}

		
}
