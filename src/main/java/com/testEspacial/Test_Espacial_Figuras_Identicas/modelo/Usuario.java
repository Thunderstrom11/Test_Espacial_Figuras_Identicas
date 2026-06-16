package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

import java.util.ArrayList;
import java.util.List;

// Representa al usuario que accede al sistema (Administrador, Psicólogo o Sujeto)
public class Usuario {

    // Identificador único del usuario
    private int idUsuario;

    // Nombre del usuario
    private String nombre;

    // Correo de acceso (identifica de forma única al usuario)
    private String email;

    // Contraseña del usuario (debe guardarse cifrada)
    private String password;

    // Estado de la cuenta: true = activa, false = inactiva
    private boolean activo = true;

    // Rol asignado al usuario (obligatorio)
    private Rol rol;

    // Respuestas realizadas por el usuario durante el test
    private List<RespuestaUsuario> respuestas = new ArrayList<>();

    // Resultados obtenidos por el usuario
    private List<Resultado> resultados = new ArrayList<>();

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con los datos principales
    public Usuario(String nombre, String email, String password, Rol rol) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // Valida las credenciales y que la cuenta esté activa
    public boolean iniciarSesion(String password, String email) {
        if (!activo) {
            return false; // los usuarios inactivos no pueden iniciar sesión
        }
        return this.email != null && this.email.equals(email)
            && this.password != null && this.password.equals(password);
    }

    // Inicia la ejecución del test
    public void realizarTest() {
    }

    // Registra un nuevo usuario en el sistema
    public void registrarse() {
    }

    // Valida que el correo tenga un formato básico válido
    public boolean validarCorreo() {
        if (email == null) {
            return false;
        }
        int arroba = email.indexOf("@");
        int punto = email.lastIndexOf(".");
        return arroba > 0 && punto > arroba + 1;
    }

    // Valida que la contraseña tenga al menos 8 caracteres
    public boolean validarPassword() {
        return password != null && password.length() >= 8;
    }

    // Activa la cuenta del usuario
    public void activar() {
        this.activo = true;
    }

    // Desactiva la cuenta del usuario
    public void desactivar() {
        this.activo = false;
    }

    // Indica si la cuenta está activa
    public boolean estaActivo() {
        return activo;
    }

    // ---- Getters y setters ----

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<RespuestaUsuario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaUsuario> respuestas) {
        this.respuestas = respuestas;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    // Devuelve los datos del usuario (sin mostrar la contraseña)
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre=" + nombre +
                ", email=" + email +
                ", activo=" + activo +
                ", rol=" + (rol != null ? rol.getNombreRol() : "sin rol") +
                '}';
    }
}
