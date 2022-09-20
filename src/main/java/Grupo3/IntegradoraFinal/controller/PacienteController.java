package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarPacienteDTO;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
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
    public ResponseEntity<?> create(@RequestBody CriarPacienteDTO criarPacienteDTO) throws Exception {
        return new ResponseEntity<>(pacienteService.create(criarPacienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(pacienteService.getById(id), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel localizar o id " + id + " de paciente!");
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getByAll() throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(pacienteService.getByAll(), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel obter uma lista de Paciente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(pacienteService.delete(id), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar o id " + id + " de paciente");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CriarPacienteDTO criarPacienteDTO) throws Exception {
        return new ResponseEntity<>(pacienteService.update(id, criarPacienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<?> buscarPeloNomeCompleto(@RequestParam(required = false, defaultValue = "") String nome, @RequestParam(required = false, defaultValue = "") String sobrenome){
        return new ResponseEntity<>(pacienteService.findPaciente(nome, sobrenome), HttpStatus.OK);
    }
}