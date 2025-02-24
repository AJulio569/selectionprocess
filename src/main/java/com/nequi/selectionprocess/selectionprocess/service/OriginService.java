package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.OriginEntity;

import com.nequi.selectionprocess.selectionprocess.repository.OriginRepository;

/**
 * OriginService es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad Origin.
 * Está anotada con
 * 
 * @Service para indicar que es un componente de Spring que contiene la lógica
 *          de negocio.
 */
@Service
public class OriginService {

    @Autowired
    private OriginRepository originRepository;

    /**
     * Obtiene una lista de todos los orígenes.
     * 
     * @return una lista de todos los orígenes.
     */
    public List<OriginEntity> getAllOrigin() {
        return originRepository.findAll();

    }

    /**
     * Obtiene un origen por su identificador.
     * 
     * @param id el identificador del origen.
     * @return un Optional que contiene el origen si se encuentra, o vacío si no se
     *         encuentra.
     */
    public Optional<OriginEntity> getByIdOrigin(Integer id) {
        return originRepository.findById(id);
    }

   /**
     * Obtiene una entidad de origen con un nombre similar al nombre proporcionado.
     * 
     * @param name El nombre (o parte del nombre) del estado a buscar.
     * @return Un Optional que contiene la entidad de estado encontrada, o un
     *         Optional vacío si no se encontró ningún estado.
     */
    public List<OriginEntity> getByNameLikeOrigin(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser nulo ni estar vacó");

        } else {

            return originRepository.findOneNameLikeOrigin(name);
        }

    }

    /**
     * Guarda una lista de orígenes en la base de datos.
     * Cada objeto `OriginEntity` en la lista proporcionada se guardará en la base
     * de datos.
     *
     * @param origin la lista de objetos `OriginEntity` a guardar
     * @return una lista de objetos `OriginEntity` que han sido guardados
     */
    public List<OriginEntity> saveOrigin(List<OriginEntity> origin) {
        return originRepository.saveAll(origin);
    }

    /**
     * Actualiza un origen existente en la base de datos.
     * Busca un origen por su identificador y, si se encuentra,
     * actualiza sus campos con los valores proporcionados en el objeto `origin`.
     *
     * @param id     el identificador del origen a actualizar
     * @param origin el objeto `OriginEntity` que contiene los nuevos valores de los
     *               campos
     * @return un `Optional<OriginEntity>` que contiene el origen actualizado,
     *         o un `Optional.empty()` si no se encuentra un origen con el
     *         identificador proporcionado
     */
    public Optional<OriginEntity> updateOrigin(Integer id, OriginEntity origin) {
        return originRepository.findById(id)
                .map(existingOrigin -> {
                    existingOrigin.setName(origin.getName());
                    // Otros campos a actualizar
                    return originRepository.save(existingOrigin);
                });
    }

    /**
     * Elimina un origen de la base de datos por su identificador.
     * 
     * @param id el identificador del origen a eliminar.
     */
    public void deleteByIdOrigin(Integer id) {

        originRepository.deleteById(id);
    }

}
