package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
@View(members = 
    "Datos de la Opción { ejercicio; letra; esCorrecta };" +
    "Imagen de la Opción { imagen }"
)
@Tab(properties = "letra, esCorrecta, ejercicio.numeroEjercicio, ejercicio.test.nombreTest",
     defaultOrder = "ejercicio.numeroEjercicio asc, letra asc")
public class Opcion {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    @Hidden
    String oid;

    @Column(length = 1)
    @Required
    String letra;
    
    @Files
    @Column(length = 32)
    String imagen;
    
    @Column(length = 1)
    boolean esCorrecta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList(descriptionProperties = "numeroEjercicio, test.nombreTest")
    @Required
    Ejercicio ejercicio;
    
    // Relacion con RespuestaUsuario
    @OneToMany(mappedBy = "opcionSeleccionada")
    Collection<RespuestaUsuario> respuestas;

    public boolean seleccionarRespuesta() {
        return this.esCorrecta;
    }
    
    public boolean verificarSeleccion() {
        return this.esCorrecta;
    }
    
    public String getDescripcion() {
        return "Opción " + letra + " del Ejercicio " + 
               (ejercicio != null ? ejercicio.getNumeroEjercicio() : "?") +
               (esCorrecta ? " (CORRECTA)" : "");
    }
    
    @PrePersist
    @PreUpdate
    public void validarLetra() {
        if (letra == null || letra.isEmpty()) {
            throw new IllegalStateException("La letra de la opción es obligatoria");
        }
        String letraUpper = letra.toUpperCase();
        if (!letraUpper.matches("[A-E]")) {
            throw new IllegalStateException(
                "La letra debe ser A, B, C, D o E. Valor recibido: " + letra
            );
        }
        this.letra = letraUpper;
    }
}
