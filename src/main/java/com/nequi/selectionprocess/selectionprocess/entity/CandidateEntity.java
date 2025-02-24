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
 * Representa la tabla de candidatos en la base de datos.
 * La clase está anotada con
 * @Entity , lo que indica que es una entidad JPA.
 * @Table se usa para especificar la tabla en la base de datos asociada a esta entidad.
 * Las anotaciones
 * @Data y
 * @AllArgsConstructor son de Lombok y generan automáticamente
 * los métodos getters, setters, toString, equals, hashCode
 * y el constructor con todos los campos.
 * La anotación 
 * @NoArgsConstructor se utiliza para generar automáticamente un constructor sin argumentos.
 */
@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEntity {

    /**
     * El campo 'id' es el identificador único de la entidad.
     * Se genera automáticamente con la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_candidate")
    private Integer idCandidate;

    /**
     * El campo 'nombre' representa el nombre del candidato.
     * Tiene una longitud máxima de 100 caracteres y no puede ser nulo.
     */
    @Column(length = 100, nullable = false)
    private String name;

    /**
     * El campo 'cedula' representa la cédula (número de identificación) del
     * candidato.
     * No puede ser nulo y debe ser único.
     */
    @Column(name="id_card", nullable = false, unique = true)
    private Integer idCard;

    /**
     * El campo 'fechaNacimiento' representa la fecha de nacimiento del candidato.
     * Se almacena en la columna 'fecha_nacimiento' de la tabla en la base de datos.
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * El campo 'correo' representa el correo electrónico del candidato.
     * Tiene una longitud máxima de 150 caracteres.
     */
    @Column(length = 150)
    private String email;

    /**
     * El campo 'ciudad' representa la ciudad de residencia del candidato.
     * Tiene una longitud máxima de 100 caracteres.
     */
    @Column(length = 100)
    private String city;

    /**
     * El campo 'origen' representa la relación muchos-a-uno con la entidad Origen.
     * La clave externa se almacena en la columna 'origen_id' en la tabla de
     * candidatos.
     */
    @ManyToOne
    @JoinColumn(name = "origin_id_origin")
    private OriginEntity origin;

    /**
     * El campo 'vacante' representa la relación muchos-a-uno con la entidad
     * Vacante.
     * La clave externa se almacena en la columna 'vacante_id' en la tabla de
     * candidatos.
     */
    @ManyToOne
    @JoinColumn(name = "vacancy_id_vacancy")
    private VacancyEntity vacancy;

}
