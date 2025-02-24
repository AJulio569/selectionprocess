package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.JobProfileEntity;
import com.nequi.selectionprocess.selectionprocess.repository.JobProfileRepository;

/**
 * JobProfileServices es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad JobProfile.
 * Está anotada con
 * 
 * @Service para indicar que es un componente de Spring que contiene la lógica
 *          de negocio.
 */
@Service
public class JobProfileService {

    @Autowired
    private JobProfileRepository jobProfileRepository;

    /**
     * Obtiene una lista de todos los perfiles de trabajo.
     * 
     * @return una lista de todos los perfiles de trabajo.
     */
    public List<JobProfileEntity> getAllJobProfile() {
        return jobProfileRepository.findAll();

    }

    /**
     * Obtiene un perfil de trabajo por su identificador.
     * 
     * @param id el identificador del perfil de trabajo.
     * @return un Optional que contiene el perfil de trabajo si se encuentra, o
     *         vacío si no se encuentra.
     */
    public Optional<JobProfileEntity> getByIdJobProfile(Integer id) {
        return jobProfileRepository.findById(id);

    }

    /**
     * Busca una lista de perfiles de trabajo que coincidan parcialmente con el
     * nombre proporcionado.
     * Si el nombre es nulo o está vacío, lanza una excepción
     * `IllegalArgumentException`.
     * Utiliza el repositorio para buscar coincidencias en el nombre de los perfiles
     * de trabajo.
     *
     * @param name el nombre parcial para buscar coincidencias
     * @return una lista de objetos `JobProfileEntity` que coinciden con el nombre
     *         parcial proporcionado
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public List<JobProfileEntity> getByNameLikeJobProfile(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser nulo ni estar vacó");

        } else {

            return jobProfileRepository.findOneNameLikeJobProfile(name);
        }

    }

    /**
     * Guarda una lista de perfiles de trabajo en la base de datos.
     * Cada objeto `JobProfileEntity` en la lista proporcionada se guardará en la
     * base de datos.
     *
     * @param jobProfile la lista de objetos `JobProfileEntity` a guardar
     * @return una lista de objetos `JobProfileEntity` que han sido guardados
     */
    public List<JobProfileEntity> saveJobProfile(List<JobProfileEntity> jobProfile) {
        return jobProfileRepository.saveAll(jobProfile);
    }

    /**
     * Actualiza un perfil de trabajo existente en la base de datos.
     * Busca un perfil de trabajo por su identificador y, si se encuentra,
     * actualiza sus campos con los valores proporcionados en el objeto
     * `jobProfile`.
     *
     * @param id         el identificador del perfil de trabajo a actualizar
     * @param jobProfile el objeto `JobProfileEntity` que contiene los nuevos
     *                   valores de los campos
     * @return un `Optional<JobProfileEntity>` que contiene el perfil de trabajo
     *         actualizado,
     *         o un `Optional.empty()` si no se encuentra un perfil de trabajo con
     *         el identificador proporcionado
     */
    public Optional<JobProfileEntity> updateJobProfile(Integer id, JobProfileEntity jobProfile) {
        return jobProfileRepository.findById(id)
                .map(existingJob -> {
                    existingJob.setName(jobProfile.getName());
                    // Otros campos a actualizar
                    return jobProfileRepository.save(existingJob);
                });
    }

    /**
     * Elimina un perfil de trabajo de la base de datos por su identificador.
     * 
     * @param id el identificador del perfil de trabajo a eliminar.
     */
    public void deleteByIdJobProfile(Integer id) {
        jobProfileRepository.deleteById(id);
    }

}
