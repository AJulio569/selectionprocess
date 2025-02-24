package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nequi.selectionprocess.selectionprocess.entity.RoleIdEntity;
import com.nequi.selectionprocess.selectionprocess.repository.RoleIdRepository;

/**
 * RoleIdService es una clase de servicio que maneja la lógica de negocios relacionada con la entidad RoleId.
 * Está anotada con 
 * @Service para indicar que es un componente de Spring que contiene la lógica de negocio.
 */
@Service
public class RoleIdService {

    @Autowired
    private RoleIdRepository roleIdRepository;


     /**
     * Obtiene una lista de todos los roles.
     * @return una lista de todos los roles.
     */
    public List<RoleIdEntity> getAllRoleId(){
        return roleIdRepository.findAll();
        
    }

    /**
     * Obtiene un rol por su identificador.
     * @param id el identificador del rol.
     * @return un Optional que contiene el rol si se encuentra, o vacío si no se encuentra.
     */
    public Optional<RoleIdEntity> getByIdRoleId(Integer id){
        return roleIdRepository.findById(id);

    /**
     * Busca roles cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de los roles.
     * @return una lista de roles cuyos nombres contienen la cadena dada.
     */
    }
    // public List<RoleIdEntity> searchByNameRoleId(String name){
    //     return roleIdRepository.findByNameContainingRoleId(name);
    // }

    /**
     * Guarda un rol en la base de datos 
     * @param roleId el rol a guardar.
     * @return el rol guardado.
     */
    public RoleIdEntity saveRoleId(RoleIdEntity roleId){
        return roleIdRepository.save(roleId);
    }

    /**
     * Elimina un rol de la base de datos por su identificador.
     * @param id el identificador del rol a eliminar.
     */
    public void deleteByIdRoleId(Integer id){
        roleIdRepository.deleteById(id);
    }


}
