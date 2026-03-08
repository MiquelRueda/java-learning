package com.miquelrueda.todo_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
public class InfoController {

    // Record de Java: inmutable, sin setters, con equals/hashCode automáticos
    record InfoResponse(String name, String version, LocalDate date) {}

    @GetMapping("/info")
    public InfoResponse info() {
        return new InfoResponse(
                "todo-api",
                "1.0.0",
                LocalDate.now()
        );
    }
}