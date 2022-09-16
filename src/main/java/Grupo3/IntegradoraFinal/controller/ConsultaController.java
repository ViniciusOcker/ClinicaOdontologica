package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.service.impl.ConsultaService;
import Grupo3.IntegradoraFinal.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping("/create")
    public ConsultaDTO create(@RequestBody CriarConsultaDTO criarConsultaDTO){
        return consultaService.create(criarConsultaDTO);
    }

    @GetMapping("/{id}")
    public ConsultaDTO getById(@PathVariable Long id){
        return consultaService.getById(id);
    }

    @GetMapping("/")
    public List<ConsultaDTO> getByAll(){
        return consultaService.getByAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return consultaService.delete(id);
    }

    @PutMapping("/{id}")
    public ConsultaDTO update(@PathVariable Long id, @RequestBody CriarConsultaDTO criarConsultaDTO){
        return consultaService.update(id, criarConsultaDTO);
    }
}
