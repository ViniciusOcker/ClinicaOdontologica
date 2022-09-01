package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/create")
    public PacienteDTO create(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.create(pacienteDTO);
    }

    @GetMapping("/{id}")
    public PacienteDTO getById(@PathVariable int id){
        return pacienteService.getById(id);
    }

    @GetMapping("/")
    public List<PacienteDTO> getByAll(){
        return pacienteService.getByAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return pacienteService.delete(id);
    }

    @PutMapping("/{id}")
    public PacienteDTO update(@PathVariable int id, @RequestBody PacienteDTO pacienteDTO){
        return pacienteService.update(id, pacienteDTO);
    }
}