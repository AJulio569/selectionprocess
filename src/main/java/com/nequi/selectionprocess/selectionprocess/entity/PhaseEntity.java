package com.nequi.selectionprocess.selectionprocess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la tabla de fases en la base de datos.
 * La clase está anotada con 
 * @Entity , lo que indica que es una entidad JPA.
 * @Table se usa  para especificar la tabla en la base de datos asociada a esta entidad.
 * Las anotaciones 
 * @Data y 
 * @AllArgsConstructor son de Lombok y generan automáticamente 
 * los métodos getters, setters, toString, equals, hashCode y el constructor con todos los campos.
 * La anotación 
 * @NoArgsConstructor se utiliza para generar automáticamente un constructor sin argumentos.
 */
@Entity
@Table(name = "phase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhaseEntity {


     /**
     * El campo 'id' es el identificador único de la entidad.
     * Se genera automáticamente con la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phase")
    private Integer idPhase;

     /**
     * El campo 'nombre' representa el nombre de la fase.
     * Tiene una longitud máxima de 100 caracteres y no puede ser nulo.
     */
    @Column(length = 100, nullable = false)
    private String name;
}
