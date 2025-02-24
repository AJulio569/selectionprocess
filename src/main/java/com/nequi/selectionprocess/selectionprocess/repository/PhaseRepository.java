package com.nequi.selectionprocess.selectionprocess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.PhaseEntity;

/**
 * PhaseRepository es una interfaz de repositorio para la entidad Phase.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de
 * consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que
 * interactúa con la base de datos.
 */
@Repository
public interface PhaseRepository extends JpaRepository<PhaseEntity, Integer> {

    /**
     * Busca fases cuyo nombre coincida parcialmente con el valor proporcionado.
     *
     * @param name El nombre o parte del nombre para buscar coincidencias.
     * @return Una lista de entidades PhaseEntity que coinciden parcialmente con el
     *         nombre especificado.
     */
    @Query("select p from PhaseEntity p where p.name like %:name%") // Buscar por una coicidencia en el nombre
    List<PhaseEntity> findOneNameLikePhase(String name);

}
