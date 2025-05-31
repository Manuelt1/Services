package co.edu.uceva.programaservice.controller;

import co.edu.uceva.programaservice.model.ProgramaAcademico;
import co.edu.uceva.programaservice.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @GetMapping
    public List<ProgramaAcademico> listarTodos() {
        return programaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaAcademico> obtenerPorId(@PathVariable Long id) {
        return programaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProgramaAcademico guardar(@RequestBody ProgramaAcademico programa) {
        return programaService.save(programa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        programaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // búsqueda por nombre con paginación
    @GetMapping("/buscar")
    public ResponseEntity<Page<ProgramaAcademico>> buscarPorNombre(
            @RequestParam String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<ProgramaAcademico> resultados = programaService.buscarPorNombre(nombre, page, size);
        return ResponseEntity.ok(resultados);
    }
}
