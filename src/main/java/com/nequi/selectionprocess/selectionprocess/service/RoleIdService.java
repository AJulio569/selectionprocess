package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nequi.selectionprocess.selectionprocess.entity.RoleIdEntity;

import com.nequi.selectionprocess.selectionprocess.repository.RoleIdRepository;

/**
 * RoleIdService es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad RoleId.
 * Está anotada con
 * 
 * @Service para indicar que es un componente de Spring que contiene la lógica
 *          de negocio.
 */
@Service
public class RoleIdService {

    @Autowired
    private RoleIdRepository roleIdRepository;

    /**
     * Obtiene una lista de todos los roles.
     * 
     * @return una lista de todos los roles.
     */
    public List<RoleIdEntity> getAllRoleId() {
        return roleIdRepository.findAll();

    }

    /**
     * Obtiene un rol por su identificador.
     * 
     * @param id el identificador del rol.
     * @return un Optional que contiene el rol si se encuentra, o vacío si no se
     *         encuentra.
     */
    public Optional<RoleIdEntity> getByIdRoleId(Integer id) {
        return roleIdRepository.findById(id);

    }

    /**
     * Busca roles cuyos nombres coincidan parcialmente con el valor proporcionado.
     *
     * @param name El ID o parte del ID para buscar coincidencias.
     * @return Una lista de entidades RoleIdEntity que coinciden parcialmente con el
     *         ID especificado.
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     */
    public List<RoleIdEntity> getByNameLikeRoleId(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser nulo ni estar vacó");

        } else {

            return roleIdRepository.findOneNameLikeRoleId(name);
        }

    }

    /**
     * Guarda un rol en la base de datos
     * 
     * @param roleId el rol a guardar.
     * @return el rol guardado.
     */
    public RoleIdEntity saveRoleId(RoleIdEntity roleId) {
        return roleIdRepository.save(roleId);
    }

    /**
     * Actualiza la información de un rol existente en el repositorio.
     *
     * @param id  El ID del rol a actualizar.
     * @param rol La entidad RoleIdEntity con la información actualizada del rol.
     * @return Un Optional que contiene la entidad RoleIdEntity actualizada, si se
     *         encontró un rol con el ID especificado.
     *         Si no se encuentra un rol con el ID especificado, se retorna un
     *         Optional vacío.
     */

    public Optional<RoleIdEntity> updateRoleId(Integer id, RoleIdEntity rol) {
        return roleIdRepository.findById(id)
                .map(existingRoleId -> {
                    existingRoleId.setRoleId(rol.getRoleId());
                    // Otros campos a actualizar
                    return roleIdRepository.save(existingRoleId);
                });
    }

    /**
     * Elimina un rol de la base de datos por su identificador.
     * 
     * @param id el identificador del rol a eliminar.
     */
    public void deleteByIdRoleId(Integer id) {
        roleIdRepository.deleteById(id);
    }

}
