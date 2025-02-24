package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.selectionprocess.selectionprocess.entity.JobProfileEntity;
import com.nequi.selectionprocess.selectionprocess.service.JobProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * JobProfileController es una clase controladora que maneja las solicitudes
 * HTTP relacionadas con la entidad JobProfile.
 * Está anotada con
 * 
 * @RestController para indicar que es un componente de Spring que gestiona
 *                 peticiones REST.
 * @RequestMapping ("/api/vacancies") define la ruta base para todas las
 *                 solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/api/jobprofiles")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class JobProfileController {

    @Autowired
    private JobProfileService jobProfileService;

    /**
     * Maneja las solicitudes GET para obtener una lista de todos los perfiles de
     * trabajo.
     * 
     * @return una lista de todos los perfiles de trabajo.
     */
    @GetMapping
    public List<JobProfileEntity> getMethodAllJobProfile() {
        return jobProfileService.getAllJobProfile();
    }

    /**
     * Maneja las solicitudes GET para obtener un perfil de trabajo por su
     * identificador.
     * 
     * @param id el identificador del perfil de trabajo.
     * @return un ResponseEntity con el perfil de trabajo si se encuentra, o un 404
     *         Not Found si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<JobProfileEntity> getMethoByIdJobProfile(@PathVariable Integer id) {

        Optional<JobProfileEntity> jobProfileOptional = jobProfileService.getByIdJobProfile(id);

        return jobProfileOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes POST para guardar una lista de perfiles de trabajo.
     * Cada objeto `JobProfileEntity` en la lista proporcionada se guardará en la
     * base de datos.
     *
     * @param jobProfile la lista de objetos `JobProfileEntity` a guardar
     * @return una lista de objetos `JobProfileEntity` que han sido guardados
     */
    @PostMapping
    public List<JobProfileEntity> postMethodSaveJobProfile(@RequestBody List<JobProfileEntity> jobProfile) {

        return jobProfileService.saveJobProfile(jobProfile);
    }

    /**
     * Maneja las solicitudes PUT para actualizar un perfil de trabajo por su
     * identificador.
     * Busca un perfil de trabajo por su identificador y, si se encuentra,
     * actualiza sus campos con los valores proporcionados en el objeto
     * `jobProfile`.
     *
     * @param id         el identificador del perfil de trabajo a actualizar
     * @param jobProfile el objeto `JobProfileEntity` que contiene los nuevos
     *                   valores de los campos
     * @return un `ResponseEntity` con el perfil de trabajo actualizado si se
     *         encuentra, o un `404 Not Found` si no se encuentra el perfil de
     *         trabajo con el identificador proporcionado
     */
    @PutMapping("/{id}")
    public ResponseEntity<JobProfileEntity> putMethodUpdateState(@PathVariable Integer id,
            @RequestBody JobProfileEntity jobProfile) {
        return jobProfileService.updateJobProfile(id, jobProfile)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un perfil de trabajo por su
     * identificador.
     * 
     * @param id el identificador del perfil de trabajo a eliminar.
     * @return un ResponseEntity con un código de estado 204 No Content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethodByIdJobProfile(@PathVariable Integer id) {
        jobProfileService.deleteByIdJobProfile(id);
        return ResponseEntity.noContent().build();
    }

}
