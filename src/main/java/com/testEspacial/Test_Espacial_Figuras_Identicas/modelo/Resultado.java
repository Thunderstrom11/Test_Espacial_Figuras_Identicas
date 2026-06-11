

/**
 * <b>Descripción:</b>
 * Contiene el resultado final del test.
 * 
 * <b>Responsabilidad:</b>
 * Consolidar puntuación, aciertos y errores.
 * 
 * <b>Atributos:</b>
 * idResultado: Identificador del resultado.
 * aciertos: Número de respuestas correctas.
 * errores: Número de respuestas incorrectas.
 * puntajeObtenido: Puntuación final.
 * fecha: Fecha de realización.
 * horaInicio: Inicio del tiempo (desde ejercicio 3).
 * horaFin: Fin del tiempo
 * 
 * <b>Métodos:</b>
 * calcularTS() ? Calcula la puntuación final.
 * calcularAciertos() ? Suma respuestas correctas.
 * calcularErrores() ? Suma respuestas incorrectas.
 * @author alond
 * @version 1.0
 * @created 11-jun-2026 1:27:34 p. m.
 */
public class Resultado {

	private int aciertos;
	private int errores;
	private Date fecha;
	private Datetime horaFin;
	private Datetime horaInicio;
	private int idResultado;
	private double puntajeObtenido;
	public Test m_Test;

	public Resultado(){

	}

	public void finalize() throws Throwable {

	}
	public int calcularAciertos(){
		return 0;
	}

	public int calcularErrores(){
		return 0;
	}

	public double calcularTS(){
		return 0;
	}
}//end Resultado