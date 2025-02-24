package com.nequi.selectionprocess.selectionprocess.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.RoleIdEntity;

/**
 * RoleIdRepository es una interfaz de repositorio para la entidad RoleId.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface RoleIdRepository extends JpaRepository<RoleIdEntity,Integer>{

    /**
     * Busca roles cuyos identificadores contienen el valor especificado.
     * @param id el valor a buscar en los identificadores de los roles.
     * @return una lista de roles cuyos identificadores contienen el valor dado.
     */
    // List<RoleIdEntity> findByIdContainingRoleId(Integer id);

    /**
     * Busca roles cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de los roles.
     * @return una lista de roles cuyos nombres contienen la cadena dada.
     */
    // @Query("select r from RoleIdEntity r where r.roleId like %?1%")//Buscar por una coicidencia en el nombre
    // List<RoleIdEntity> findByNameContainingRoleId(String roleId);

}
