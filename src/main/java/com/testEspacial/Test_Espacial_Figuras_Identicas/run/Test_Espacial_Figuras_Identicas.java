package com.testEspacial.Test_Espacial_Figuras_Identicas.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicación.
 */

public class Test_Espacial_Figuras_Identicas {

	public static void main(String[] args) throws Exception {
		DBServer.start("Test_Espacial_Figuras_Identicas-db"); // Para usar tu propia base de datos comenta esta línea y configura src/main/webapp/META-INF/context.xml
		AppServer.run("Test_Espacial_Figuras_Identicas"); // Usa AppServer.run("") para funcionar en el contexto raíz
	}

}
