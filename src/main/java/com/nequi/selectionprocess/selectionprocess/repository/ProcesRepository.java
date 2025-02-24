package com.nequi.selectionprocess.selectionprocess.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nequi.selectionprocess.selectionprocess.entity.ProcessEntity;

/**
 * ProcessRepository es una interfaz de repositorio para la entidad Proceso.
 * Extiende JpaRepository para proporcionar operaciones CRUD y métodos de consulta personalizados.
 * Está anotada con @Repository para indicar que es un componente de Spring que interactúa con la base de datos.
 */
@Repository
public interface ProcesRepository extends JpaRepository<ProcessEntity ,Integer>{



   
}
