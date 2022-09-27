package Grupo3.IntegradoraFinal.controller;

import Grupo3.IntegradoraFinal.entity.dto.*;
import Grupo3.IntegradoraFinal.entity.dto.error.UsuarioErrorDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.security.AuthenticationResponse;
import Grupo3.IntegradoraFinal.security.JwtUtil;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
import Grupo3.IntegradoraFinal.service.impl.UsuarioService;
import Grupo3.IntegradoraFinal.validation.UsuarioValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioValidation validation;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CriarUsuarioDTO criarUsuarioDTO) throws Exception {
        return new ResponseEntity<>(usuarioService.create(criarUsuarioDTO, false), HttpStatus.CREATED);
    }


    @PostMapping("/create/first")
    public ResponseEntity<?> createFirst(@RequestBody CriarUsuarioDTO criarUsuarioDTO) throws Exception {
        return new ResponseEntity<>(usuarioService.create(criarUsuarioDTO, true), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(usuarioService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getByAll() throws ResourceNotFoundException {
        return new ResponseEntity<>(usuarioService.getByAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(usuarioService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CriarUsuarioDTO criarUsuarioDTO) throws Exception {
        return new ResponseEntity<>(usuarioService.update(id, criarUsuarioDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody LoginDTO loginDTO) throws Exception {
        try {
            String erro = validation.validationNomeUsuario(loginDTO.getNomeUsuario());
            if ( erro == null){
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getNomeUsuario(), loginDTO.getSenha()));
            }else {
                throw new BadCredentialsException(erro);
            }

        } catch (BadCredentialsException e) {
            throw new BadRequestException("Incorrect: " + e);
        }
        final UserDetails userDetails = usuarioService.loadUserByUsername(loginDTO.getNomeUsuario());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
