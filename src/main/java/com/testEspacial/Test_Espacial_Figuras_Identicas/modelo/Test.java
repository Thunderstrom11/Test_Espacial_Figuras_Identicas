

/**
 * <b>Descripción:</b>
 * Representa la prueba psicológica espacial figuras idénticas.
 * 
 * <b>En que consiste el test espacial figuras idénticas?</b>
 * 
 * <b>Responsabilidad:</b>
 * Controlar la ejecución, estructura y evaluación del test.
 * 
 * <b>Atributos:</b>
 * idTest: Identificador del test.
 * nombreTest: Nombre del test.
 * totalEjercicios: Cantidad fija de ejercicios (27).
 * tiempoLimite: Tiempo máximo permitido.
 * 
 * <b>Métodos:</b>
 * iniciar(): Comienza la evaluación.
 * calcularScore(): Calcula el resultado final (TS).
 * finalizar(): Termina el test.
 * @author alond
 * @version 1.0
 * @created 11-jun-2026 1:27:31 p. m.
 */
public class Test {

	private int idTest;
	private String nombreTest;
	private int tiempoLimite;
	private int totalEjercicios;
	public InstruccionTest m_InstruccionTest;
	public Ejercicio m_Ejercicio;

	public Test(){

	}

	public void finalize() throws Throwable {

	}
	public double calcularPuntaje(){
		return 0;
	}

	public void finalizarTest(){

	}

	public void iniciarTest(){

	}
}//end Test