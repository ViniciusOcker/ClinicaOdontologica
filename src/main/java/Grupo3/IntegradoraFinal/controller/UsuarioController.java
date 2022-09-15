package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
import Grupo3.IntegradoraFinal.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/create")
    public UsuarioDTO create(@RequestBody CriarUsuarioDTO criarUsuarioDTO){
        return usuarioService.create(criarUsuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id){
        return usuarioService.getById(id);
    }

    @GetMapping("/")
    public List<UsuarioDTO> getByAll(){
        return usuarioService.getByAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody CriarUsuarioDTO criarUsuarioDTO){
        return usuarioService.update(id, criarUsuarioDTO);
    }
}
