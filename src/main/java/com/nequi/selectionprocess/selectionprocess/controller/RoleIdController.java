package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.entity.RoleIdEntity;

import com.nequi.selectionprocess.selectionprocess.service.RoleIdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RoleIdController es una clase controladora que maneja las solicitudes HTTP
 * relacionadas con la entidad RoleId.
 * Está anotada con
 * 
 * @RestController para indicar que es un componente de Spring que gestiona
 *                 peticiones REST.
 * @RequestMapping ("/api/roles") define la ruta base para todas las solicitudes
 *                 manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class RoleIdController {

    @Autowired
    private RoleIdService roleIdService;

    /**
     * Maneja las solicitudes GET para obtener una lista de todos los roles.
     * 
     * @return una lista de todos los roles
     */
    @GetMapping
    public List<RoleIdEntity> getMethodAllRoleId() {
        return roleIdService.getAllRoleId();
    }
    

    /**
     * Maneja las solicitudes GET para obtener un rol por su identificador.
     * 
     * @param id el identificador del rol
     * @return un ResponseEntity con el rol si se encuentra, o un 404 Not Found si
     *         no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoleIdEntity> getMethodByIdRoleId(@PathVariable Integer id) {
        return roleIdService.getByIdRoleId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Maneja las solicitudes POST para guardar un nuevo rol.
     * 
     * @param roleId el rol a guardar
     * @return el rol guardado
     */
    @PostMapping
    public RoleIdEntity postMethodSaveRoleId(@RequestBody RoleIdEntity roleId) {

        return roleIdService.saveRoleId(roleId);
    }


    /**
     * Actualiza la información de un rol existente mediante una solicitud HTTP PUT.
     *
     * @param id  El ID del rol a actualizar.
     * @param rol La entidad RoleIdEntity con la información actualizada del rol.
     * @return Un ResponseEntity con la entidad RoleIdEntity actualizada si se
     *         encontró el rol con el ID especificado,
     *         o un ResponseEntity con estado 404 (Not Found) si no se encuentra un
     *         rol con el ID especificado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RoleIdEntity> putMethodUpdateState(@PathVariable Integer id, @RequestBody RoleIdEntity rol) {
        return roleIdService.updateRoleId(id, rol)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Maneja las solicitudes DELETE para eliminar un rol por su identificador.
     * 
     * @param id el identificador del rol a eliminar
     * @return un ResponseEntity con un código de estado 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethodByIdRoleId(@PathVariable Integer id) {
        roleIdService.deleteByIdRoleId(id);
        return ResponseEntity.noContent().build();

    }

}
