package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.entity.ProcessEntity;

import com.nequi.selectionprocess.selectionprocess.service.ProcesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ProcesController es una clase controladora que maneja las solicitudes HTTP
 * relacionadas con la entidad Proces.
 * Está anotada con
 * 
 * @RestController para indicar que es un componente de Spring que gestiona
 *                 peticiones REST.
 * @RequestMapping ("/api/processes") define la ruta base para todas las
 *                 solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/api/processes")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class ProcesController {

    @Autowired
    private ProcesService procesService;

    /**
     * Maneja las solicitudes GET para obtener una lista de todos los procesos.
     * 
     * @return una lista de todos los procesos
     */
    @GetMapping
    public List<ProcessEntity> getMethodAllProces() {
        return procesService.getAllProces();
    }

    /**
     * Maneja las solicitudes GET para obtener un proceso por su identificador.
     * 
     * @param id el identificador del proceso
     * @return un ResponseEntity con el proceso si se encuentra, o un 404 Not Found
     *         si no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProcessEntity> getMethodByIdProces(@PathVariable Integer id) {
        return procesService.getByIdProces(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes POST para guardar un nuevo proceso.
     * 
     * @param proces el proceso a guardar
     * @return el proceso guardado
     */
    @PostMapping
    public ProcessEntity postMethodSaveProces(@RequestBody ProcessEntity proces) {

        return procesService.saveProces(proces);
    }

    /**
     * Actualiza la información de un proceso existente mediante una solicitud HTTP
     * PUT.
     *
     * @param id       El ID del proceso a actualizar.
     * @param processE La entidad ProcessEntity con la información actualizada del
     *                 proceso.
     * @return Un ResponseEntity con la entidad ProcessEntity actualizada si se
     *         encontró el proceso con el ID especificado,
     *         o un ResponseEntity con estado 404 (Not Found) si no se encuentra un
     *         proceso con el ID especificado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProcessEntity> putMethodUpdateProcess(@PathVariable Integer id,
            @RequestBody ProcessEntity processE) {
        return procesService.updateProcess(id, processE)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un proceso por su identificador.
     * 
     * @param id el identificador del proceso a eliminar
     * @return un ResponseEntity con un código de estado 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethodByIdProces(@PathVariable Integer id) {
        procesService.deleteByIdProces(id);
        return ResponseEntity.noContent().build();
    }

}
