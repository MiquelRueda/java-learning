package com.miquelrueda.todo_api.service;

import com.miquelrueda.todo_api.model.Tarea;
import com.miquelrueda.todo_api.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;

    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Tarea findById(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id));
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea update(Long id, Tarea tareaActualizada) {
        Tarea tarea = findById(id);
        tarea.setTitulo(tareaActualizada.getTitulo());
        tarea.setDescripcion(tareaActualizada.getDescripcion());
        tarea.setCompletada(tareaActualizada.getCompletada());
        return tareaRepository.save(tarea);
    }

    public void deleteById(Long id) {
        findById(id); // lanza excepción si no existe
        tareaRepository.deleteById(id);
    }
}