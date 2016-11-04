package Obligatorio;

import Clases.Empresa;
import Obligatorio.Retorno.Resultado;
import Tads.ArbolBinario;
import Tads.NodoArbol;
import Utilidades.Utilidades;


public class Sistema implements ISistema {
	public enum TipoPunto {CIUDAD,DATACENTER}; //Uso Opcional
        
	private ArbolBinario arbolEmpresas;

	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		
		arbolEmpresas = new ArbolBinario();
		
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno destruirSistema() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarEmpresa(String nombre, String direccion,
			String pais, String email_contacto, String color) {
		
		Empresa nueva= new Empresa(nombre, direccion, pais, email_contacto, color);
		//Calculo la clave como un valor numerico
		int clave=Utilidades.calcularClave(nombre);
	
		NodoArbol buscado = arbolEmpresas.buscar(clave);
		if(buscado!=null && buscado.getDato().equals(nueva)){
			return new Retorno(Resultado.ERROR_2);
		}else if(!Utilidades.verificarEmail(email_contacto)){
			return new Retorno(Resultado.ERROR_1);
		}else{			
			arbolEmpresas.add(clave, nueva);
			return new Retorno(Resultado.OK);
		}
	}

	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarDC(String nombre, Double coordX, Double coordY,
			String empresa, int capacidadCPUenHoras, int costoCPUporHora) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf, int peso) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi,
			Double coordXf, Double coordYf) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno mapaEstado() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno procesarInformación(Double coordX, Double coordY,
			int esfuerzoCPUrequeridoEnHoras) {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno listadoRedMinima() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno listadoEmpresas() {
		// TODO Auto-generated method stub
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

		
}
