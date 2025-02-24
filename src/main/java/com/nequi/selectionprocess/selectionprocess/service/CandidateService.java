package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.CandidateEntity;
import com.nequi.selectionprocess.selectionprocess.repository.CandidateRepository;

/**
 * CandidateService es una clase de servicio que maneja la lógica de negocios relacionada con la entidad Candidate.
 * Está anotada con 
 * @Service para indicar que es un componente de Spring que contiene la lógica de negocio.
 */
@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;


    /**
     * Obtiene una lista de todos los candidatos.
     * @return una lista de todos los candidatos.
     */
    public List<CandidateEntity> getAllCandidate(){
         return candidateRepository.findAll();
    }

    /**
     * Obtiene un candidato por su identificador.
     * @param id el identificador del candidato.
     * @return un Optional que contiene el candidato si se encuentra, o vacío si no se encuentra.
     */
    public Optional<CandidateEntity> getByIdCandidate(Integer id){
         return candidateRepository.findById(id);
    }

    /**
     * Busca candidatos cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de los candidatos.
     * @return una lista de candidatos cuyos nombres contienen la cadena dada.
     */
    // public List<CandidateEntity> searchByNameCandidate(String name){
    //     return candidateRepository.findByNameContainingCandidate(name);
    // }

    /**
     * Guarda un candidato en la base de datos.
     * @param candidate el candidato a guardar.
     * @return el candidato guardado.
     */
    public CandidateEntity saveCandidate(CandidateEntity candidate){
        return candidateRepository.save(candidate);
    }

    /**
     * Elimina un candidato de la base de datos por su identificador.
     * @param id el identificador del candidato a eliminar.
     */
    public void deleteByIdCandidate(Integer id){
        candidateRepository.deleteById(id);
    }

}
