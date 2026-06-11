

/**
 * <b>Descripción:</b>
 * Representa el nivel de acceso que posee un usuario dentro de la aplicación.
 * 
 * <b>Responsabilidad:</b>
 * Definir y clasificar el tipo de usuario con el fin de gestionar los permisos de
 * interacción con el sistema y los tests.
 * 
 * <b>Atributos:</b>
 * idRol: Identificador único del rol asignado.
 * nombreRol: Nombre descriptivo del rol (ej. "Administrador", "Sujeto",
 * "Analista").
 * 
 * <b>Métodos:</b>
 * getNombreRol(): Retorna el nombre del rol para que el sistema valide qué
 * interfaz o permisos mostrarle al usuario.
 * @author diego
 * @version 1.0
 * @created 11-jun-2026 1:27:40 p. m.
 */
public class Rol {

	private int idRol;
	private String nombreRol;

	public Rol(){

	}

	public void finalize() throws Throwable {

	}
	public String getNombreRol(){
		return "";
	}
}//end Rol