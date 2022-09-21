package Grupo3.IntegradoraFinal.DTOTest;

import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DentistaDTOTest {
    @SpringBootTest
    @ExtendWith(SpringExtension.class)
    @WebAppConfiguration
    public static class DentistaDTest {

        @Autowired
        private DentistaDTO dentistaDTO;

        @Test
        public void DentistaTest(){
            DentistaDTO dentistaDTO1 = new DentistaDTO();
            dentistaDTO1.setNome("Paulo");
            dentistaDTO1.setSobrenome("Carvalho");
            dentistaDTO1.setCro("CRO-17055522");


            assertEquals("Paulo", dentistaDTO1.getNome());
            assertEquals("Carvalho", dentistaDTO1.getSobrenome());
            assertEquals("CRO-17055522", dentistaDTO1.getCro());

        }

    }
}
