package com.nequi.selectionprocess.selectionprocess.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.StateEntity;

/**
 * StateRepository es una interfaz de repositorio para la entidad State.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface StateRepository extends JpaRepository<StateEntity,Integer> {

     /**
     * Busca estados cuyos identificadores contienen el valor especificado.
     * @param id el valor a buscar en los identificadores de los estados.
     * @return una lista de estados cuyos identificadores contienen el valor dado.
     */
    @Query("select s from StateEntity s where s.idState=?1")
    List<StateEntity> findByIdState(Integer idState);

     /**
     * Busca estados cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de los estados.
     * @return una lista de estados cuyos nombres contienen la cadena dada.
     */
      @Query("select s from StateEntity s where s.name like %:name%")//Buscar por una coicidencia en el nombre
      List<StateEntity> findOneNameLikeState(String name);

}
