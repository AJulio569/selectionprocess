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
 * Representa la tabla de roles en la base de datos.
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
@Table(name = "role_id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleIdEntity {


     /**
     * El campo 'id' es el identificador único de la entidad.
     * Se genera automáticamente con la estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRoleId;
    

    /**
     * El campo 'rileId' representa el identificador del rol.
     * Se almacena en la columna 'role_id' de la tabla y puede contener valores duplicados.
     * La longitud máxima del nombre es de 25 caracteres y no puede ser nulo.
     */
    @Column(name = "role_id",length = 25, nullable = false)
    private String roleId;


}
