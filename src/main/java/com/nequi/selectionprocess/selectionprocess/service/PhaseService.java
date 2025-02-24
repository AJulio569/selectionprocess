package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.PhaseEntity;
import com.nequi.selectionprocess.selectionprocess.repository.PhaseRepository;

/**
 * PhaseService es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad Phase.
 * Está anotada con
 * 
 * @Service para indicar que es un componente de Spring que contiene la lógica
 *          de negocio.
 */
@Service
public class PhaseService {

    @Autowired
    private PhaseRepository phaseRepository;

    /**
     * Obtiene una lista de todas las fases.
     * 
     * @return una lista de todas las fases.
     */
    public List<PhaseEntity> getAllPhase() {
        return phaseRepository.findAll();

    }

    /**
     * Obtiene una fase por su identificador.
     * 
     * @param id el identificador de la fase.
     * @return un Optional que contiene la fase si se encuentra, o vacío si no se
     *         encuentra.
     */
    public Optional<PhaseEntity> getByIdPhase(Integer id) {
        return phaseRepository.findById(id);
    }

    /**
     * Busca fases cuyos nombres coincidan parcialmente con el valor proporcionado.
     *
     * @param name El nombre o parte del nombre para buscar coincidencias.
     * @return Una lista de entidades PhaseEntity que coinciden parcialmente con el
     *         nombre especificado.
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     */
    public List<PhaseEntity> getByNameLikePhase(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser nulo ni estar vacó");

        } else {

            return phaseRepository.findOneNameLikePhase(name);
        }

    }

    /**
     * Guarda una fase en la base de datos.
     * 
     * @param phase la fase a guardar.
     * @return la fase guardada.
     */
    public PhaseEntity savePhase(PhaseEntity phase) {
        return phaseRepository.save(phase);
    }

    /**
     * Actualiza la información de una fase existente en el repositorio.
     *
     * @param id    El ID de la fase a actualizar.
     * @param phase La entidad PhaseEntity con la información actualizada de la
     *              fase.
     * @return Un Optional que contiene la entidad PhaseEntity actualizada, si se
     *         encontró una fase con el ID especificado.
     *         Si no se encuentra una fase con el ID especificado, se retorna un
     *         Optional vacío.
     */
    public Optional<PhaseEntity> updatePhase(Integer id, PhaseEntity phase) {
        return phaseRepository.findById(id)
                .map(existingPhase -> {
                    existingPhase.setName(phase.getName());
                    // Otros campos a actualizar
                    return phaseRepository.save(existingPhase);
                });
    }

    /**
     * Elimina una fase de la base de datos por su identificador.
     * 
     * @param id el identificador de la fase a eliminar.
     */
    public void deleteByIdPhase(Integer id) {
        phaseRepository.deleteById(id);
    }

}
