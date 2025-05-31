package co.edu.uceva.programaservice.service;

import co.edu.uceva.programaservice.model.ProgramaAcademico;
import co.edu.uceva.programaservice.repository.ProgramaAcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaAcademicoRepository repository;

    @Override
    public List<ProgramaAcademico> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProgramaAcademico> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ProgramaAcademico save(ProgramaAcademico programa) {
        return repository.save(programa);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<ProgramaAcademico> buscarPorNombre(String nombre, int page, int size) {
        return repository.findByNombreContainingIgnoreCase(nombre, PageRequest.of(page, size));
    }
}
