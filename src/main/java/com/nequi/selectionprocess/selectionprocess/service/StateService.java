package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.StateEntity;
import com.nequi.selectionprocess.selectionprocess.repository.StateRepository;

/**
 * StateService es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad State.
 * Está anotada con 
 * @Service para indicar que es un componente de Spring que
 * contiene la lógica de negocio.
 */
@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    /**
     * Obtiene una lista de todos los estados.
     * 
     * @return una lista de todos los estados.
     */
    public List<StateEntity> getAllState() {
        return stateRepository.findAll();
    }

    /**
     * Obtiene un estado por su identificador.
     * 
     * @param id el identificador del estado.
     * @return un Optional que contiene el estado si se encuentra, o vacío si no se
     *         encuentra.
     */
    public Optional<StateEntity> getByIdState(Integer id) {
        return stateRepository.findById(id);
    }

    /**
     * Obtiene una entidad de estado con un nombre similar al nombre proporcionado.
     * 
     * @param name El nombre (o parte del nombre) del estado a buscar.
     * @return Un Optional que contiene la entidad de estado encontrada, o un
     *         Optional vacío si no se encontró ningún estado.
     */
    public List<StateEntity> getByNameLikeState(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser nulo ni estar vacó");

        } else {

            return stateRepository.findOneNameLikeState(name);
        }

    }

    /**
     * Guarda un estado en la base de datos.
     * 
     * @param state el estado a guardar.
     * @return el estado guardado.
     */
    public List<StateEntity> saveState(List<StateEntity> state) {

        return stateRepository.saveAll(state);
    }

    /**
     * Actualiza un estado existente en la base de datos.
     * Busca un estado por su identificador y, si se encuentra,
     * actualiza sus campos con los valores proporcionados en el objeto `state`.
     *
     * @param id    el identificador del estado a actualizar
     * @param state el objeto `StateEntity` que contiene los nuevos valores de los
     *              campos
     * @return un `Optional<StateEntity>` que contiene el estado actualizado,
     *         o un `Optional.empty()` si no se encuentra un estado con el
     *         identificador proporcionado
     */
    public Optional<StateEntity> updateState(Integer id, StateEntity state) {
        return stateRepository.findById(id)
                .map(existingState -> {
                    existingState.setName(state.getName());
                    // Otros campos a actualizar
                    return stateRepository.save(existingState);
                });
    }

    /**
     * Elimina un estado de la base de datos por su identificador.
     * 
     * @param id el identificador del estado a eliminar.
     */
    public void deleteByIdState(Integer id) {
        stateRepository.deleteById(id);
    }

}
