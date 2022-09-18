package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarPacienteDTO;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CriarPacienteDTO criarPacienteDTO){
        return new ResponseEntity<>(pacienteService.create(criarPacienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(pacienteService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getByAll(){
        return new ResponseEntity<>(pacienteService.getByAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(pacienteService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CriarPacienteDTO criarPacienteDTO){
        return new ResponseEntity<>(pacienteService.update(id, criarPacienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<?> buscarPeloNomeCompleto(@RequestParam(required = false, defaultValue = "") String nome, @RequestParam(required = false, defaultValue = "") String sobrenome){
        return new ResponseEntity<>(pacienteService.findPaciente(nome, sobrenome), HttpStatus.OK);
    }
}