package com.nequi.selectionprocess.selectionprocess.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.PhaseEntity;
/**
 * PhaseRepository es una interfaz de repositorio para la entidad Phase.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface PhaseRepository extends JpaRepository<PhaseEntity,Integer> {

    /**
     * Busca fases cuyos identificadores contienen el valor especificado.
     * @param id el valor a buscar en los identificadores de las fases.
     * @return una lista de fases cuyos identificadores contienen el valor dado.
     */
    // List<PhaseEntity> fingByIdContainingPhase(Integer id);


     /**
     * Busca fases cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de las fases.
     * @return una lista de fases cuyos nombres contienen la cadena dada.
     */
    //  @Query("select p from PhaseEntity p where p.name like %?1%")//Buscar por una coicidencia en el nombre
    //  List<PhaseEntity> findByNameContainingPhase(String name);


}
