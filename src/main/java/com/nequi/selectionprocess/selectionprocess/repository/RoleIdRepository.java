package com.nequi.selectionprocess.selectionprocess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.RoleIdEntity;

/**
 * RoleIdRepository es una interfaz de repositorio para la entidad RoleId.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de
 * consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que
 * interactúa con la base de datos.
 */
@Repository
public interface RoleIdRepository extends JpaRepository<RoleIdEntity, Integer> {

    /**
     * Busca roles cuyo ID coincida parcialmente con el valor proporcionado.
     *
     * @param roleId El ID o parte del ID para buscar coincidencias.
     * @return Una lista de entidades RoleIdEntity que coinciden parcialmente con el
     *         ID especificado.
     */
    @Query("select r from RoleIdEntity r where r.roleId like %:roleId%") // Buscar por una coicidencia en el nombre
    List<RoleIdEntity> findOneNameLikeRoleId(String name);

}
