package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.UsuarioErrorDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.repository.IUsuarioRepository;
import Grupo3.IntegradoraFinal.service.IService;
import Grupo3.IntegradoraFinal.validation.UsuarioValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IService<UsuarioDTO>, UserDetailsService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    UsuarioValidation validation;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioDTO create(CriarUsuarioDTO criarUsuarioDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioErrorDTO error = validation.validation(criarUsuarioDTO);
        if (error.getNomeUsuario() == null && error.getSenha() == null && error.getRole() == null){
            try{
                criarUsuarioDTO.setSenha(bCryptPasswordEncoder.encode(criarUsuarioDTO.getSenha()));
                return new UsuarioDTO(usuarioRepository.saveAndFlush(new UsuarioEntity(criarUsuarioDTO)));
            }
            catch (Exception e){
                error.setNomeUsuario("Esta conta já existe!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    @Override
    public UsuarioDTO getById(Long id) throws ResourceNotFoundException {
        return new UsuarioDTO(usuarioRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Não foi possivel localizar o id " + id + " de usuario!");
        }));
    }

    @Override
    public List<UsuarioDTO> getByAll() throws ResourceNotFoundException {
        List<UsuarioDTO> usuarioList = new ArrayList<>();
        for (UsuarioEntity usuario : usuarioRepository.findAll()) {
            usuarioList.add(new UsuarioDTO(usuario));
        }
        if(usuarioList.isEmpty()){
            throw new ResourceNotFoundException("Lista de Usuario está vazio");
        }
        return usuarioList;
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException {
        try{
            usuarioRepository.deleteById(id);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar o id " + id + " de usuario");
        }
        return "O usuario " + id + " foi deletado com sucesso!";
    }

    public UsuarioDTO update(Long id, CriarUsuarioDTO criarUsuarioDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioErrorDTO error = validation.validation(criarUsuarioDTO);
        if (error.getNomeUsuario() == null && error.getSenha() == null && error.getRole() == null){
            UsuarioEntity usuario = new UsuarioEntity(criarUsuarioDTO);
            usuario.setIdUsuario(id);
            try{
                usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
                return new UsuarioDTO(usuarioRepository.saveAndFlush(usuario));
            }
            catch (Exception e){
                error.setNomeUsuario("Este usuário não existe!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByNomeDeUsuario(username).orElseThrow(()->new UsernameNotFoundException("O nome de usuário não encontrado!"));
    }
}
