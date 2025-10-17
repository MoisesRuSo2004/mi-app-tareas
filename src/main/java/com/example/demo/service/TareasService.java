package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Tareas;
import com.example.demo.repository.TareasRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TareasService {
    private final TareasRepository tareasRepository;

    public TareasService(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }

    // CRUD

    // Método para obtener todas las tareas
    public List<Tareas> getAllTareas() {
        return tareasRepository.findAll();
    }

    // Método para crear tarea
    public void crearTarea(Tareas tarea) {
        tareasRepository.save(tarea);
    }

    // ✅ Método para obtener tarea por ID
    public Tareas getTareaById(Long id) {
        Optional<Tareas> tareaOptional = tareasRepository.findById(id);
        return tareaOptional.orElse(null); // o lanzar excepción si quieres
    }

    // Método para actualizar tarea
    public void actualizarTarea(Tareas tareaActualizada) {
        Optional<Tareas> tareaOptional = tareasRepository.findById(tareaActualizada.getId());
        if (tareaOptional.isPresent()) {
            Tareas tarea = tareaOptional.get();
            tarea.setTitulo(tareaActualizada.getTitulo());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setEstado(tareaActualizada.getEstado());
            tarea.setFecha(tareaActualizada.getFecha());
            tareasRepository.save(tarea);
        }
    }

    // Método para eliminar tarea
    public void eliminarTarea(Long id) {
        tareasRepository.deleteById(id);
    }
}
