package Grupo3.IntegradoraFinal.serviceTest;


import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.service.impl.ConsultaService;
import Grupo3.IntegradoraFinal.service.impl.DentistaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class getByIdDentistaImplTest {

    @Autowired
    private DentistaService dentistaServiceImpl;

    @Test
    public void getByIdDentistaTest() throws BadRequestException, ResourceNotFoundException {
        dentistaServiceImpl.getById(2L);
        assertEquals("123", dentistaServiceImpl.findDentista("Paulo", "Santos"));
        assertEquals("123", String.valueOf(dentistaServiceImpl.getById(1L)));
    }
}
