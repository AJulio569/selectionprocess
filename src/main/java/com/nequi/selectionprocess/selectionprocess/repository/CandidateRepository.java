package com.nequi.selectionprocess.selectionprocess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nequi.selectionprocess.selectionprocess.entity.CandidateEntity;

/**
 * CandidateRepository es una interfaz de repositorio para la entidad Candidato.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de
 * consulta personalizados.
 * Está anotada con
 * 
 * @Repository para indicar que es un componente de Spring que interactúa con la
 *             base de datos.
 */
@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer> {

    /**
     * Busca candidatos cuyo nombre coincida parcialmente con el valor
     * proporcionado.
     *
     * @param name El nombre o parte del nombre para buscar coincidencias.
     * @return Una lista de entidades CandidateEntity que coinciden parcialmente con
     *         el nombre especificado.
     */
    @Query("select c from CandidateEntity c where c.name like %:name%") // Buscar por una coicidencia en el nombre
    List<CandidateEntity> findOneNameLikeCandidate(String name);

}
