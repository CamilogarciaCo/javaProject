package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private List<String> paises;

    // Constructor para inicializar la lista de países
    public HelloWorldController() {
        paises = new ArrayList<>();
        paises.add("Colombia");
        paises.add("Argentina");
        paises.add("Peru");
        paises.add("Chile");
        paises.add("Venezuela");
        paises.add("Ecuador");
        paises.add("Brasil");
        paises.add("Uruguay");
        paises.add("Paraguay");
        paises.add("Bolivia");
    }

    // Método para saludar
    @GetMapping("/holi")
    public String sayHello() {
        return "Hola Mundo";
    }

    // Obtener todos los países
    @GetMapping("/paises")
    public List<String> getAllCountries() {
        return paises;
    }

    // Obtener un país por su ID
    @GetMapping("/paises/{idPais}")
    public ResponseEntity<String> getCountryById(@PathVariable int idPais) {
        if (idPais >= 0 && idPais < paises.size()) {
            return ResponseEntity.ok(paises.get(idPais));
        } else {
            return ResponseEntity.badRequest().body("País no encontrado");
        }
    }

    // Crear un nuevo país
    @PostMapping("/paises")
    public ResponseEntity<String> createCountry(@RequestBody String nuevoPais) {
        if (nuevoPais != null && !nuevoPais.isEmpty()) {
            paises.add(nuevoPais);
            return ResponseEntity.ok("País agregado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("Nombre de país inválido");
        }
    }

    // Actualizar un país existente
    @PutMapping("/paises/{idPais}")
    public ResponseEntity<String> updateCountry(@PathVariable int idPais, @RequestBody String nuevoNombre) {
        if (idPais >= 0 && idPais < paises.size()) {
            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                paises.set(idPais, nuevoNombre);
                return ResponseEntity.ok("País actualizado exitosamente");
            } else {
                return ResponseEntity.badRequest().body("Nombre de país inválido");
            }
        } else {
            return ResponseEntity.badRequest().body("País no encontrado");
        }
    }

    // Eliminar un país
    @DeleteMapping("/paises/{idPais}")
    public ResponseEntity<String> deleteCountry(@PathVariable int idPais) {
        if (idPais >= 0 && idPais < paises.size()) {
            paises.remove(idPais);
            return ResponseEntity.ok("País eliminado exitosamente");
        } else {
            return ResponseEntity.badRequest().body("País no encontrado");
        }
    }
}
