package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import lombok.*;
import java.util.*;

@Entity
@Getter @Setter
@View(members = 
    "Datos del Ejercicio { test; numeroEjercicio };" +
    "Figura Base { figuraBase };" +
    "Opciones de Respuesta { opciones }"
)
@Tab(properties = "numeroEjercicio, test.nombreTest, figuraBase", 
     defaultOrder = "numeroEjercicio asc")
public class Ejercicio {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    @Hidden
    String oid;

    @Column(length = 3)
    @Required
    int numeroEjercicio;
    
    @Files
    @Column(length = 32)
    String figuraBase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList(descriptionProperties = "nombreTest")
    @Required
    Test test;
    
    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL)
    @ListProperties("letra, esCorrecta")
    @OrderBy("letra ASC")
    Collection<Opcion> opciones;

    public void mostrarEjercicio() {
        // OpenXava muestra automáticamente
    }
    
    public Opcion getOpcionCorrecta() {
        if (opciones == null) return null;
        for (Opcion opcion : opciones) {
            if (opcion.isEsCorrecta()) {
                return opcion;
            }
        }
        return null;
    }
    
    public boolean tieneRespuestaCorrecta() {
        if (opciones == null) return false;
        int contador = 0;
        for (Opcion opcion : opciones) {
            if (opcion.isEsCorrecta()) contador++;
        }
        return contador == 1;
    }
    
    public boolean opcionesCompletas() {
        return opciones != null && opciones.size() == 5;
    }
    
    public Opcion getOpcionPorLetra(String letra) {
        if (opciones == null || letra == null) return null;
        for (Opcion opcion : opciones) {
            if (letra.equalsIgnoreCase(opcion.getLetra())) {
                return opcion;
            }
        }
        return null;
    }
    
    @PrePersist
    @PreUpdate
    public void validar() {
        if (!tieneRespuestaCorrecta()) {
            throw new IllegalStateException(
                "El ejercicio " + numeroEjercicio + " debe tener exactamente una respuesta correcta"
            );
        }
        if (!opcionesCompletas()) {
            throw new IllegalStateException(
                "El ejercicio " + numeroEjercicio + " debe tener exactamente 5 opciones"
            );
        }
    }
}
