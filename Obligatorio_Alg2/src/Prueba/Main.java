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
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email", "Rojo").resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar una empresa con un email no válido -sin Punto-.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "emailemail", "Rojo").resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar una empresa con un email no válido -sin Arroba-.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email.com", "Rojo").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email@email.com", "Rojo").resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar una empresa con un nombre igual a otra ya registrada.");
        
        //Requerimiento 2.2 - Registrar ciudad
        p.ver(s.registrarCiudad("Ciudad 1", 10.0, 10.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 2", 10.0, 10.0).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar una ciudad con coordenadas ya ocupadas por otra.");
        p.ver(s.registrarCiudad("Ciudad 2", 11.0, 11.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad (Y se llena la cantidad máxima disponible).");
        p.ver(s.registrarCiudad("Ciudad 2", 12.0, 12.0).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar una ciudad siendo que ya se alcanzó la máxima cantidad de puntos disponibles.");
        
        //Requerimiento 2.3 - Registrar data-center
        p.ver(s.registrarDC("Data-Center 1", 15.0, 15.0, "Empresa 1", 10, 1).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar un data-center siendo que ya se alcanzó la máxima cantidad de puntos disponibles (todos ocupados por ciudades).");
        
        //Requerimiento 1.2 - Destruir Sistema
        p.ver(s.destruirSistema().resultado, Retorno.Resultado.OK, "Se destruye el Sistema.");
        
        //Requerimiento 1.1 - Inicializar Sistema
        p.ver(s.inicializarSistema(11).resultado, Retorno.Resultado.OK, "Se inicializa el Sistema (con un máximo de 11 puntos).");
        
        //Requerimiento 2.1 - Registrar empresa
        p.ver(s.registrarEmpresa("Empresa 1", "Dir 1", "Pais 1", "email1@email.com", "Rojo").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        p.ver(s.registrarEmpresa("Empresa 2", "Dir 2", "Pais 2", "email2@email.com", "Verde").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        p.ver(s.registrarEmpresa("Empresa 3", "Dir 3", "Pais 3", "email3@email.com", "Negro").resultado, Retorno.Resultado.OK, "Se registra una empresa.");
        
        //Requerimiento 2.2 - Registrar ciudad
        p.ver(s.registrarCiudad("Ciudad de Prueba", 1.0, 1.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 1", 10.0, 10.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 2", 11.0, 11.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 3", 12.0, 12.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 4", 13.0, 13.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        p.ver(s.registrarCiudad("Ciudad 5", 14.0, 14.0).resultado, Retorno.Resultado.OK, "Se registra una ciudad.");
        
        //Requerimiento 2.3 - Registrar data-center
        p.ver(s.registrarDC("Data-Center 1", 15.0, 15.0, "Empresa 1", 0, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un data-center con capacidad igual a Cero.");
        p.ver(s.registrarDC("Data-Center 1", 15.0, 15.0, "Empresa 1", -3, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un data-center con capacidad menor a Cero.");
        p.ver(s.registrarDC("Data-Center 1", 10.0, 10.0, "Empresa 1", 10, 1).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un data-center con coordenadas ya ocupadas por una Ciudad.");
        p.ver(s.registrarDC("Data-Center 1", 15.0, 15.0, "Empresa 1", 10, 1).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 2", 15.0, 15.0, "Empresa 1", 9, 2).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un data-center con coordenadas ya ocupadas por otro data-center.");
        p.ver(s.registrarDC("Data-Center 2", 16.0, 16.0, "Empresa 1", 9, 2).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 3", 17.0, 17.0, "Empresa 2", 8, 3).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 4", 18.0, 18.0, "Empresa 3", 7, 4).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        p.ver(s.registrarDC("Data-Center 5", 19.0, 19.0, "Empresa 3", 6, 5).resultado, Retorno.Resultado.OK, "Se registra un data-center.");
        
        //Requerimiento 2.4 - Registrar tramo
        p.ver(s.registrarTramo(15.0, 15.0, 16.0, 16.0, 0).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar un tramo con peso igual a Cero.");
        p.ver(s.registrarTramo(15.0, 15.0, 16.0, 16.0, -3).resultado, Retorno.Resultado.ERROR_1, "Se intenta registrar un tramo con peso menor a Cero.");
        p.ver(s.registrarTramo(100.0, 100.0, 16.0, 16.0, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un tramo con coordenada inicial sin data-center ni ciudad en ella.");
        p.ver(s.registrarTramo(16.0, 16.0, 100.0, 100.0, 1).resultado, Retorno.Resultado.ERROR_2, "Se intenta registrar un tramo con coordenada final sin data-center ni ciudad en ella.");
        //Error no Solicitado por letra. Después corroborar que no sea necesario regitrar nunca un tramo de este tipo
        p.ver(s.registrarTramo(16.0, 16.0, 16.0, 16.0, 1).resultado, Retorno.Resultado.ERROR_5, "Se intenta registrar un tramo con coordenada inicial igual a la final.");
        p.ver(s.registrarTramo(10.0, 10.0, 15.0, 15.0, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre C1 y DC1.");
        p.ver(s.registrarTramo(10.0, 10.0, 18.0, 18.0, 2).resultado, Retorno.Resultado.OK, "Se registra tramo entre C1 y DC4.");
        p.ver(s.registrarTramo(11.0, 11.0, 15.0, 15.0, 5).resultado, Retorno.Resultado.OK, "Se registra tramo entre C2 y DC1.");
        p.ver(s.registrarTramo(11.0, 11.0, 16.0, 16.0, 10).resultado, Retorno.Resultado.OK, "Se registra tramo entre C2 y DC2.");
        p.ver(s.registrarTramo(11.0, 11.0, 17.0, 17.0, 3).resultado, Retorno.Resultado.OK, "Se registra tramo entre C2 y DC3.");
        p.ver(s.registrarTramo(12.0, 12.0, 16.0, 16.0, 4).resultado, Retorno.Resultado.OK, "Se registra tramo entre C3 y DC2.");
        p.ver(s.registrarTramo(12.0, 12.0, 17.0, 17.0, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre C3 y DC3.");
        p.ver(s.registrarTramo(12.0, 12.0, 13.0, 13.0, 5).resultado, Retorno.Resultado.OK, "Se registra tramo entre C3 y C4.");
        p.ver(s.registrarTramo(13.0, 13.0, 17.0, 17.0, 5).resultado, Retorno.Resultado.OK, "Se registra tramo entre C4 y DC3.");
        p.ver(s.registrarTramo(13.0, 13.0, 19.0, 19.0, 3).resultado, Retorno.Resultado.OK, "Se registra tramo entre C4 y DC5.");
        p.ver(s.registrarTramo(14.0, 14.0, 18.0, 18.0, 2).resultado, Retorno.Resultado.OK, "Se registra tramo entre C5 y DC4.");
        p.ver(s.registrarTramo(15.0, 15.0, 17.0, 17.0, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre DC1 y DC3.");
        p.ver(s.registrarTramo(15.0, 15.0, 18.0, 18.0, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre DC1 y DC4.");
        p.ver(s.registrarTramo(15.0, 15.0, 19.0, 19.0, 3).resultado, Retorno.Resultado.OK, "Se registra tramo entre DC1 y DC5.");
        p.ver(s.registrarTramo(15.0, 15.0, 19.0, 19.0, 3).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un tramo exactmente igual a uno existente.");
        p.ver(s.registrarTramo(19.0, 19.0, 15.0, 15.0, 3).resultado, Retorno.Resultado.ERROR_3, "Se intenta registrar un tramo inverso a uno existente.");
        p.ver(s.registrarTramo(14.0, 14.0, 17.0, 17.0, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre C5 y DC3."); //Tramo que será eliminado directamente
        p.ver(s.registrarTramo(1.0, 1.0, 10.0, 10.0, 1).resultado, Retorno.Resultado.OK, "Se registra tramo entre Ciudad de Prueba y C1.");
        
        //Requerimiento 2.6 - Eliminar punto del mapa
        p.ver(s.eliminarPunto(100.00, 100.00).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un punto con coordenadas en las que no hay punto registrado.");
        p.ver(s.eliminarPunto(1.00, 1.00).resultado, Retorno.Resultado.OK, "Se elimina el punto Ciudad de Prueba.");
        
        //Requerimiento 2.5 - Eliminar tramo
        p.ver(s.eliminarTramo(11.0, 11.0, 12.0, 12.0).resultado, Retorno.Resultado.ERROR_2, "Se elimina tramo con coordenadas validas pero nunca hubo conexion entre ellas.");
        p.ver(s.eliminarTramo(14.0, 14.0, 17.0, 17.0).resultado, Retorno.Resultado.OK, "Se elimina tramo entre C5 y DC3.");
        p.ver(s.eliminarTramo(100.0, 100.0, 16.0, 16.0).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un tramo con coordenada inicial sin data-center ni ciudad en ella.");
        p.ver(s.eliminarTramo(16.0, 16.0, 100.0, 100.0).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un tramo con coordenada final sin data-center ni ciudad en ella.");
        p.ver(s.eliminarTramo(14.0, 14.0, 17.0, 17.0).resultado, Retorno.Resultado.ERROR_2, "Se intenta eliminar un tramo con coordenadas válidas pero sin conexión entre ambos puntos (la conexión ya fué eliminada aneriormente de forma directa).");
        p.ver(s.eliminarTramo(1.0, 1.0, 10.0, 10.0).resultado, Retorno.Resultado.ERROR_1, "Se intenta eliminar un tramo con coordenadas válidas pero sin conexión entre ambos puntos (la conexión ya fué eliminada aneriormente de forma indirecta).");
        
        //Requerimiento 1.2 - Destruir Sistema
        p.ver(s.destruirSistema().resultado, Retorno.Resultado.OK, "Se destruye el Sistema.");
    
        
    
    
    }
}
