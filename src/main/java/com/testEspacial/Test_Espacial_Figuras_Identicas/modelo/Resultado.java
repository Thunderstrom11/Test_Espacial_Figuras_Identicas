package com.testEspacial.Test_Espacial_Figuras_Identicas.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;
import java.util.*;

@Entity
@Getter @Setter
@View(members = 
    "Datos del Resultado { test; fecha; };" +
    "Tiempo { horaInicio; horaFin; };" +
    "Puntuación { aciertos; errores; puntajeObtenido }"
)
@Tab(properties = "test.nombreTest, fecha, aciertos, errores, puntajeObtenido",
     defaultOrder = "fecha desc")
public class Resultado {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    @Hidden
    String oid;

    @Column(length = 3)
    int aciertos;
    
    @Column(length = 3)
    int errores;
    
    @Column(length = 3)
    int puntajeObtenido;
    
    @Column(length = 10)
    @DefaultValueCalculator(CurrentDateCalculator.class)
    @Required
    Date fecha;
    
    @Column(length = 20)
    Date horaInicio;
    
    @Column(length = 20)
    Date horaFin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_oid")
    @ReferenceView("Simple")
    Test test;
    
    // Relacion con RespuestaUsuario
    @OneToMany(mappedBy = "resultado")
    Collection<RespuestaUsuario> respuestas;

    // Tabla de puntuación: S1 (aciertos) → Pt (puntaje)
    private static final Map<Integer, Integer> TABLA_PUNTUACION = new LinkedHashMap<>();
    
    static {
        TABLA_PUNTUACION.put(27, 99);
        TABLA_PUNTUACION.put(26, 97);
        TABLA_PUNTUACION.put(25, 95);
        TABLA_PUNTUACION.put(24, 90);
        TABLA_PUNTUACION.put(23, 85);
        TABLA_PUNTUACION.put(22, 85);
        TABLA_PUNTUACION.put(21, 80);
        TABLA_PUNTUACION.put(20, 80);
        TABLA_PUNTUACION.put(19, 75);
        TABLA_PUNTUACION.put(18, 70);
        TABLA_PUNTUACION.put(17, 60);
        TABLA_PUNTUACION.put(16, 55);
        TABLA_PUNTUACION.put(15, 50);
        TABLA_PUNTUACION.put(14, 40);
        TABLA_PUNTUACION.put(13, 30);
        TABLA_PUNTUACION.put(12, 25);
        TABLA_PUNTUACION.put(11, 20);
        TABLA_PUNTUACION.put(10, 15);
        TABLA_PUNTUACION.put(9,  10);
        TABLA_PUNTUACION.put(8,   5);
        TABLA_PUNTUACION.put(7, 1);
        TABLA_PUNTUACION.put(6, 1);
        TABLA_PUNTUACION.put(5, 1);
        TABLA_PUNTUACION.put(4, 1);
        TABLA_PUNTUACION.put(3, 1);
        TABLA_PUNTUACION.put(2, 1);
        TABLA_PUNTUACION.put(1, 1);
        TABLA_PUNTUACION.put(0, 1);
    }

    public int calcularTS() {
        Integer puntaje = TABLA_PUNTUACION.get(this.aciertos);
        if (puntaje != null) {
            this.puntajeObtenido = puntaje;
        } else {
            this.puntajeObtenido = this.aciertos >= 27 ? 99 : 1;
        }
        return this.puntajeObtenido;
    }
    
    public int calcularAciertos() {
        // Implementar con RespuestaUsuario
        return this.aciertos;
    }
    
    public int calcularErrores() {
        // Implementar con RespuestaUsuario
        return this.errores;
    }
    
    public long calcularTiempoTotal() {
        if (horaInicio == null || horaFin == null) return 0;
        return (horaFin.getTime() - horaInicio.getTime()) / 1000;
    }
    
    public static int obtenerPuntaje(int aciertos) {
        Integer puntaje = TABLA_PUNTUACION.get(aciertos);
        return puntaje != null ? puntaje : 1;
    }
    
    public static Map<Integer, Integer> getTablaPuntuacion() {
        return new LinkedHashMap<>(TABLA_PUNTUACION);
    }
    
    public void finalizarResultado() {
        this.horaFin = new Date();
        calcularAciertos();
        calcularErrores();
        calcularTS();
    }
}
