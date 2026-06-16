package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

/**
 * <b>Descripción:</b>
 * Representa al estudiante o evaluado que realiza el test espacial dentro del
 * sistema.
 * 
 * <b>Responsabilidad:</b>
 * Gestionar el acceso al sistema y ejecutar el test.
 * 
 * <b>Atributos:</b>
 * idUsuario: Identificador único del usuario.
 * nombre: Nombre del usuario.
 * email: Correo electrónico de acceso.
 * password: Contraseña cifrada o validada.
 * 
 * <b>Métodos:</b>
 * iniciarSesion(): Valida credenciales del usuario.
 * realizarTest(): Inicia la ejecución del test.
 * @author diego
 * @version 1.0
 * @created 11-jun-2026 1:27:29 p. m.
 */
public class Usuario {

	private String email;
	private int idUsuario;
	private String nombre;
	private String password;
	public Resultado m_Resultado;
	public Rol m_Rol;
	public RespuestaUsuario m_RespuestaUsuario;

	public Usuario(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param password
	 * @param email
	 */
	public boolean iniciarSesion(String password, String email){
		return false;
	}

	public void realizarTest(){

	}

	public void registrarse(){

	}
}//end Usuario