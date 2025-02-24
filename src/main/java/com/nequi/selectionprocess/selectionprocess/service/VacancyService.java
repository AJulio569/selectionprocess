package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nequi.selectionprocess.selectionprocess.entity.VacancyEntity;
import com.nequi.selectionprocess.selectionprocess.repository.VacancyRepository;

/**
 * VacancyService es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad Vacancy.
 * Está anotada con
 * 
 * @Service para indicar que es un componente de Spring que contiene la lógica
 *          de negocio.
 */
@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    /**
     * Obtiene una lista de todas las vacantes.
     * 
     * @return una lista de todas las vacantes.
     */
    public List<VacancyEntity> getAllVacancy() {
        return vacancyRepository.findAll();
    }

    /**
     * Obtiene una vacante por su identificador.
     * 
     * @param id el identificador de la vacante.
     * @return un Optional que contiene la vacante si se encuentra, o vacío si no se
     *         encuentra.
     */
    public Optional<VacancyEntity> getByIdVacancy(Integer id) {
        return vacancyRepository.findById(id);


    }

    /**
     * Guarda una vacante en la base de datos.
     * 
     * @param vacancy la vacante a guardar.
     * @return la vacante guardada.
     */
    public VacancyEntity saveVacancy(VacancyEntity vacancy) {
        return vacancyRepository.save(vacancy);
    }


    /**
     * Actualiza la información de una vacante existente en el repositorio.
     *
     * @param id      El ID de la vacante a actualizar.
     * @param vacancy La entidad VacancyEntity con la información actualizada de la
     *                vacante.
     * @return Un Optional que contiene la entidad VacancyEntity actualizada, si se
     *         encontró una vacante con el ID especificado.
     *         Si no se encuentra una vacante con el ID especificado, se retorna un
     *         Optional vacío.
     */
    public Optional<VacancyEntity> updateVacancy(Integer id, VacancyEntity vacancy) {
        return vacancyRepository.findById(id)
                .map(existingVacancy -> {
                    existingVacancy.setSkill(vacancy.getSkill());
                    // Otros campos a actualizar
                    return vacancyRepository.save(existingVacancy);
                });
    }


    /**
     * Elimina una vacante de la base de datos por su identificador.
     * 
     * @param id el identificador de la vacante a eliminar.
     */
    public void deleteByIdVacancy(Integer id) {
        vacancyRepository.deleteById(id);

    }

}
