package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static int calcularClave(String nombre) {
		int retorno=0;
		for(int i=0;i<nombre.length();i++){
			retorno+=(int)nombre.charAt(i);
		}
		return retorno;
	}


    public static boolean verificarEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
}
