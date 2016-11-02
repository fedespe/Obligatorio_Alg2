package Prueba;
import Obligatorio.Sistema;
import Utilidades.Utilidades;

public class Prueba {

	public static void main(String[] args) {
		//Utilidades u = new Utilidades();
		Sistema s = new Sistema();
		s.inicializarSistema(2);
		s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email", "Rojo");
		System.out.println(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email", "Rojo"));

		System.out.println(Utilidades.verificarEmail("fede@email.com"));
		System.out.println(Utilidades.verificarEmail("fede@email"));
	}

}
