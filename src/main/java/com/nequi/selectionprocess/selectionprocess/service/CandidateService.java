package com.nequi.selectionprocess.selectionprocess.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.selectionprocess.selectionprocess.entity.CandidateEntity;
import com.nequi.selectionprocess.selectionprocess.repository.CandidateRepository;

/**
 * CandidateService es una clase de servicio que maneja la lógica de negocios
 * relacionada con la entidad Candidate.
 * Está anotada con
 * 
 * @Service para indicar que es un componente de Spring que contiene la lógica
 *          de negocio.
 */
@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * Obtiene una lista de todos los candidatos.
     * 
     * @return una lista de todos los candidatos.
     */
    public List<CandidateEntity> getAllCandidate() {
        return candidateRepository.findAll();
    }

    /**
     * Obtiene un candidato por su identificador.
     * 
     * @param id el identificador del candidato.
     * @return un Optional que contiene el candidato si se encuentra, o vacío si no
     *         se encuentra.
     */
    public Optional<CandidateEntity> getByIdCandidate(Integer id) {
        return candidateRepository.findById(id);
    }

    /**
     * Busca candidatos cuyos nombres coincidan parcialmente con el valor
     * proporcionado.
     *
     * @param name El nombre o parte del nombre para buscar coincidencias.
     * @return Una lista de entidades CandidateEntity que coinciden parcialmente con
     *         el nombre especificado.
     * @throws IllegalArgumentException Si el nombre es nulo o está vacío.
     */
    public List<CandidateEntity> getByNameLikecCandidate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe ser nulo ni estar vacío");

        } else {

            return candidateRepository.findOneNameLikeCandidate(name);
        }

    }

    /**
     * Guarda un candidato en la base de datos.
     * 
     * @param candidate el candidato a guardar.
     * @return el candidato guardado.
     */
    public CandidateEntity saveCandidate(CandidateEntity candidate) {
        return candidateRepository.save(candidate);
    }

    /**
     * Actualiza la información de un candidato existente en el repositorio.
     *
     * @param id        El ID del candidato a actualizar.
     * @param candidate La entidad CandidateEntity con la información actualizada
     *                  del candidato.
     * @return Un Optional que contiene la entidad CandidateEntity actualizada, si
     *         se encontró un candidato con el ID especificado.
     *         Si no se encuentra un candidato con el ID especificado, se retorna un
     *         Optional vacío.
     */
    public Optional<CandidateEntity> updateCandidate(Integer id, CandidateEntity candidate) {
        return candidateRepository.findById(id)
                .map(existingCandidate -> {
                    existingCandidate.setName(candidate.getName());
                    // Otros campos a actualizar
                    return candidateRepository.save(existingCandidate);
                });
    }

    /**
     * Elimina un candidato de la base de datos por su identificador.
     * 
     * @param id el identificador del candidato a eliminar.
     */
    public void deleteByIdCandidate(Integer id) {
        candidateRepository.deleteById(id);
    }

}
