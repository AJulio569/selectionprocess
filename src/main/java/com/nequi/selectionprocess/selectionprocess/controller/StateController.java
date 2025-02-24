package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nequi.selectionprocess.selectionprocess.entity.StateEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * StateController es una clase controladora que maneja las solicitudes HTTP relacionadas con la entidad State.
 * Está anotada con 
 * @RestController para indicar que es un componente de Spring que gestiona peticiones REST.
 * @RequestMapping ("/api/states") define la ruta base para todas las solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/api/states")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class StateController {

    @Autowired
    private StateService stateService;


    /**
     * Maneja las solicitudes GET para obtener una lista de todos los estados.
     * @return una lista de todos los estados
     */
    @GetMapping
    public List<StateEntity> getMethodAllState() {
        return stateService.getAllState();
    }


      /**
     * Maneja las solicitudes GET para obtener un estado por su identificador.
     * @param id el identificador del estado
     * @return un ResponseEntity con el estado si se encuentra, o un 404 Not Found si no se encuentra
     */
    @GetMapping("/{id}")
    public  ResponseEntity<StateEntity> getMethodByIdState(@PathVariable Integer id) {

        return stateService.getByIdState(id)
                           .map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes POST para guardar uno o varios estados.
     * @param states la lista de estados a guardar
     * @return la lista de estados guardados
     */
    @PostMapping
    public List<StateEntity> postMethodSaveState(@RequestBody List<StateEntity> state) {
        
        
        return stateService.saveState(state);
    }



    /**
     * Maneja las solicitudes PUT para actualizar un estado por su identificador.
     * @param id el identificador del estado a actualizar
     * @param state el estado a actualizar
     * @return el estado actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<StateEntity> putMethodUpdateState(@PathVariable Integer id, @RequestBody StateEntity state) {
        return stateService.updateState(id, state)
                           .map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Maneja las solicitudes DELETE para eliminar un estado por su identificador.
     * @param id el identificador del estado a eliminar
     * @return un ResponseEntity con un código de estado 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethodByIdState(@PathVariable Integer id){
        stateService.deleteByIdState(id);
        return ResponseEntity.noContent().build();
    }
    
    

}
