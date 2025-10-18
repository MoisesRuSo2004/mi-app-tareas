package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/crear-usuario")
    public String crearUsuario() {
        try {
            jdbcTemplate.execute("""
                        CREATE USER 'devmoises'@'%' IDENTIFIED WITH mysql_native_password BY 'soloDios2004';
                        GRANT ALL PRIVILEGES ON tareasdb.* TO 'devmoises'@'%';
                        FLUSH PRIVILEGES;
                    """);
            return "Usuario creado exitosamente";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
