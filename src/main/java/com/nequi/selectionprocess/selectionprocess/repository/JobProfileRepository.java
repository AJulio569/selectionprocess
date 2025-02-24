package com.nequi.selectionprocess.selectionprocess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.JobProfileEntity;


/**
 * JobProfileRepository es una interfaz de repositorio para la entidad
 * JobProfile.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de
 * consulta personalizados.
 * Está anotada con
 * 
 * @Repository para indicar que es un componente de Spring que interactúa con la
 *             base de datos.
 */
@Repository
public interface JobProfileRepository extends JpaRepository<JobProfileEntity, Integer> {

     /**
      * Busca una lista de estados que coincidan parcialmente con el nombre
      * proporcionado.
      * Utiliza una consulta JPQL para buscar coincidencias en el nombre de los
      * estados.
      *
      * @param name el nombre parcial para buscar coincidencias
      * @return una lista de objetos `StateEntity` que coinciden con el nombre
      *         parcial proporcionado
      */
     @Query("select s from JobProfileEntity s where s.name like %:name%") // Buscar por una coicidencia en el nombre
     List<JobProfileEntity> findOneNameLikeJobProfile(String name);

}
