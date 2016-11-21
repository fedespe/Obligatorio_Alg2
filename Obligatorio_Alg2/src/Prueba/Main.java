package Prueba;

import Obligatorio.Retorno;
import Obligatorio.Sistema;

public class Main {
    
    public static void main(String[] args) {
                
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        JuegoDePrueba(s,p);
        p.imprimirResultadosPrueba();
    }
    
    public static void JuegoDePrueba(Sistema s, Prueba p){
    	//Requerimiento 1.1 - Inicializar Sistema
    	p.ver(s.inicializarSistema(0).resultado, Retorno.Resultado.ERROR_1, "Se intenta inicializar el Sistema con cantidad de puntos menor a 1.");
        p.ver(s.inicializarSistema(2).resultado, Retorno.Resultado.OK, "Se inicializa el Sistema (con un máximo de 2 puntos).");
    	
    	//Requerimiento 2.1 - Registrar empresa
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email", "Azul").resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar una empresa con un email no válido -sin Punto-.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "emailemail", "Azul").resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar una empresa con un email no válido -sin Arroba-.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email.com", "Azul").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email.com", "Azul").resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar una empresa con un nombre igual a otra ya registrada.");
        
        //Requerimiento 2.2 - Registrar ciudad
        p.ver(s.registrarCiudad("Ciudad 1", -30.92, -57.44).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 2", -30.92, -57.44).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar una ciudad con coordenadas ya ocupadas por otra.");
        p.ver(s.registrarCiudad("Ciudad 2", -32.63, -54.60).resultado, Retorno.Resultado.OK, "Se registra una ciudad (Y se llena la cantidad máxima disponible).");
        p.ver(s.registrarCiudad("Ciudad 2", -34.26, -55.22).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar una ciudad siendo que ya se alcanzó la máxima cantidad de puntos disponibles.");
        
        //Requerimiento 2.3 - Registrar data-center
        p.ver(s.registrarDC("Data-Center 1", -31.58, -55.24, "Empresa 1", 10, 1).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar un data-center siendo que ya se alcanzó la máxima cantidad de puntos disponibles (todos ocupados por ciudades).");
        
        //Requerimiento 1.2 - Destruir Sistema
        p.ver(s.destruirSistema().resultado, Retorno.Resultado.OK, "Se destruye el Sistema.");
        
        //Requerimiento 1.1 - Inicializar Sistema
        p.ver(s.inicializarSistema(11).resultado, Retorno.Resultado.OK, "Se inicializa el Sistema (con un máximo de 11 puntos).");
        
        //Requerimiento 2.1 - Registrar empresa
        p.ver(s.registrarEmpresa("Empresa 2", "Dir 2", "Pais 2", "email2@email.com", "Verde").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email1@email.com", "Azul").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        p.ver(s.registrarEmpresa("Empresa 3", "Dir 3", "Pais 3", "email3@email.com", "Lila").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        
        //Requerimiento 2.2 - Registrar ciudad
        p.ver(s.registrarCiudad("Ciudad de Prueba", 1.0, 1.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 1", -30.92, -57.44).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 2", -32.63, -54.60).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 3", -34.26, -55.22).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 4", -34.03, -56.65).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 5", -31.95, -57.90).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        
        //Requerimiento 2.3 - Registrar data-center
        p.ver(s.registrarDC("Data-Center 1", -31.58, -55.24, "Empresa 1", 0, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un data-center con capacidad igual a Cero.");
        p.ver(s.registrarDC("Data-Center 1", -31.58, -55.24, "Empresa 1", -3, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un data-center con capacidad menor a Cero.");
        p.ver(s.registrarDC("Data-Center 1", -30.92, -57.44, "Empresa 1", 10, 1).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un data-center con coordenadas ya ocupadas por una Ciudad.");
        p.ver(s.registrarDC("Data-Center 1", -31.58, -55.24, "Empresa 1", 10, 1).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 2", -31.58, -55.24, "Empresa 1", 9, 2).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un data-center con coordenadas ya ocupadas por otro data-center.");
        p.ver(s.registrarDC("Data-Center 2", -33.88, -53.98, "Empresa 1", 9, 2).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 3", -33.16, -56.07, "Empresa 2", 8, 3).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 4", -32.63, -57.17, "Empresa 3", 7, 4).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 5", -34.32, -57.75, "Empresa 3", 6, 5).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        
        //Requerimiento 2.4 - Registrar tramo
        p.ver(s.registrarTramo(-31.58, -55.24, -33.88, -53.98, 0).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar un tramo con peso igual a Cero.");
        p.ver(s.registrarTramo(-31.58, -55.24, -33.88, -53.98, -3).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar un tramo con peso menor a Cero.");
        p.ver(s.registrarTramo(100.0, 100.0, -33.88, -53.98, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un tramo con coordenada inicial sin data-center ni ciudad en ella.");
        p.ver(s.registrarTramo(-33.88, -53.98, 100.0, 100.0, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un tramo con coordenada final sin data-center ni ciudad en ella.");
        //Error no Solicitado por letra. Después corroborar que no sea necesario regitrar nunca un tramo de este tipo
        p.ver(s.registrarTramo(-33.88, -53.98, -33.88, -53.98, 1).resultado, Retorno.Resultado.ERROR_5, "Se intenta registrar un tramo con coordenada inicial igual a la final.");
        p.ver(s.registrarTramo(-30.92, -57.44, -31.58, -55.24, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre C1 y DC1.");
        p.ver(s.registrarTramo(-30.92, -57.44, -32.63, -57.17, 2).resultado, Retorno.Resultado.OK, "Se registra tramo entre C1 y DC4.");
        p.ver(s.registrarTramo(-32.63, -54.60, -31.58, -55.24, 5).resultado, Retorno.Resultado.OK, "Se registra tramo entre C2 y DC1.");
        p.ver(s.registrarTramo(-32.63, -54.60, -33.88, -53.98, 10).resultado, Retorno.Resultado.OK, "Se registra tramo entre C2 y DC2.");
        p.ver(s.registrarTramo(-32.63, -54.60, -33.16, -56.07, 3).resultado, Retorno.Resultado.OK, "Se registra tramo entre C2 y DC3.");
        p.ver(s.registrarTramo(-34.26, -55.22, -33.88, -53.98, 4).resultado, Retorno.Resultado.OK, "Se registra tramo entre C3 y DC2.");
        p.ver(s.registrarTramo(-34.26, -55.22, -33.16, -56.07, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre C3 y DC3.");
        p.ver(s.registrarTramo(-34.26, -55.22, -34.03, -56.65, 5).resultado, Retorno.Resultado.OK, "Se registra tramo entre C3 y C4.");
        p.ver(s.registrarTramo(-34.03, -56.65, -33.16, -56.07, 5).resultado, Retorno.Resultado.OK, "Se registra tramo entre C4 y DC3.");
        p.ver(s.registrarTramo(-34.03, -56.65, -34.32, -57.75, 3).resultado, Retorno.Resultado.OK, "Se registra tramo entre C4 y DC5.");
        p.ver(s.registrarTramo(-31.95, -57.90, -32.63, -57.17, 2).resultado, Retorno.Resultado.OK, "Se registra tramo entre C5 y DC4.");
        p.ver(s.registrarTramo(-31.58, -55.24, -33.16, -56.07, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre DC1 y DC3.");
        p.ver(s.registrarTramo(-31.58, -55.24, -32.63, -57.17, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre DC1 y DC4.");
        p.ver(s.registrarTramo(-31.58, -55.24, -34.32, -57.75, 3).resultado, Retorno.Resultado.OK, "Se registra tramo entre DC1 y DC5.");
        p.ver(s.registrarTramo(-31.58, -55.24, -34.32, -57.75, 3).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un tramo exactmente igual a uno existente.");
        p.ver(s.registrarTramo(-34.32, -57.75, -31.58, -55.24, 3).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un tramo inverso a uno existente.");
        p.ver(s.registrarTramo(-31.95, -57.90, -33.16, -56.07, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre C5 y DC3."); //Tramo que será eliminado directamente
        p.ver(s.registrarTramo(1.0, 1.0, -30.92, -57.44, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre Ciudad de Prueba y C1.");
        
        //Requerimiento 2.6 - Eliminar punto del mapa
        p.ver(s.eliminarPunto(100.00, 100.00).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un punto con coordenadas en las que no hay punto registrado.");
        p.ver(s.eliminarPunto(1.00, 1.00).resultado, Retorno.Resultado.OK, "Se elimina el punto Ciudad de Prueba.");
        
        //Requerimiento 2.5 - Eliminar tramo
        p.ver(s.eliminarTramo(-32.63, -54.60, -34.26, -55.22).resultado, Retorno.Resultado.ERROR_2, "Se elimina tramo con coordenadas validas pero nunca hubo conexion entre ellas.");
        p.ver(s.eliminarTramo(-31.95, -57.90, -33.16, -56.07).resultado, Retorno.Resultado.OK, "Se elimina tramo entre C5 y DC3.");
        p.ver(s.eliminarTramo(100.0, 100.0, -33.88, -53.98).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un tramo con coordenada inicial sin data-center ni ciudad en ella.");
        p.ver(s.eliminarTramo(-33.88, -53.98, 100.0, 100.0).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un tramo con coordenada final sin data-center ni ciudad en ella.");
        p.ver(s.eliminarTramo(-31.95, -57.90, -33.16, -56.07).resultado, Retorno.Resultado.ERROR_2, "Se intenta eliminar un tramo con coordenadas válidas pero sin conexión entre ambos puntos (la conexión ya fué eliminada aneriormente de forma directa).");
        p.ver(s.eliminarTramo(1.0, 1.0, -30.92, -57.44).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un tramo con coordenadas válidas pero sin conexión entre ambos puntos (la conexión ya fué eliminada aneriormente de forma indirecta).");
        
        //Requerimiento 3.2 - Solicitud de procesamiento
        p.ver(s.procesarInformación(1.0, 1.0, 10).resultado, Retorno.Resultado.ERROR_1, "Se manda solicitud de procesamiento a un punto inexistente.");
        p.ver(s.procesarInformación(-31.58, -55.24, 20).resultado, Retorno.Resultado.ERROR_2, "Se manda solicitud de procesamiento a un DataCenter existente pero con una cantidad de información que ninguno puede procesar.");
        p.ver(s.procesarInformación(-31.58, -55.24, 5).resultado, Retorno.Resultado.OK, "Se manda solicitud de procesamiento que da OK en el mismo DC inicial.");
        p.ver(s.procesarInformación(-32.63, -57.17, 8).resultado, Retorno.Resultado.OK, "Se manda solicitud de procesamiento que da OK en otro DC.");
        p.ver(s.procesarInformación(-31.58, -55.24, 6).resultado, Retorno.Resultado.OK, "Se manda solicitud de procesamiento que da OK en otro DC debido a que al incial se le había bajado la capacidad directamente.");
        p.ver(s.procesarInformación(-33.88, -53.98, 2).resultado, Retorno.Resultado.OK, "Se manda solicitud de procesamiento que da OK en otro DC debido a que al incial se le había bajado la capacidad indirectamente.");
        
        //Requerimiento 3.1 - Mapa de estado
        p.ver(s.mapaEstado().resultado, Retorno.Resultado.OK, "Se abre el navegador por defecto con el mapa de estado.");
        
        //Requerimiento 3.4 - Listado de empresas
        p.ver(s.listadoEmpresas().resultado, Retorno.Resultado.OK, "Se retorna el listado de las empresas en orden por nombre en mandera ascendente.");
        
        //Requerimiento 1.2 - Destruir Sistema
        p.ver(s.destruirSistema().resultado, Retorno.Resultado.OK, "Se destruye el Sistema.");
    }
}
