package com.nequi.selectionprocess.selectionprocess.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.nequi.selectionprocess.selectionprocess.entity.CandidateEntity;
/**
 * CandidateRepository es una interfaz de repositorio para la entidad Candidato.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con 
 * @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity,Integer> {

     /**
     * Busca candidatos cuyo nombre contiene la cadena especificada.
     * @param nombre la cadena a buscar en los nombres de los candidatos.
     * @return una lista de candidatos cuyos nombres contienen la cadena dada.
     */
    // @Query("select c from CandidateEntity c where c.name like %?1%")//Buscar por una coicidencia en el nombre
    // List<CandidateEntity> findByNameContainingCandidate(String name);


    /**
     * Busca candidatos  cuyos identificadores contienen el valor especificado.
     * @param id el valor a buscar en los identificadores de los candidatos.
     * @return una lista de candidatos cuyos identificadores contienen el valor dado.
     */
    // List<CandidateEntity> findByIdContainingCandidate(Integer id);
 
}
