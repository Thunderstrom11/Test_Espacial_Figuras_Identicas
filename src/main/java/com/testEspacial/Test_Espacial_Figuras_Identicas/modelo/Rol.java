package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

import java.util.Arrays;
import java.util.List;

// Representa el nivel de acceso (rol) de un usuario en el sistema
public class Rol {

    // Roles oficiales permitidos
    public static final String ADMINISTRADOR = "Administrador";
    public static final String PSICOLOGO = "Psicólogo";
    public static final String SUJETO = "Sujeto";

    // Lista de roles válidos (se usa para validar el nombre del rol)
    private static final List<String> ROLES_VALIDOS =
            Arrays.asList(ADMINISTRADOR, PSICOLOGO, SUJETO);

    // Identificador único del rol
    private int idRol;

    // Nombre del rol (solo puede ser uno de los roles válidos)
    private String nombreRol;

    // Constructor vacío
    public Rol() {
    }

    // Constructor con el nombre del rol
    public Rol(String nombreRol) {
        setNombreRol(nombreRol);
    }

    // Devuelve el nombre del rol
    public String getNombreRol() {
        return nombreRol;
    }

    // Asigna el nombre del rol; valida que sea uno de los roles válidos
    public void setNombreRol(String nombreRol) {
        if (nombreRol == null || !ROLES_VALIDOS.contains(nombreRol)) {
            throw new IllegalArgumentException(
                "Rol no válido. Use: Administrador, Psicólogo o Sujeto.");
        }
        this.nombreRol = nombreRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    // Indica si el rol es Administrador
    public boolean esAdministrador() {
        return ADMINISTRADOR.equals(nombreRol);
    }

    // Indica si el rol es Psicólogo
    public boolean esPsicologo() {
        return PSICOLOGO.equals(nombreRol);
    }

    // Indica si el rol es Sujeto
    public boolean esSujeto() {
        return SUJETO.equals(nombreRol);
    }

    // Devuelve los datos del rol
    @Override
    public String toString() {
        return "Rol{idRol=" + idRol + ", nombreRol=" + nombreRol + '}';
    }
}
