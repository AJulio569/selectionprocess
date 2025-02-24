package com.nequi.selectionprocess.selectionprocess.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.OriginEntity;

/**
 * OriginRepository es una interfaz de repositorio para la entidad Origen.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con 
 * @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface OriginRepository  extends JpaRepository<OriginEntity,Integer>{

   

     /**
     * Busca orígenes cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de los orígenes.
     * @return una lista de orígenes cuyos nombres contienen la cadena dada.
     */
      @Query("select o from OriginEntity o where o.name like %:name%")//Buscar por una coicidencia en el nombre
      List<OriginEntity> findOneNameLikeOrigin(String name);


}
