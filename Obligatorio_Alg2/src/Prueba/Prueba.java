package Prueba;
import Obligatorio.Retorno.Resultado;

public class Prueba {

    static int cantCorrectas, cantIncorrectas, cantNoImplementadas;

    void inicializarResultadosPrueba() {
        cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
    }

    public void ver(Resultado retorno, Resultado retornoEsperado, String comentario){
        System.out.println();
        System.out.println( "-------------------------- Testeo --------------------------");
        imprimirComentario(comentario);
        imprimirRetorno(retorno,retornoEsperado);
        System.out.println("----------------------------------------------------");

        if (retorno.equals(retornoEsperado))
            cantCorrectas++;
        else{
            if (retorno.equals(Resultado.NO_IMPLEMENTADA))
                cantNoImplementadas++;
            else
                cantIncorrectas++;
        }
    }

    void imprimirComentario(String comentario){
        if(comentario != null || !comentario.isEmpty()){
            System.out.println("\n  Comentario: " + comentario);
            System.out.println();
        }
    }

    public void imprimirRetorno(Resultado retorno, Resultado retornoEsperado){
        System.out.println("  Retorno de la app.: " + retorno + " ->\t" + getStringRetorno(retorno));
        if ( retorno == retornoEsperado )
            System.out.println("\t\t.........OK.........");
        else
            System.out.println("  Se esperaba.......: " + retornoEsperado + " ->\t" + getStringRetorno(retornoEsperado));
    }

    public String getStringRetorno(Resultado retorno){
        switch(retorno){
            case OK:
                return "OK";
            case ERROR_1:
                return "ERROR_1";
            case ERROR_2:
                return "ERROR_2";  
            case ERROR_3:
                return "ERROR_3";  
            case ERROR_4:
                return "ERROR_4";  
            case ERROR_5:
                return "ERROR_5";                                                               
            case NO_IMPLEMENTADA:
                return "NO_IMPLEMENTADA";
            default:
                return "NO_IMPLEMENTADA";
        }
    }

    void imprimirResultadosPrueba(){
        System.out.println();
        System.out.println( "  +------------------------------+");
        System.out.println("    RESULTADOS DE LA PRUEBA    ");
        System.out.println("    Pruebas Correctas: " + cantCorrectas);
        System.out.println("    Pruebas Incorrectas: " + cantIncorrectas );
        System.out.println("    Pruebas NI: " + cantNoImplementadas);
        System.out.println("  +------------------------------+");
        System.out.println();
    }
        
}