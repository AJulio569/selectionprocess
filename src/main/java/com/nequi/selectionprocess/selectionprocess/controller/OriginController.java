package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.entity.OriginEntity;

import com.nequi.selectionprocess.selectionprocess.service.OriginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * OriginController es una clase controladora que maneja las solicitudes HTTP
 * relacionadas con la entidad Origin.
 * Está anotada con
 * 
 * @RestController para indicar que es un componente de Spring que gestiona
 *                 peticiones REST.
 * @RequestMapping ("/id/origins") define la ruta base para todas las
 *                 solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/api/origins")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class OriginController {

    @Autowired
    private OriginService originService;

    /**
     * Maneja las solicitudes GET para obtener una lista de todos los orígenes.
     * 
     * @return una lista de todos los orígenes.
     */
    @GetMapping
    public List<OriginEntity> getMethodAllOrigin() {
        return originService.getAllOrigin();
    }

    /**
     * Maneja las solicitudes GET para obtener un origen por su identificador.
     * 
     * @param id el identificador del origen.
     * @return un ResponseEntity con el origen si se encuentra, o un 404 Not Found
     *         si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OriginEntity> getMethodByIdOrigin(@PathVariable Integer id) {

        Optional<OriginEntity> origOptional = originService.getByIdOrigin(id);

        return origOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * Maneja las solicitudes POST para guardar una lista de orígenes.
     * Cada objeto `OriginEntity` en la lista proporcionada se guardará en la base
     * de datos.
     *
     * @param origin la lista de objetos `OriginEntity` a guardar
     * @return una lista de objetos `OriginEntity` que han sido guardados
     */
    @PostMapping
    public List<OriginEntity> postMethodSaveOrigin(@RequestBody List<OriginEntity> origin) {

        return originService.saveOrigin(origin);
    }

    /**
     * Maneja las solicitudes PUT para actualizar un origen por su identificador.
     * Busca un origen por su identificador y, si se encuentra,
     * actualiza sus campos con los valores proporcionados en el objeto `state`.
     *
     * @param id     el identificador del origen a actualizar
     * @param origin el objeto `OriginEntity` que contiene los nuevos valores de los
     *               campos
     * @return un `ResponseEntity` con el origen actualizado si se encuentra, o un
     *         `404 Not Found` si no se encuentra el origen con el identificador
     *         proporcionado
     */
    @PutMapping("/{id}")
    public ResponseEntity<OriginEntity> putMethodUpdateOrigin(@PathVariable Integer id,
            @RequestBody OriginEntity origin) {
        return originService.updateOrigin(id, origin)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un origen por su identificador.
     * 
     * @param id el identificador del origen a eliminar.
     * @return un ResponseEntity con un código de estado 204 No Content.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMethodByIdOrigin(@PathVariable Integer id) {
        originService.deleteByIdOrigin(id);
        return ResponseEntity.noContent().build();
    }

}
