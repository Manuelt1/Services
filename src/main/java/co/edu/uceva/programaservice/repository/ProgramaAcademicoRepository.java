package co.edu.uceva.programaservice.repository;

import co.edu.uceva.programaservice.model.ProgramaAcademico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
    Page<ProgramaAcademico> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}
