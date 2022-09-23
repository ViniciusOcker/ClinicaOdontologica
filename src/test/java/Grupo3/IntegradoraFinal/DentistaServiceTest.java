/*package Grupo3.IntegradoraFinal;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.repository.IDentistaRepository;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
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
public class DentistaServiceTest {

    @Autowired
    private DentistaService dentistaService;
    @Autowired
    private IDentistaRepository dentistaRepository;
    CriarDentistaDTO criarDentistaDTO = new CriarDentistaDTO("Jesse","Pinkman", "33");
    DentistaEntity dentista = new DentistaEntity(1L);
    @Test
    public void criarDentista(){
        DentistaDTO dto = dentistaService.create(criarDentistaDTO);
        assertEquals("Jesse",criarDentistaDTO.getNome());
        assertEquals("Pinkman",criarDentistaDTO.getSobrenome());
        assertEquals("33654654/RJ",criarDentistaDTO.getCro());
    }

    @Test
    public void getByIdTest(){
        DentistaDTO dto = new DentistaDTO(dentista);
        assertEquals(1,dentista.getIdDentista());
    }

    @Test
    public void deleteDentista(){
     dentistaService.delete(1L);
        Optional<DentistaEntity> optionalDentistaEntity = dentistaRepository.findById(1L);
        assertFalse(optionalDentistaEntity.isPresent());
    }

    @Test
    public void getByAllTest(){
        dentistaService.getByAll();
        List<DentistaDTO> dentistaDTOList = new ArrayList<>();
        assertTrue(dentistaDTOList != null);
    }

    @Test
    public void updateTest(){
        criarDentistaDTO.setCro("100");
        dentistaService.update(1L,criarDentistaDTO);
        assertEquals("100", criarDentistaDTO.getCro());
        assertNotEquals("1",criarDentistaDTO.getCro());
    }
}*/
