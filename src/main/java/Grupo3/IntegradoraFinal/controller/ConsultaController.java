package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.service.impl.ConsultaService;
import Grupo3.IntegradoraFinal.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CriarConsultaDTO criarConsultaDTO){
        return new ResponseEntity<>(consultaService.create(criarConsultaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(consultaService.getById(id), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel localizar o id " + id + " de consulta!");
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getByAll() throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(consultaService.getByAll(), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel obter uma lista de Consulta");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(consultaService.delete(id), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar o id " + id + " de consulta");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CriarConsultaDTO criarConsultaDTO){
        return new ResponseEntity<>(consultaService.update(id, criarConsultaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/dentista/{id}")
    public ResponseEntity<?> getByIdDentista(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(consultaService.getByIdDentista(id), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel obter uma lista de consultas o id de Dentista " + id );
        }
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<?> getByIdPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return new ResponseEntity<>(consultaService.getByIdPaciente(id), HttpStatus.OK);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel obter uma lista de consultas o id de Paciente " + id );
        }
    }
}
