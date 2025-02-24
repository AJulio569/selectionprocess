package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.ProcessEntity;
import com.nequi.selectionprocess.selectionprocess.repository.ProcesRepository;

/**
 * ProcesService es una clase de servicio que maneja la lógica de negocios relacionada con la entidad Proces.
 * Está anotada con 
 * @Service para indicar que es un componente de Spring que contiene la lógica de negocio.
 */
@Service
public class ProcesService {

    @Autowired
    private ProcesRepository procesRepository;


    /**
     * Obtiene una lista de todos los procesos.
     * @return una lista de todos los procesos.
     */
    public List<ProcessEntity> getAllProces(){
        return  procesRepository.findAll();
    }

     /**
     * Obtiene un proceso por su identificador.
     * @param id el identificador del proceso.
     * @return un Optional que contiene el proceso si se encuentra, o vacío si no se encuentra.
     */
    public Optional<ProcessEntity> getByIdProces(Integer id){
        return procesRepository.findById(id);
    }

    

    /**
     * Guarda un proceso en la base de datos.
     * @param proces el proceso a guardar.
     * @return el proceso guardado.
     */
    public ProcessEntity saveProces(ProcessEntity proces){
        return procesRepository.save(proces);
    }

    /**
     * Elimina un proceso de la base de datos por su identificador. 
     * @param id el identificador del proceso a eliminar.
     */
    public void deleteByIdProces(Integer id){
         procesRepository.deleteById(id);
    }

}
