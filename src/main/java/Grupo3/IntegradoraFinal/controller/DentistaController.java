package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaService dentistaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CriarDentistaDTO criarDentistaDTO) throws Exception {
        return new ResponseEntity<>(dentistaService.create(criarDentistaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(dentistaService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getByAll() throws ResourceNotFoundException {
        return new ResponseEntity<>(dentistaService.getByAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(dentistaService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CriarDentistaDTO criarDentistaDTO) throws Exception {
        return new ResponseEntity<>(dentistaService.update(id, criarDentistaDTO), HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public ResponseEntity<?> buscarPeloNomeCompleto(@RequestParam(required = false, defaultValue = "") String nome, @RequestParam(required = false, defaultValue = "") String sobrenome) throws BadRequestException {
        return new ResponseEntity<>(dentistaService.findDentista(nome, sobrenome), HttpStatus.OK);
    }
}

