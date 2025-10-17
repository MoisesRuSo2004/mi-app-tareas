package com.example.demo.repository;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Tareas;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Long> {

    List<Tareas> findByTitulo(String titulo);

    List<Tareas> findByEstado(String estado);

    List<Tareas> findByFecha(LocalDate fecha);
}
