package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaService dentistaService;

    @PostMapping("/create")
    public DentistaDTO create(@RequestBody CriarDentistaDTO criarDentistaDTO){
        return dentistaService.create(criarDentistaDTO );
    }

    @GetMapping("/{id}")
    public DentistaDTO getById(@PathVariable Long id){
        return dentistaService.getById(id);
    }

    @GetMapping("/")
    public List<DentistaDTO> getByAll(){
        return dentistaService.getByAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return dentistaService.delete(id);
    }

    @PutMapping("/{id}")
    public DentistaDTO update(@PathVariable Long id, @RequestBody DentistaDTO dentistaDTO){
        return dentistaService.update(id, dentistaDTO);
    }

}

