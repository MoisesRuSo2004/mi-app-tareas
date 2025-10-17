package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;
import com.example.demo.model.Tareas;
import com.example.demo.service.TareasService;

@Controller
public class TareasController {
    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    @GetMapping("/")
    public String home() {
        // Devuelve el nombre de la vista que está en templates/bienvenido.html
        return "/html/index";
    }

    @GetMapping("/tareas")
    public String getTareas(Model model) {
        List<Tareas> tareas = tareasService.getAllTareas();
        model.addAttribute("tareas", tareas);
        return "/html/tasks";
    }

    @GetMapping("/registrar")
    public String getRegistrar(Model model) {
        model.addAttribute("tarea", new Tareas());
        return "html/register";
    }

    @PostMapping("/registrar")
    public String crearTarea(@ModelAttribute Tareas tarea) {
        tareasService.crearTarea(tarea);
        return "redirect:/tareas"; // redirige a la lista de tareas
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarTarea(@PathVariable Long id, Model model) {
        Tareas tarea = tareasService.getTareaById(id);
        model.addAttribute("tarea", tarea);
        return "/html/register"; // reutilizamos la misma vista de register
    }

    // Procesar actualización
    @PostMapping("/editar")
    public String actualizarTarea(@ModelAttribute Tareas tarea) {
        tareasService.actualizarTarea(tarea);
        return "redirect:/tareas?updated=true"; // redirigimos con flag para toast
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareasService.eliminarTarea(id);
        return "redirect:/tareas?deleted=true";
    }

}
