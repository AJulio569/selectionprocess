package com.nequi.selectionprocess.selectionprocess.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Representa la tabla de procesos en la base de datos.
 * La clase está anotada con 
 * @Entity , lo que indica que es una entidad JPA.
 * @Table se usa para especificar la tabla en la base de datos asociada a esta entidad.
 * Las anotaciones 
 * @Data y 
 * @AllArgsConstructor son de Lombok y generan automáticamente 
 * los métodos getters, setters, toString, equals, hashCode y el constructor con todos los campos.
 * La anotación 
 * @NoArgsConstructor se utiliza para generar automáticamente un constructor sin argumentos.
 */
@Entity
@Table(name = "process")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessEntity {
 
    /**
     * El campo 'id' es el identificador único de la entidad.
     * Se genera automáticamente con la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_process")
    private Integer idProcess;

    
    /**
     * El campo 'fecha' representa la fecha del proceso.
     * No puede ser nulo.
     */
    @Column(name = "presentation_date", nullable = false)
    private Date presentationDate;

    /**
     * El campo 'descripcion' representa la descripción del proceso.
     * Se almacena como un texto largo (columnDefinition = "TEXT").
     */
    @Column(columnDefinition = "TEXT")
    private String description;

     /**
     * El campo 'estado' indica si el proceso está activo o no.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private Boolean state;

     /**
     * El campo 'candidato' representa la relación muchos-a-uno con la entidad Candidato.
     * La clave externa se almacena en la columna 'candidatos_id' en la tabla de procesos.
     */
    @ManyToOne
    @JoinColumn(name = "candidate_id_candidate")
    private CandidateEntity candidate;

    /**
     * El campo 'estadoProceso' representa la relación muchos-a-uno con la entidad Estado.
     * La clave externa se almacena en la columna 'estados_id' en la tabla de procesos.
     */
    @ManyToOne
    @JoinColumn(name = "state_id_state")
    private StateEntity stateProcess;

    /**
     * El campo 'fase' representa la relación muchos-a-uno con la entidad Fase.
     * La clave externa se almacena en la columna 'fases_id' en la tabla de procesos.
     */
    @ManyToOne
    @JoinColumn(name = "phase_id_phase")
    private PhaseEntity phase;

}
