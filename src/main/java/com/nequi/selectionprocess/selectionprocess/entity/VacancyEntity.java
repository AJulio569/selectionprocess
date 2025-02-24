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
import lombok.NoArgsConstructor;
/**
 * Representa la tabla de vacantes en la base de datos.
 * La clase está anotada con 
 * @Entity , lo que indica que es una entidad JPA.
 * @Table se usa  para especificar la tabla en la base de datos asociada a esta entidad.
 * La anotación 
 * @AllArgsConstructor es de Lombok y genera automáticamente el 
 * La anotación 
 * @NoArgsConstructor se utiliza para generar automáticamente un constructor sin argumentos.
 * constructor con todos los campos.
 */
@Entity
@Table(name = "vacancy")
@AllArgsConstructor
@NoArgsConstructor
public class VacancyEntity {
    
    /**
     * El campo 'id' es el identificador único de la entidad.
     * Se genera automáticamente con la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vacancy")
    private Integer idVacancy;

    /**
     * El campo 'fechaPresentacion' representa la fecha de presentación de la vacante.
     */
    @Column(name = "presentation_date")
    private Date presentationDate;

    /**
     * El campo 'salarioActual' representa el salario actual del candidato.
     * Tiene una longitud máxima de 100 caracteres.
     */
    @Column(name ="current_salary", length = 100 )
    private String currentSalary;

    /**
     * El campo 'aspiracionSalarial' representa la aspiración salarial del candidato.
     * Tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "salary_expectation",length = 100)
    private String salaryExpectation;

    /**
     * El campo 'experiencia' representa la experiencia del candidato.
     * Tiene una longitud máxima de 50 caracteres.
     */
    @Column(length = 50)
    private String experience;

     /**
     * El campo 'level' representa el nivel del candidato.
     * Tiene una longitud máxima de 50 caracteres.
     */
    @Column(length = 50)
    private String level;

    /**
     * El campo 'skill' representa las habilidades del candidato.
     * Se almacena como un texto largo (columnDefinition = "TEXT").
     */
    @Column(columnDefinition = "TEXT")
    private String skill;

    /**
     * El campo 'contrato' representa el tipo de contrato deseado.
     * Tiene una longitud máxima de 50 caracteres.
     */
    @Column(length = 50)
    private String contract;

    /**
     * El campo 'role' representa la relación muchos-a-uno con la entidad RolId.
     * La clave externa se almacena en la columna 'role_id_id' en la tabla de vacantes.
     */
    @ManyToOne
    @JoinColumn(name ="role_id_id_role")
    private RoleIdEntity role;

    /**
     * El campo 'jobProfile' representa la relación muchos-a-uno con la entidad JobProfile.
     * La clave externa se almacena en la columna 'job_profile_id' en la tabla de vacantes.
     */
    @ManyToOne
    @JoinColumn(name = "job_profile_id_job_profile")
    private JobProfileEntity jobProfile;




}
