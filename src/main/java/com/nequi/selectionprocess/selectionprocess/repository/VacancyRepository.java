package com.nequi.selectionprocess.selectionprocess.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nequi.selectionprocess.selectionprocess.entity.VacancyEntity;

/**
 * VacancyRepository es una interfaz de repositorio para la entidad Vacancy.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface VacancyRepository  extends JpaRepository<VacancyEntity,Integer>{

     /**
     * Busca vacantes cuyos identificadores contienen el valor especificado.
     * @param id el valor a buscar en los identificadores de las vacantes.
     * @return una lista de vacantes cuyos identificadores contienen el valor dado.
     */
    // List<VacancyEntity> findByIdContainingVacancy(Integer id);



    

}
