package com.nequi.selectionprocess.selectionprocess.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nequi.selectionprocess.selectionprocess.entity.CandidateEntity;
import com.nequi.selectionprocess.selectionprocess.service.CandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * CandidateController es una clase controladora que maneja las solicitudes HTTP relacionadas con la entidad Candidate.
 * Está anotada con 
 * @RestController para indicar que es un componente de Spring que gestiona peticiones REST.
 * @RequestMapping ("/api/candidates") define la ruta base para todas las solicitudes manejadas por esta clase.
 * @CrossOrigin(origins = "*") permite llamadas desde cualquier frontend.
 */
@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class CandidateController {


    @Autowired
    private CandidateService candidateService;

    
    /**
     * Maneja las solicitudes GET para obtener una lista de todos los candidatos.
     * @return una lista de todos los candidatos.
     */
    @GetMapping
    public List<CandidateEntity> getMethodAllCandidate() {

         return candidateService.getAllCandidate();
    }

    /**
     * Maneja las solicitudes GET para obtener un candidato por su identificador.
     * @param id el identificador del candidato.
     * @return un ResponseEntity con el candidato si se encuentra, o un 404 Not Found si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CandidateEntity> getMethodByIdCandidate(@PathVariable Integer id) {

        Optional<CandidateEntity> candidateOptional = candidateService.getByIdCandidate(id);

        return candidateOptional.map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * Maneja las solicitudes GET para buscar candidatos por nombre.
     * @param name la cadena a buscar en los nombres de los candidatos.
     * @return una lista de candidatos cuyos nombres contienen la cadena dada.
     */
    // @GetMapping("/search")
    // public List<CandidateEntity> getMethodSearchByNameCandidate(@RequestParam String name) {
    //     return candidateService.searchByNameCandidate(name);
    // }

     
    /**
     * Maneja las solicitudes POST para guardar un nuevo candidato.
     * @param candidate el candidato a guardar.
     * @return el candidato guardado.
     */
    @PostMapping
    public CandidateEntity postMethodSaveCandidate(@RequestBody CandidateEntity candidate) {
        
        return candidateService.saveCandidate(candidate);
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un candidato por su identificador.
     * @param id el identificador del candidato a eliminar.
     * @return un ResponseEntity con un código de estado 204 No Content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetholdByIdCandidate(@PathVariable Integer id){

        candidateService.deleteByIdCandidate(id);

        return ResponseEntity.noContent().build();
    }
    
    
    
    

}
