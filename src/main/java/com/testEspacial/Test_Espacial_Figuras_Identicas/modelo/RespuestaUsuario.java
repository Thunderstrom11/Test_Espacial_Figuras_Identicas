package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

// Representa la respuesta que un sujeto da a un ejercicio del test
public class RespuestaUsuario {

    // Identificador único de la respuesta
    private int idRespuesta;

    // Indica si la opción elegida fue la correcta
    private boolean seleccionCorrecta;

    // Tiempo que tardó en responder (en segundos)
    private double tiempoRespuesta;

    // Usuario al que pertenece la respuesta (obligatorio)
    private Usuario usuario;

    // Opción (A-E) elegida por el usuario
    private Opcion opcion;

    // Constructor vacío
    public RespuestaUsuario() {
    }

    // Constructor con los datos principales
    public RespuestaUsuario(Usuario usuario, Opcion opcion, double tiempoRespuesta) {
        this.usuario = usuario;
        this.opcion = opcion;
        this.tiempoRespuesta = tiempoRespuesta;
    }

    // Valida la respuesta: la corrección se obtiene desde la clase Opcion
    public void validarRespuesta() {
        this.seleccionCorrecta = opcion != null && opcion.isEsCorrecta();
    }

    // Devuelve la letra (A-E) de la opción elegida, o null si no eligió ninguna
    public String getLetraSeleccionada() {
        return opcion != null ? opcion.getLetra() : null;
    }

    // ---- Getters y setters ----

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public boolean isSeleccionCorrecta() {
        return seleccionCorrecta;
    }

    public void setSeleccionCorrecta(boolean seleccionCorrecta) {
        this.seleccionCorrecta = seleccionCorrecta;
    }

    public double getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(double tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    // Devuelve los datos de la respuesta
    @Override
    public String toString() {
        return "RespuestaUsuario{" +
                "idRespuesta=" + idRespuesta +
                ", letra=" + getLetraSeleccionada() +
                ", seleccionCorrecta=" + seleccionCorrecta +
                ", tiempoRespuesta=" + tiempoRespuesta +
                '}';
    }
}
