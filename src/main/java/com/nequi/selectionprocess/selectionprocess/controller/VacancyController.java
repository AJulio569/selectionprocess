package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.entity.VacancyEntity;
import com.nequi.selectionprocess.selectionprocess.service.VacancyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




/**
 * VacancyController es una clase controladora que maneja las solicitudes HTTP relacionadas con la entidad Vacancy.
 * Está anotada con 
 * @RestController para indicar que es un componente de Spring que gestiona peticiones REST.
 * @RequestMapping ("/id/vacanacies") define la ruta base para todas las solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/id/vacanacies")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class VacancyController {


    @Autowired
    private VacancyService vacancyService;


    /**
     * Maneja las solicitudes GET para obtener una lista de todas las vacantes.
     * @return una lista de todas las vacantes
     */
    @GetMapping
    public List<VacancyEntity> getMethodAllVacancy() {
        return vacancyService.getAllVacancy();
    }


    /**
     * Maneja las solicitudes GET para obtener una vacante por su identificador.
     * @param id el identificador de la vacante
     * @return un ResponseEntity con la vacante si se encuentra, o un 404 Not Found si no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<VacancyEntity> getMethodByIdVacancy(@PathVariable Integer id) {
        return vacancyService.getByIdVacancy(id)
                              .map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.notFound().build());
    }


     /**
     * Maneja las solicitudes POST para guardar una nueva vacante.
     * @param vacancy la vacante a guardar
     * @return la vacante guardada
     */
    @PostMapping
    public VacancyEntity postMethodSaveVacancy(@RequestBody VacancyEntity vacancy) {
        
        
        return vacancyService.saveVacancy(vacancy);
    }



    /**
     * Maneja las solicitudes DELETE para eliminar una vacante por su identificador.
     * @param id el identificador de la vacante a eliminar
     * @return un ResponseEntity con un código de estado 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethodByIdVacancy(@PathVariable Integer id){
         vacancyService.deleteByIdVacancy(id);
         return ResponseEntity.noContent().build();
    }
    
    
    

}
