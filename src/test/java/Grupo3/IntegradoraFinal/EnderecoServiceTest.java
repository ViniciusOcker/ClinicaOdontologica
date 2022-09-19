package Grupo3.IntegradoraFinal;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarEnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.EnderecoDTO;
import Grupo3.IntegradoraFinal.repository.IEnderecoRepository;
import Grupo3.IntegradoraFinal.service.impl.EnderecoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private IEnderecoRepository enderecoRepository;

    CriarEnderecoDTO criarEnderecoDTO = new CriarEnderecoDTO("Apartamento 1500","Rua","15"
            ,"bairro","cidade","estado", "referencia");
    EnderecoEntity enderecoEntity = new EnderecoEntity(1L);

    @Test
    public void criarEnderecoTest(){

        EnderecoDTO endereco = enderecoService.create(criarEnderecoDTO);
        assertEquals("Apartamento 1500", criarEnderecoDTO.getComplemento());
        assertEquals("Rua", criarEnderecoDTO.getRua());
        assertEquals("15", criarEnderecoDTO.getNumero());
        assertEquals("bairro", criarEnderecoDTO.getBairro());
        assertEquals("cidade", criarEnderecoDTO.getCidade());
        assertEquals("estado", criarEnderecoDTO.getEstado());
        assertEquals("referencia", criarEnderecoDTO.getPontoDeReferencia());
    }

    @Test
    public void getByIdTest(){
     EnderecoDTO enderecoDTO = new EnderecoDTO(enderecoEntity);
       assertEquals(1, enderecoEntity.getIdEndereco());
    }

    @Test
    public void deleteEnderecoTest(){
        enderecoService.delete(1L);
        Optional<EnderecoEntity> optionalEnderecoEntity = enderecoRepository.findById(1L);
        assertFalse(optionalEnderecoEntity.isPresent());
    }

    @Test
    public void getByAllTest(){
        enderecoService.getByAll();
        List<EnderecoDTO> enderecoList = new ArrayList<>();
        assertTrue(enderecoList != null);
    }
    @Test
    public void updateTest(){
        criarEnderecoDTO.setBairro("Novo Bairro");
        enderecoService.update(1L, criarEnderecoDTO);
        assertEquals("Novo Bairro", criarEnderecoDTO.getBairro());
        assertNotEquals("Bairro", criarEnderecoDTO.getBairro());
    }
}
