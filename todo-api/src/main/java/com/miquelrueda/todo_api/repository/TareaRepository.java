package com.miquelrueda.todo_api.repository;

import com.miquelrueda.todo_api.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;a

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Sin código: JPA nos da findAll, findById, save, deleteById gratis
}