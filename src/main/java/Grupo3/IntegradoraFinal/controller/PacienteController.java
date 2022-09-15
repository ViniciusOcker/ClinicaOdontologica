package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarPacienteDTO;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/create")
    public PacienteDTO create(@RequestBody CriarPacienteDTO criarPacienteDTO){
        return pacienteService.create(criarPacienteDTO);
    }

    @GetMapping("/{id}")
    public PacienteDTO getById(@PathVariable Long id){
        return pacienteService.getById(id);
    }

    @GetMapping("/")
    public List<PacienteDTO> getByAll(){
        return pacienteService.getByAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return pacienteService.delete(id);
    }

    @PutMapping("/{id}")
    public PacienteDTO update(@PathVariable Long id, @RequestBody CriarPacienteDTO criarPacienteDTO){
        return pacienteService.update(id, criarPacienteDTO);
    }

    @GetMapping("/search")
    public List<PacienteDTO> buscarPeloNomeCompleto(@RequestParam String nomeCompleto){
        return pacienteService.findPaciente(nomeCompleto);
    }
}
