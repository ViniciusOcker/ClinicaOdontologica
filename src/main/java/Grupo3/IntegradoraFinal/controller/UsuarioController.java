package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
import Grupo3.IntegradoraFinal.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CriarUsuarioDTO criarUsuarioDTO){
        return new ResponseEntity<>(usuarioService.create(criarUsuarioDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getByAll(){
        return new ResponseEntity<>(usuarioService.getByAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CriarUsuarioDTO criarUsuarioDTO){
        return new ResponseEntity<>(usuarioService.update(id, criarUsuarioDTO), HttpStatus.CREATED);
    }
}
