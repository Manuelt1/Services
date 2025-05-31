package co.edu.uceva.programaservice.service;

import co.edu.uceva.programaservice.model.ProgramaAcademico;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface ProgramaService {
    List<ProgramaAcademico> findAll();
    Optional<ProgramaAcademico> findById(Long id);
    ProgramaAcademico save(ProgramaAcademico programa);
    void delete(Long id);

    // búsqueda con paginación
    Page<ProgramaAcademico> buscarPorNombre(String nombre, int page, int size);
}
