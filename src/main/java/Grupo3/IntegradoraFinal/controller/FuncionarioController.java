package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import Grupo3.IntegradoraFinal.service.impl.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/create")
    public FuncionarioDTO create(@RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.create(funcionarioDTO);
    }

    @GetMapping("/{id}")
    public FuncionarioDTO getById(@PathVariable int id){
        return funcionarioService.getById(id);
    }

    @GetMapping("/")
    public List<FuncionarioDTO> getByAll(){
        return funcionarioService.getByAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return funcionarioService.delete(id);
    }

    @PutMapping("/{id}")
    public FuncionarioDTO update(@PathVariable int id, @RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.update(id, funcionarioDTO);
    }

}

