package com.miquelrueda.todo_api;

import com.miquelrueda.todo_api.model.Tarea;
import com.miquelrueda.todo_api.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @GetMapping
    public List<Tarea> getAll() {
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public Tarea getById(@PathVariable Long id) {
        return tareaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea create(@RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }

    @PutMapping("/{id}")
    public Tarea update(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.update(id, tarea);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tareaService.deleteById(id);
    }
}