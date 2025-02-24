package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.PhaseEntity;
import com.nequi.selectionprocess.selectionprocess.repository.PhaseRepository;

/**
 * PhaseService es una clase de servicio que maneja la lógica de negocios relacionada con la entidad Phase.
 * Está anotada con 
 * @Service para indicar que es un componente de Spring que contiene la lógica de negocio.
 */
@Service
public class PhaseService {

    @Autowired
    private PhaseRepository phaseRepository;

    /**
     * Obtiene una lista de todas las fases.
     * @return una lista de todas las fases.
     */
    public List<PhaseEntity> getAllPhase(){
        return phaseRepository.findAll();
        
    }

     /**
     * Obtiene una fase por su identificador.
     * @param id el identificador de la fase.
     * @return un Optional que contiene la fase si se encuentra, o vacío si no se encuentra.
     */
    public Optional<PhaseEntity> getByIdPhase(Integer id){
        return phaseRepository.findById(id);
    }


    /**
     * Busca fases cuyos nombres contienen la cadena especificada.
     * @param name la cadena a buscar en los nombres de las fases.
     * @return una lista de fases cuyos nombres contienen la cadena dada.
     */
    // public List<PhaseEntity> searchByNamePhase(String name){
    //     return phaseRepository.findByNameContainingPhase(name);
    // }

     /**
     * Guarda una fase en la base de datos.
     * @param phase la fase a guardar.
     * @return la fase guardada.
     */
    public PhaseEntity savePhase(PhaseEntity phase){
        return phaseRepository.save(phase);
    }

    /**
     * Elimina una fase de la base de datos por su identificador.
     * @param id el identificador de la fase a eliminar.
     */
    public void deleteByIdPhase(Integer id){
         phaseRepository.deleteById(id);
    }

}
