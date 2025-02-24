package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.entity.PhaseEntity;

import com.nequi.selectionprocess.selectionprocess.service.PhaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * OriginController es una clase controladora que maneja las solicitudes HTTP
 * relacionadas con la entidad Phase.
 * Está anotada con
 * 
 * @RestController para indicar que es un componente de Spring que gestiona
 *                 peticiones REST.
 * @RequestMapping ("/api/phases") define la ruta base para todas las
 *                 solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/api/phases")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    /**
     * Maneja las solicitudes GET para obtener una lista de todas las fases.
     * 
     * @return una lista de todas las fases
     */
    @GetMapping
    public List<PhaseEntity> getMethodAllPhase() {
        return phaseService.getAllPhase();
    }

    /**
     * Maneja las solicitudes GET para obtener una fase por su identificador.
     * 
     * @param id el identificador de la fase
     * @return un ResponseEntity con la fase si se encuentra, o un 404 Not Found si
     *         no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<PhaseEntity> getMethodByIdPhase(@PathVariable Integer id) {
        return phaseService.getByIdPhase(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes POST para guardar una nueva fase.
     * 
     * @param phase la fase a guardar
     * @return la fase guardada
     */
    @PostMapping
    public PhaseEntity postMethodSavePhase(@RequestBody PhaseEntity phase) {

        return phaseService.savePhase(phase);
    }

    /**
     * Actualiza la información de una fase existente mediante una solicitud HTTP
     * PUT.
     *
     * @param id    El ID de la fase a actualizar.
     * @param phase La entidad PhaseEntity con la información actualizada de la
     *              fase.
     * @return Un ResponseEntity con la entidad PhaseEntity actualizada si se
     *         encontró la fase con el ID especificado,
     *         o un ResponseEntity con estado 404 (Not Found) si no se encuentra una
     *         fase con el ID especificado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PhaseEntity> putMethodUpdatePhase(@PathVariable Integer id, @RequestBody PhaseEntity phase) {
        return phaseService.updatePhase(id, phase)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes DELETE para eliminar una fase por su identificador.
     * 
     * @param id el identificador de la fase a eliminar
     * @return un ResponseEntity con un código de estado 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethodByIdPhase(@PathVariable Integer id) {
        phaseService.deleteByIdPhase(id);
        return ResponseEntity.noContent().build();
    }

}
